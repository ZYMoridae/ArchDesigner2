package newgrails

import com.google.gson.Gson
import grails.converters.JSON
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CombinationCentricController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])

        def tempDec = newgrails.Decision.findAllByAppInList(currentApp)

        def currentDec = null
        if (tempDec.size()>0){
            currentDec = tempDec
        }

        respond CombinationCentric.list(params), model:[userApp: currentApp, userDecision: currentDec, combinationCentricCount: CombinationCentric.count()]
    }

    def generate(){
        respond view: 'generate'
    }

    /**
     * Generate the report based on the ajax
     *
     * @return
     */
    def generateReport(){

        def finalData = null
        if(Long.valueOf(params.applicationid)==-1){
            finalData = null
        }else{
            finalData = generateAllDiagram(params.applicationid)
        }

        render finalData as JSON
    }

    /**
     * Execute the report generation
     *
     * @param applicationid
     * @return
     */
    private Object generateAllDiagram(String applicationid){

        //Fetch all the realte d information
        def currentApp = newgrails.ArchApplication.find("from ArchApplication as c where c.user=:myuser and c.id=:appid", [myuser: session.user, appid: Long.valueOf(applicationid)], [cache: true])

        def allDec = newgrails.Decision.findAll("from Decision as c where c.app=:myapp", [myapp: currentApp])

        if (allDec.size() == 0){
            return null
        }

        def currentDec = allDec.get(0)

        def qualityPairwiseList = newgrails.PairwiseQuality.findAll("from PairwiseQuality as c where c.app=:myapp and c.decision=:mydec", [myapp: currentApp, mydec: currentDec])

        def stakeholderList = newgrails.Stakeholder.findAll("from Stakeholder as c where c.app=:myapp", [myapp: currentApp])

        def qualityList = newgrails.Quality.findAll("from Quality as c where c.app=:myapp", [myapp: currentApp])


        //Calculate the sum of the weight
        double sumWeight = 0.0

        for (int i = 0; i < qualityPairwiseList.size(); i++) {
            if (qualityPairwiseList.get(i).weight < 0){
                sumWeight += -1.0/qualityPairwiseList.get(i).weight;
            }else{
                sumWeight += qualityPairwiseList.get(i).weight;
            }
        }

        sumWeight = 2 * sumWeight


        ArrayList<ArrayList<Double>> weightResult= new ArrayList<>();

        //Iterate the stakholderlist and qualitylist to generate the report
        for (int i = 0; i < stakeholderList.size(); i++) {
            ArrayList<Double> tempList = new ArrayList<>();
            for (int j = 0; j < qualityList.size(); j++) {
                def tempQualityList = newgrails.PairwiseQuality.findAll("from PairwiseQuality as c where c.app=:myapp and c.decision=:mydec and c.stakeholder=:mystk or c.firstquality=:myfq or c.secondquality=:mysq", [myapp: currentApp, mydec: currentDec, mystk: stakeholderList.get(i), myfq: qualityList.get(j), mysq: qualityList.get(j)])
                double tempSum = 0.0
                if (tempQualityList.size()>0){
                    for (int k = 0; k < tempQualityList.size(); k++) {
                        if (tempQualityList.get(k).weight < 0){
                            tempSum += -1.0/tempQualityList.get(k).weight
                        }else{
                            tempSum += tempQualityList.get(k).weight
                        }
                    }
                    tempList.add(tempSum/sumWeight)
                }else{
                    tempList.add(tempSum/sumWeight)
                }
            }
            weightResult.add(tempList)
        }

        //Construct the json data format
        JSONArray resultLabel = new JSONArray()
        for (int i = 0; i < qualityList.size(); i++) {
            resultLabel.put(qualityList.get(i).qualityName.toString())
        }

        JSONArray dataSets = new JSONArray()
        for (int i = 0; i < stakeholderList.size(); i++) {
            JSONObject tempJsonObject = new JSONObject()
            int myColor = (int)(Math.random()*255)
            int myColor1 = (int)(Math.random()*255)
            int myColor2 = (int)(Math.random()*255)
            tempJsonObject.put("label", stakeholderList.get(i).stakeholderName)
            tempJsonObject.put("fillColor", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",0.5)")
            tempJsonObject.put("strokeColor", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",0.8)")
            tempJsonObject.put("highlightFill", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",0.75)")
            tempJsonObject.put("highlightStroke", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",1)")
            tempJsonObject.put("data", weightResult.get(i))
            dataSets.add(tempJsonObject)
        }

        JSONObject jsonResult = new JSONObject()
        jsonResult.put("labels", resultLabel)
        jsonResult.put("datasets", dataSets)


        return jsonResult
    }

    /**
     * Caclculate the score based on the given application and decision
     *
     * @param applicationid
     * @param decisionid
     * @return
     */
    private Object calculateScore(String applicationid, String decisionid){
        def currentApp = newgrails.ArchApplication.find("from ArchApplication as c where c.user=:myuser and c.id=:appid", [myuser: session.user, appid: Long.valueOf(applicationid)], [cache: true])

        def currentDec = newgrails.Decision.findAll("from Decision as c where c.id=:decid", [decid: Long.valueOf(decisionid)])

        def qualityPairwiseList = newgrails.PairwiseQuality.findAll("from PairwiseQuality as c where c.app=:myapp and c.decision=:mydec", [myapp: currentApp, mydec: currentDec])

        def stakeholderList = newgrails.Stakeholder.findAll("from Stakeholder as c where c.app=:myapp", [myapp: currentApp])

        def qualityList = newgrails.Quality.findAll("from Quality as c where c.app=:myapp", [myapp: currentApp])

        double sumWeight = 0.0

        for (int i = 0; i < qualityPairwiseList.size(); i++) {
            if (qualityPairwiseList.get(i).weight < 0){
                sumWeight += -1.0/qualityPairwiseList.get(i).weight;
            }else{
                sumWeight += qualityPairwiseList.get(i).weight;
            }
        }

        sumWeight = 2 * sumWeight


        ArrayList<ArrayList<Double>> weightResult= new ArrayList<>();

        for (int i = 0; i < stakeholderList.size(); i++) {
            ArrayList<Double> tempList = new ArrayList<>();
            for (int j = 0; j < qualityList.size(); j++) {
                def tempQualityList = newgrails.PairwiseQuality.findAll("from PairwiseQuality as c where c.app=:myapp and c.decision=:mydec and c.stakeholder=:mystk or c.firstquality=:myfq or c.secondquality=:mysq", [myapp: currentApp, mydec: currentDec, mystk: stakeholderList.get(i), myfq: qualityList.get(j), mysq: qualityList.get(j)])
                double tempSum = 0.0
                if (tempQualityList.size()>0){
                    for (int k = 0; k < tempQualityList.size(); k++) {
                        if (tempQualityList.get(k).weight < 0){
                            tempSum += -1.0/tempQualityList.get(k).weight
                        }else{
                            tempSum += tempQualityList.get(k).weight
                        }
                    }
                    tempList.add(tempSum/sumWeight)
                }else{
                    tempList.add(tempSum/sumWeight)
                }
            }
            weightResult.add(tempList)
        }

        JSONArray resultLabel = new JSONArray()
        for (int i = 0; i < qualityList.size(); i++) {
            resultLabel.put(qualityList.get(i).qualityName.toString())
        }

        JSONArray dataSets = new JSONArray()
        for (int i = 0; i < stakeholderList.size(); i++) {
            JSONObject tempJsonObject = new JSONObject()
            int myColor = (int)(Math.random()*255)
            int myColor1 = (int)(Math.random()*255)
            int myColor2 = (int)(Math.random()*255)
            tempJsonObject.put("label", stakeholderList.get(i).stakeholderName)
            tempJsonObject.put("fillColor", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",0.5)")
            tempJsonObject.put("strokeColor", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",0.8)")
            tempJsonObject.put("highlightFill", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",0.75)")
            tempJsonObject.put("highlightStroke", "rgba("+String.valueOf(myColor)+","+String.valueOf(myColor1)+","+String.valueOf(myColor2)+",1)")
            tempJsonObject.put("data", weightResult.get(i))
            dataSets.add(tempJsonObject)
        }

        JSONObject jsonResult = new JSONObject()
        jsonResult.put("labels", resultLabel)
        jsonResult.put("datasets", dataSets)


        return jsonResult
    }


    def executeReport(){

        def resData = null;
        if(Long.valueOf(params.applicationid)==-1||Long.valueOf(params.decisionid)==-1){
            resData = null;
        }else{
            resData = calculateScore(params.applicationid, params.decisionid)
        }

        render resData as JSON
    }



    def show(CombinationCentric combinationCentric) {
        respond combinationCentric
    }


    def create() {
        respond new CombinationCentric(params)
    }

    @Transactional
    def save(CombinationCentric combinationCentric) {
        if (combinationCentric == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (combinationCentric.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond combinationCentric.errors, view:'create'
            return
        }

        combinationCentric.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'combinationCentric.label', default: 'CombinationCentric'), combinationCentric.id])
                redirect combinationCentric
            }
            '*' { respond combinationCentric, [status: CREATED] }
        }
    }

    def edit(CombinationCentric combinationCentric) {
        respond combinationCentric
    }

    @Transactional
    def update(CombinationCentric combinationCentric) {
        if (combinationCentric == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (combinationCentric.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond combinationCentric.errors, view:'edit'
            return
        }

        combinationCentric.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'combinationCentric.label', default: 'CombinationCentric'), combinationCentric.id])
                redirect combinationCentric
            }
            '*'{ respond combinationCentric, [status: OK] }
        }
    }

    @Transactional
    def delete(CombinationCentric combinationCentric) {

        if (combinationCentric == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        combinationCentric.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'combinationCentric.label', default: 'CombinationCentric'), combinationCentric.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'combinationCentric.label', default: 'CombinationCentric'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
