package cafe

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class LoginInterceptopInterceptorSpec extends Specification implements InterceptorUnitTest<LoginInterceptopInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test loginInterceptop interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"loginInterceptop")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
