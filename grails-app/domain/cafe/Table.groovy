package cafe

import cafe.excpetions.CafeRuntimeException

class Table {
    User waiter;
    String name;
    static hasMany = [orders: Order]

    static constraints = {
        waiter validator: { it.isWaiter() }
        name unique: true

    }
    static mapping = {
        table "tables"
    }

    boolean isFree() {
        !getActiveOrder()
    }

    Order getActiveOrder() {
        orders.find { it.orderStatus == OrderStatus.OPEN }
    }

    Order createNewOrder() {
        if (!isFree()) {
            throw new CafeRuntimeException("${name} table already has an open order")
        }
        Order order = new Order();
        order.orderStatus = OrderStatus.OPEN;
        order.cafeTable = this
        order
    }

}
