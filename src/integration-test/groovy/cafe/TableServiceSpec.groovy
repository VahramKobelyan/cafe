package cafe

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TableServiceSpec extends Specification {

    TableService tableService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Table(...).save(flush: true, failOnError: true)
        //new Table(...).save(flush: true, failOnError: true)
        //Table table = new Table(...).save(flush: true, failOnError: true)
        //new Table(...).save(flush: true, failOnError: true)
        //new Table(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //table.id
    }

    void "test get"() {
        setupData()

        expect:
        tableService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Table> tableList = tableService.list(max: 2, offset: 2)

        then:
        tableList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tableService.count() == 5
    }

    void "test delete"() {
        Long tableId = setupData()

        expect:
        tableService.count() == 5

        when:
        tableService.delete(tableId)
        sessionFactory.currentSession.flush()

        then:
        tableService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Table table = new Table()
        tableService.save(table)

        then:
        table.id != null
    }
}
