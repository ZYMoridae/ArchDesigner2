package newgrails

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PairwiseQualityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])

//        def tempPairwiseQuality= newgrails.PairwiseQuality.findAllByAppInList(currentApp)
        def tempPairwiseQuality= newgrails.PairwiseQuality.getAll()

        respond PairwiseQuality.list(params), model:[pairwiseQualityCount: PairwiseQuality.count(), userPairwiseQuality: tempPairwiseQuality, userApplication: currentApp]
    }

    @Transactional
    def generatePairwise(){
        def targetApp = ArchApplication.find("from ArchApplication as c where c.id=:myapp", [myapp: Long.valueOf(params.selApp)])

        def targetStakeholder = Stakeholder.findAll("from Stakeholder as c where c.app=:myapp", [myapp: targetApp], [cache: true])
        def targetDecision = Decision.findAll("from Decision as c where c.app=:myapp", [myapp: targetApp], [cache: true])
        def targetQuality = Quality.findAll("from Quality as c where c.app=:myapp", [myapp: targetApp], [cache: true])

        ArrayList<ArrayList<Quality>> qualityPair = new ArrayList<>();
        for (int i = 0; i < targetQuality.size()-1; i++) {
            for (int j = i+1; j < targetQuality.size(); j++) {
                ArrayList<Quality> tempPair = new ArrayList<>();
                tempPair.add(targetQuality.get(i));
                tempPair.add(targetQuality.get(j));
                qualityPair.add(tempPair);
            }
        }

        for (int i = 0; i < targetStakeholder.size(); i++) {
            for (int j = 0; j < targetDecision.size(); j++) {
                for (int k = 0; k < qualityPair.size(); k++) {
                    def queryPairwisequality = PairwiseQuality.findAll("from PairwiseQuality as c where c.app=:myapp and c.stakeholder=:mysth and c.decision=:mydec and c.firstquality=:myfq and c.secondquality=:mysq",[myapp: targetApp, mysth: targetStakeholder.get(i), mydec: targetDecision.get(j), myfq: qualityPair.get(k).get(0), mysq: qualityPair.get(k).get(1)])
                    if (queryPairwisequality.size()<=0){
                        def tempPairwisequality = new PairwiseQuality(app: targetApp, stakeholder: targetStakeholder.get(i), decision: targetDecision.get(j), firstquality: qualityPair.get(k).get(0), secondquality: qualityPair.get(k).get(1), weight: 0)
                        tempPairwisequality.save(flush: true)
                    }
                }
            }
        }
        redirect (action: 'index')
    }

    def show(PairwiseQuality pairwiseQuality) {
        respond pairwiseQuality
    }

    def create() {
        respond new PairwiseQuality(params)
    }

    @Transactional
    def save(PairwiseQuality pairwiseQuality) {
        if (pairwiseQuality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pairwiseQuality.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pairwiseQuality.errors, view:'create'
            return
        }

        pairwiseQuality.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pairwiseQuality.label', default: 'PairwiseQuality'), pairwiseQuality.id])
                redirect (action: 'index')
            }
            '*' { respond pairwiseQuality, [status: CREATED] }
        }
    }

    def edit(PairwiseQuality pairwiseQuality) {
        respond pairwiseQuality
    }

    @Transactional
    def update(PairwiseQuality pairwiseQuality) {
        if (pairwiseQuality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pairwiseQuality.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pairwiseQuality.errors, view:'edit'
            return
        }

        pairwiseQuality.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pairwiseQuality.label', default: 'PairwiseQuality'), pairwiseQuality.id])
                redirect (action: 'index')
            }
            '*'{ respond pairwiseQuality, [status: OK] }
        }
    }

    @Transactional
    def delete(PairwiseQuality pairwiseQuality) {

        if (pairwiseQuality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pairwiseQuality.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pairwiseQuality.label', default: 'PairwiseQuality'), pairwiseQuality.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pairwiseQuality.label', default: 'PairwiseQuality'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
