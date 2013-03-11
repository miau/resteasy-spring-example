package example.application.controller.rest;

import javax.inject.Inject

import org.springframework.test.context.ContextConfiguration

import spock.lang.Specification

@ContextConfiguration(locations = ["classpath:/applicationContext-testing.xml"])
class HelloWorldServiceTest extends Specification {

    @Inject
    HelloWorldService service;

    def "HelloWorldService#get が渡された名前を返す"() {
        when:
        def response = service.get('hoge')

        then:
        with(response) {
            attr == 'hello!'
            message == 'hoge'
        }
    }
}
