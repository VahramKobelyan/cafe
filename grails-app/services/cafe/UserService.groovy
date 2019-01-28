package cafe

class UserService {

    User get(Serializable id) {
        return User.get(id)
    }

    List<User> list(Map args) {
        return User.list(args)
    }

    Long count() {
        return User.count
    }

    void delete(Serializable id) {
        User.get(id).remove()
    }

    @grails.transaction.Transactional
    User save(User user) {
        user.save()
    }

    List<User> waiterList() {
        User.findAllByRole(UserRole.WAITER)
    }

}