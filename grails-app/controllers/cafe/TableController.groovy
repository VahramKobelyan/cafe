package cafe

import grails.validation.ValidationException
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

class TableController {

    TableService tableService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tableService.list(params), model: [tableCount: tableService.count()]
    }

    def show(Long id) {
        respond tableService.get(id)
    }

    @Secured("hasAnyRole('ROLE_MANAGER')")

    def create() {
        respond new Table(params)
    }

    @Secured("hasAnyRole('ROLE_MANAGER')")

    def save(Table table) {

        if (table == null) {
            notFound()
            return
        }

        try {
            tableService.save(table)
        } catch (ValidationException e) {
            respond table.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'table.label', default: 'Table'), table.id])
                redirect table
            }
            '*' { respond table, [status: CREATED] }
        }
    }

    @Secured("hasAnyRole('ROLE_MANAGER')")

    def edit(Long id) {
        respond tableService.get(id)
    }

    @Secured("hasAnyRole('ROLE_MANAGER')")

    def update(Table table) {
        if (table == null) {
            notFound()
            return
        }

        try {
            tableService.save(table)
        } catch (ValidationException e) {
            respond table.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'table.label', default: 'Table'), table.id])
                redirect table
            }
            '*' { respond table, [status: OK] }
        }
    }

    @Secured("hasAnyRole('ROLE_MANAGER')")

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tableService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'table.label', default: 'Table'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'table.label', default: 'Table'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
