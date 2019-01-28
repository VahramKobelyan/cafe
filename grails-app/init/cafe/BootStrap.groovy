package cafe

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        switch (Environment.current) {
            case Environment.DEVELOPMENT:

                def admin = new User(username: "admin", password: "admin", enabled: true, role: UserRole.MANAGER).save(flush: true)

                def user = new User(username: "user", password: "user", enabled: true, role: UserRole.WAITER).save(flush: true)
                def user1 = new User(username: "user1", password: "user", enabled: true, role: UserRole.WAITER).save(flush: true)
                cafe.Table table = new Table(name: "table1", waiter: user).save()
                new Table(name: "table2", waiter: user).save()
                new Table(name: "table3", waiter: user1).save()
                new Product(name: "cola", price: 250).save()
                new Product(name: "water", price: 150).save()
                Order order = table.createNewOrder().save()
                ProductInOrder productInOrder = new ProductInOrder(order: order, product: "cola", quantity: 2, price: 500)
                productInOrder.save()
                break
            case Environment.PRODUCTION:
                break
        }

    }
    def destroy = {
    }
}
