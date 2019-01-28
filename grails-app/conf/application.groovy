// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'cafe.User'
grails.plugin.springsecurity.logout.afterLogoutUrl = '/'
//grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'cafe.UserRole'
//grails.plugin.springsecurity.authority.className = 'cafe.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/user/**', access: ['ROLE_MANAGER']],
        [pattern: '/product/**', access: ['ROLE_MANAGER', 'ROLE_WAITER']],
        [pattern: '/product/create/**', access: ['ROLE_MANAGER']],
        [pattern: '/product/save/**', access: ['ROLE_MANAGER']],
        [pattern: '/product/edit/**', access: ['ROLE_MANAGER']],
        [pattern: '/product/delete/**', access: ['ROLE_MANAGER']],
        [pattern: '/role/**', access: ['ROLE_MANAGER']],
        [pattern: '/table/**', access: ['ROLE_MANAGER', 'ROLE_WAITER']],
        [pattern: '/order/**', access: ['ROLE_MANAGER', 'ROLE_WAITER']],
        [pattern: '/dbconsole/**', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

