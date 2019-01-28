package cafe

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class WaiterInterceptopInterceptorSpec extends Specification implements InterceptorUnitTest<WaiterInterceptopInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test waiterInterceptop interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"waiterInterceptop")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
