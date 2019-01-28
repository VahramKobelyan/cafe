package cafe


class LoginInterceptopInterceptor {
    def springSecurityService

    LoginInterceptopInterceptor() {
        matchAll().excludes(controller: 'login').excludes(controller: 'logout').excludes(controller: 'error')
    }

    boolean before() {
        if (!springSecurityService.currentUser) {
            redirect controller: 'login', action: 'auth'
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
