package cafe

import grails.converters.JSON
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import org.grails.web.json.JSONArray

@Transactional
class OrderService {
    @ReadOnly

    Order get(Serializable id) {
        return Order.get(id)
    }

    @ReadOnly

    List<Order> list(Map args) {
        return Order.list(args)
    }

    @ReadOnly
    Long count() {
        return Order.count
    }

    void delete(Serializable id) {
        Order.get(id).remove()
    }

    Order save(Order order) {
        order.save()
    }

//    @Transactional
//    Order save(Order order, List<ProductInOrder> productInOrderList) {
//        order.save()
//        productInOrderList.forEach {
//            it.setOrder(order)
//            it.save()
//        }
//    }
    @ReadOnly

    List<ProductInOrder> getProductsInOrder(String json) {
        List productList = [];
        if (json.trim()) {
            JSONArray jsonArray = JSON.parse(json)
            jsonArray.each { productList.add(new ProductInOrder(it)) }
        }
        productList
    }
}