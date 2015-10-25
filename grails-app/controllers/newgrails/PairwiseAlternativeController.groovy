package newgrails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PairwiseAlternativeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])

        def tempPairwiseAlternative= newgrails.PairwiseAlternative.findAllByAppInList(currentApp)

        respond PairwiseAlternative.list(params), model:[pairwiseAlternativeCount: PairwiseAlternative.count(), userAlternative: tempPairwiseAlternative, userApplication: currentApp]
    }

    def show(PairwiseAlternative pairwiseAlternative) {
        respond pairwiseAlternative
    }

    @Transactional
    def generatePairwise(){
        def targetApp = ArchApplication.find("from ArchApplication as c where c.id=:myapp", [myapp: Long.valueOf(params.selApp)])

        def targetDecision = Decision.findAll("from Decision as c where c.app=:myapp", [myapp: targetApp], [cache: true])
        def targetQuality = Quality.findAll("from Quality as c where c.app=:myapp", [myapp: targetApp], [cache: true])

        def targetAlternative= Alternative.findAll("from Alternative as c where c.app=:myapp", [myapp: targetApp], [cache: true])

        ArrayList<ArrayList<Alternative>> alternativePair= new ArrayList<>();
        for (int i = 0; i < targetAlternative.size()-1; i++) {
            for (int j = i+1; j < targetAlternative.size(); j++) {
                ArrayList<Alternative> tempPair = new ArrayList<>();
                tempPair.add(targetAlternative.get(i));
                tempPair.add(targetAlternative.get(j));
                alternativePair.add(tempPair);
            }
        }

        for (int i = 0; i < targetDecision.size(); i++) {
            for (int j = 0; j < targetQuality.size(); j++) {
                for (int k = 0; k < alternativePair.size(); k++) {
                    def queryPairwisealternative = PairwiseAlternative.findAll("from PairwiseAlternative as c where c.app=:myapp and c.quality=:myquality and c.decision=:mydec and c.firstalter=:myfa and c.secondalter=:mysa",[myapp: targetApp, myquality: targetQuality.get(j), mydec: targetDecision.get(i), myfa: alternativePair.get(k).get(0), mysa: alternativePair.get(k).get(1)])
                    if (queryPairwisealternative.size()<=0){
                        def tempPairwisealternative= new PairwiseAlternative(app: targetApp, quality: targetQuality.get(j), decision: targetDecision.get(i), firstalter: alternativePair.get(k).get(0), secondalter: alternativePair.get(k).get(1), weight: 0)
                        tempPairwisealternative.save(flush: true)
                    }
                }
            }
        }
        redirect (action: 'index')
    }

    def create() {
        respond new PairwiseAlternative(params)
    }

    @Transactional
    def save(PairwiseAlternative pairwiseAlternative) {
        if (pairwiseAlternative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pairwiseAlternative.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pairwiseAlternative.errors, view:'create'
            return
        }

        pairwiseAlternative.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pairwiseAlternative.label', default: 'PairwiseAlternative'), pairwiseAlternative.id])
                redirect(action: 'index')
            }
            '*' { respond pairwiseAlternative, [status: CREATED] }
        }
    }

    def edit(PairwiseAlternative pairwiseAlternative) {
        respond pairwiseAlternative
    }

    @Transactional
    def update(PairwiseAlternative pairwiseAlternative) {
        if (pairwiseAlternative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pairwiseAlternative.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pairwiseAlternative.errors, view:'edit'
            return
        }

        pairwiseAlternative.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pairwiseAlternative.label', default: 'PairwiseAlternative'), pairwiseAlternative.id])
                redirect(action: 'index')
            }
            '*'{ respond pairwiseAlternative, [status: OK] }
        }
    }

    @Transactional
    def delete(PairwiseAlternative pairwiseAlternative) {

        if (pairwiseAlternative == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pairwiseAlternative.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pairwiseAlternative.label', default: 'PairwiseAlternative'), pairwiseAlternative.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pairwiseAlternative.label', default: 'PairwiseAlternative'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
