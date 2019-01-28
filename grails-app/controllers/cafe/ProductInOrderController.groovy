package cafe

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class ProductInOrderController {

    ProductInOrderService productInOrderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond productInOrderService.list(params), model: [productInOrderCount: productInOrderService.count()]
    }

    def show(Long id) {
        respond productInOrderService.get(id)
    }

    def create() {
        respond new ProductInOrder(params)
    }

    def save(ProductInOrder productInOrder) {
        if (productInOrder == null) {
            notFound()
            return
        }

        try {
            productInOrderService.save(productInOrder)
        } catch (ValidationException e) {
            respond productInOrder.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productInOrder.label', default: 'ProductInOrder'), productInOrder.id])
                redirect productInOrder
            }
            '*' { respond productInOrder, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond productInOrderService.get(id)
    }

    def update(ProductInOrder productInOrder) {
        if (productInOrder == null) {
            notFound()
            return
        }

        try {
            productInOrderService.save(productInOrder)
        } catch (ValidationException e) {
            respond productInOrder.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productInOrder.label', default: 'ProductInOrder'), productInOrder.id])
                redirect productInOrder
            }
            '*' { respond productInOrder, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        productInOrderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productInOrder.label', default: 'ProductInOrder'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productInOrder.label', default: 'ProductInOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
