package cafe

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = false, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    UserRole role

    static mapping = {
        table "users"
        password column: '`password`'

    }

    def beforeValidate() {
        if (!password) {
            password = getPersistentValue("password")
        }
    }
    static constraints = {
        password nullable: false, blank: false, password: true, display: false
        username nullable: false, blank: false, unique: true
        accountExpired display: false
        accountLocked display: false
        passwordExpired display: false
    }

    Set<UserRole> getAuthorities() {
        [role] as Set
    }

    boolean isWaiter() {
        return role == UserRole.WAITER
    }

}
