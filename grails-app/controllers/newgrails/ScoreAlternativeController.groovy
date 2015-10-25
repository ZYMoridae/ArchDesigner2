package newgrails

import grails.converters.JSON

import java.lang.reflect.Array

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ScoreAlternativeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])


        respond ScoreAlternative.list(params), model:[scoreAlternativeCount: ScoreAlternative.count(), userApplication: currentApp]
    }

    def calculateScore() {

        //Step2. Calculate the quality pairwise
        def calApp = newgrails.ArchApplication.find("from ArchApplication as c where c.id=:myappname", [myappname: Long.valueOf(params.applicationid)], [cache: true])


        def targetPQL = newgrails.PairwiseQuality.findAll("from PairwiseQuality as c where c.app=:myapp", [myapp: calApp], [cache: true])

        def qualityAL = Quality.getAll()

        double[][] qualityAttributes = new double[qualityAL.size()][qualityAL.size()];

        for (int i = 0; i < targetPQL.size(); i++) {
            if (targetPQL.get(i).weight == 0){
                def testData = [tester: "The pairwisequality weight could not be set into 0!"]
                render testData as JSON
            }
        }

        //Computing the each individual entry
        for (int i = 0; i < qualityAttributes.length; i++) {
            for (int j = 0; j < qualityAttributes[i].length; j++) {
                def tempPQL = PairwiseQuality.findAll("from PairwiseQuality as c where c.firstquality=:myfq and c.secondquality=:mysq and c.app=:myapp", [myfq: qualityAL.get(i), mysq: qualityAL.get(j), myapp: calApp])
                if(tempPQL.size()>0){
                    def resultPS = 0
                    for (int k = 0; k < tempPQL.size(); k++) {
                        if (tempPQL.get(k).weight < 0){
                            resultPS += -1/tempPQL.get(k).weight;
                        }else{
                            resultPS += tempPQL.get(k).weight;
                        }
                    }
                    resultPS = Math.pow(resultPS, 1.0/tempPQL.size());
                    qualityAttributes[i][j] = resultPS;
                }
            }
        }

//        def testresult1 = [testres: qualityAttributes]
//        render testresult1 as JSON

        // Computing the geometric mean
        double[] geometricMean = new double[qualityAL.size()]
        for (int i = 0; i < geometricMean.length; i++) {
            def tempGeometricMean = 0
            for (int j = 0; j < qualityAttributes[i].length; j++) {
                tempGeometricMean += qualityAttributes[i][j]
            }
            tempGeometricMean = Math.pow(tempGeometricMean, 1.0/geometricMean.length)
            geometricMean[i] = tempGeometricMean
        }


        //Computing the relative weight
        double[] relativeWeight = new double[qualityAL.size()]
        def sumWeight = 0
        for (int i = 0; i < geometricMean.length; i++) {
            sumWeight += geometricMean[i];
        }
        for (int i = 0; i < relativeWeight.length; i++) {
            relativeWeight[i] = geometricMean[i]/sumWeight;
        }


        //Step3. Start the pairwiserealtive calculating


        //Validate the weight of the pairwisealternative
        def targetPAL = newgrails.PairwiseAlternative.findAll("from PairwiseAlternative as c where c.app=:myapp", [myapp: calApp], [cache: true])
        def alternativeAL = newgrails.Alternative.getAll();

        for (int i = 0; i < targetPAL.size(); i++) {
            if (targetPAL.get(i).weight == 0){
                def testData = [tester: "The pairwisequality weight could not be set into 0!"]
                render testData as JSON
            }
        }

        //Computing the alternative for each individual entry
        ArrayList<double[][]> allMatrix = new ArrayList<>();

        for (int i = 0; i < qualityAL.size(); i++) {
            double[][] alternativeAttributes= new double[alternativeAL.size()][alternativeAL.size()];
            allMatrix.add(alternativeAttributes);
        }

        for (int i = 0; i < allMatrix.size(); i++) {
            for (int j = 0; j < allMatrix.get(i).length; j++) {
                for (int k = 0; k < allMatrix.get(i)[j].length; k++) {
                    def tempPAL = PairwiseAlternative.findAll("from PairwiseAlternative as c where c.firstalter=:myfa and c.secondalter=:mysa and c.app=:myapp and c.quality=:myquality", [myfa: alternativeAL.get(j), mysa: alternativeAL.get(k), myapp: calApp, myquality: qualityAL.get(i)])
                    if(tempPAL.size()>0) {
                        def resultPS = 0
                        for (int l = 0; l < tempPAL.size(); l++) {
                            if (tempPAL.get(l).weight < 0) {
                                resultPS += -1 / tempPAL.get(l).weight;
                            } else {
                                resultPS += tempPAL.get(l).weight;
                            }
                        }
                        resultPS = Math.pow(resultPS, 1.0 / tempPAL.size());
                        allMatrix.get(i)[j][k] = resultPS;
                    }
                }
            }
        }

        //Computing the geometric mean alternative
        ArrayList<double[]> allGeometricMeanMatrix = new ArrayList<>();

        for (int i = 0; i < qualityAL.size(); i++) {
            double[] tempGeoMetricMean= new double[alternativeAL.size()];
            allGeometricMeanMatrix.add(tempGeoMetricMean);
        }

        for (int i = 0; i < allGeometricMeanMatrix.size(); i++) {
            for (int j = 0; j < allMatrix.get(i).length; j++) {
                def tempGeoMean = 0
                for (int k = 0; k < allMatrix.get(i)[j].length; k++) {
                    tempGeoMean += allMatrix.get(i)[j][k]
                }
                tempGeoMean = Math.pow(tempGeoMean, 1.0/alternativeAL.size())
                allGeometricMeanMatrix.get(i)[j] = tempGeoMean
            }
        }


        //Computing the relative alternative
        ArrayList<double[]> allRelativeMatrix = new ArrayList<>();
        for (int i = 0; i < qualityAL.size(); i++) {
            double[] tempRelativeWeight= new double[alternativeAL.size()];
            allRelativeMatrix.add(tempRelativeWeight);
        }

        for (int i = 0; i < allRelativeMatrix.size(); i++) {
            def sumRelativeWeight = 0
            for (int j = 0; j < allGeometricMeanMatrix.get(i).length; j++) {
                sumRelativeWeight += allGeometricMeanMatrix.get(i)[j]
            }
            for (int j = 0; j < allRelativeMatrix.get(i).length; j++) {
                allRelativeMatrix.get(i)[j] = allGeometricMeanMatrix.get(i)[j]/sumRelativeWeight
            }
        }



        //Step4. Computing Value Score & Choose highest score
        def decList = newgrails.Decision.getAll()
        Double[][] finalValueScores = new Double[alternativeAL.size()][decList.size()]

        for (int i = 0; i < finalValueScores.length; i++) {
            for (int j = 0; j < finalValueScores[i].length; j++) {
                def sumScore = 0
                for (int k = 0; k < qualityAL.size(); k++) {
                    sumScore += relativeWeight[k]*allRelativeMatrix.get(k)[i]
                }
                finalValueScores[i][j] = sumScore
            }
        }

        String bestAlternative = ""
        String bestDecision = ""
        Double currentBest = 0;
        for (int i = 0; i < finalValueScores.length; i++) {
            for (int j = 0; j < finalValueScores[i].length; j++) {
                if (finalValueScores[i][j] >= currentBest){
                    currentBest = finalValueScores[i][j]
                    bestAlternative = alternativeAL.get(i).alternativeName
                    bestDecision = decList.get(j).decisionName
                }
            }
        }

        def finalData = [bestalter: bestAlternative, bestdec: bestDecision]
        render finalData as JSON
    }


    def show(ScoreAlternative scoreAlternative) {
        respond scoreAlternative
    }

    def create() {
        respond new ScoreAlternative(params)
    }

    @Transactional
    def save(ScoreAlternative scoreAlternative) {
        if (scoreAlternative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (scoreAlternative.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond scoreAlternative.errors, view:'create'
            return
        }

        scoreAlternative.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'scoreAlternative.label', default: 'ScoreAlternative'), scoreAlternative.id])
                redirect scoreAlternative
            }
            '*' { respond scoreAlternative, [status: CREATED] }
        }
    }

    def edit(ScoreAlternative scoreAlternative) {
        respond scoreAlternative
    }

    @Transactional
    def update(ScoreAlternative scoreAlternative) {
        if (scoreAlternative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (scoreAlternative.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond scoreAlternative.errors, view:'edit'
            return
        }

        scoreAlternative.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'scoreAlternative.label', default: 'ScoreAlternative'), scoreAlternative.id])
                redirect scoreAlternative
            }
            '*'{ respond scoreAlternative, [status: OK] }
        }
    }

    @Transactional
    def delete(ScoreAlternative scoreAlternative) {

        if (scoreAlternative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        scoreAlternative.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'scoreAlternative.label', default: 'ScoreAlternative'), scoreAlternative.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'scoreAlternative.label', default: 'ScoreAlternative'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
