package cafe

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProductInOrderServiceSpec extends Specification {

    ProductInOrderService productInOrderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ProductInOrder(...).save(flush: true, failOnError: true)
        //new ProductInOrder(...).save(flush: true, failOnError: true)
        //ProductInOrder productInOrder = new ProductInOrder(...).save(flush: true, failOnError: true)
        //new ProductInOrder(...).save(flush: true, failOnError: true)
        //new ProductInOrder(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //productInOrder.id
    }

    void "test get"() {
        setupData()

        expect:
        productInOrderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ProductInOrder> productInOrderList = productInOrderService.list(max: 2, offset: 2)

        then:
        productInOrderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        productInOrderService.count() == 5
    }

    void "test delete"() {
        Long productInOrderId = setupData()

        expect:
        productInOrderService.count() == 5

        when:
        productInOrderService.delete(productInOrderId)
        sessionFactory.currentSession.flush()

        then:
        productInOrderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ProductInOrder productInOrder = new ProductInOrder()
        productInOrderService.save(productInOrder)

        then:
        productInOrder.id != null
    }
}
