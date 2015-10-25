package newgrails

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArchApplicationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ArchApplication.list(params), model:[archApplicationCount: ArchApplication.count()]
    }

    def show(ArchApplication archApplication) {
        respond archApplication
    }

    def create() {
        respond new ArchApplication(params)
    }

    @Transactional
    def save(ArchApplication archApplication) {
        if (archApplication == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (archApplication.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond archApplication.errors, view:'create'
            return
        }

        archApplication.save flush:true

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])


        ArrayList<Integer> allAppId = new ArrayList<>();
        for (int i = 0; i < currentApp.size(); i++) {
            allAppId.add(currentApp.id)
        }
        session.userapp = allAppId

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'archApplication.label', default: 'ArchApplication'), archApplication.id])
//                redirect archApplication
                redirect(action: 'index')
            }
            '*' { respond archApplication, [status: CREATED] }
        }
    }

    def edit(ArchApplication archApplication) {
        respond archApplication
    }

    @Transactional
    def update(ArchApplication archApplication) {
        if (archApplication == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (archApplication.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond archApplication.errors, view:'edit'
            return
        }

        archApplication.save flush:true

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])
        session.userapp = currentApp

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'archApplication.label', default: 'ArchApplication'), archApplication.id])
//                redirect archApplication
                redirect(action: 'index')
            }
            '*'{ respond archApplication, [status: OK] }
        }
    }

    @Transactional
    def delete(ArchApplication archApplication) {

        if (archApplication == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        archApplication.delete flush:true

        def currentApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])
        session.userapp = currentApp

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'archApplication.label', default: 'ArchApplication'), archApplication.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'archApplication.label', default: 'ArchApplication'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
