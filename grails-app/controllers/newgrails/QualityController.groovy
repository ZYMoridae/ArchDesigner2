package newgrails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QualityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])

        def tempQuality = null;

        if (currentApp.size()!=0){
            tempQuality= newgrails.Quality.findAllByAppInList(currentApp)
        }

        respond Quality.list(params), model:[qualityCount: Quality.count(), userQuality: tempQuality]
    }

    def show(Quality quality) {
        respond quality
    }

    def create() {
        respond new Quality(params)
    }

    @Transactional
    def save(Quality quality) {
        if (quality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (quality.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond quality.errors, view:'create'
            return
        }

        quality.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'quality.label', default: 'Quality'), quality.id])
//                redirect quality
                redirect(action: 'index')
            }
            '*' { respond quality, [status: CREATED] }
        }
    }

    def edit(Quality quality) {
        respond quality
    }

    @Transactional
    def update(Quality quality) {
        if (quality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (quality.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond quality.errors, view:'edit'
            return
        }

        quality.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'quality.label', default: 'Quality'), quality.id])
//                redirect quality
                redirect(action: 'index')
            }
            '*'{ respond quality, [status: OK] }
        }
    }

    @Transactional
    def delete(Quality quality) {

        if (quality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        quality.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'quality.label', default: 'Quality'), quality.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'quality.label', default: 'Quality'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
