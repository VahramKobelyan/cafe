package cafe

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userService.list(params), model: [userCount: userService.count()]
    }


    def show(Long id) {
        respond userService.get(id)
    }


    def create() {
        log.info "Creating new user with ${params} param"
        respond new User(params)
    }


    def save(User user) {
        if (!user) {
            log.info "${user} not found"
            notFound()
            return
        }
        try {
            log.debug "Trying to save ${user}"
            userService.save(user)
            log.debug "${user} is saved"
        } catch (ValidationException e) {
            respond user.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }


    def edit(Long id) {
        respond userService.get(id)
    }


    def update(User user) {

        if (!user) {
            notFound()
            return
        }

        try {
            userService.save(user)
            log.debug "${user} is updated"
        } catch (ValidationException e) {
            respond user.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: OK] }
        }
    }


    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userService.delete(id)
        log.debug " user with id ${id} is deleted"

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User or Role'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
