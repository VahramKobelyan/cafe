package cafe


class TableService {
    def springSecurityService

    Table get(Serializable id) {
        return Table.get(id)
    }

    List<Table> list(Map args) {
        if (springSecurityService.currentUser.isWaiter()) {
            return Table.findAllByWaiter(springSecurityService.currentUser)
        }
        Table.list(args)
    }

    Long count() {
        return Table.count
    }

    void delete(Serializable id) {
        Table.get(id).remove()
    }

    Table save(Table table) {
        table.save()
    }


}