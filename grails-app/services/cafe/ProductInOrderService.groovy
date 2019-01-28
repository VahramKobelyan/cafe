package cafe

import grails.gorm.services.Service

@Service(ProductInOrder)
interface ProductInOrderService {

    ProductInOrder get(Serializable id)

    List<ProductInOrder> list(Map args)

    Long count()

    void delete(Serializable id)

    ProductInOrder save(ProductInOrder productInOrder)

}