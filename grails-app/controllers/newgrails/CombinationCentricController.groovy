package newgrails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CombinationCentricController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CombinationCentric.list(params), model:[combinationCentricCount: CombinationCentric.count()]
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
