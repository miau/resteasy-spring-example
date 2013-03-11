package example.application.controller.rest;

import static org.unitils.reflectionassert.ReflectionAssert.*

import javax.inject.Inject
import javax.xml.bind.JAXBContext

import org.joda.time.LocalDateTime
import org.springframework.test.context.ContextConfiguration
import org.unitils.dbunit.annotation.DataSet

import spock.lang.Specification
import spock.unitils.UnitilsSupport
import example.application.controller.rest.dto.EmployeeResponse

@ContextConfiguration(locations = ["classpath:/applicationContext-testing.xml"])
@UnitilsSupport
@DataSet
class EmployeeServiceTest extends Specification {

    @Inject
    EmployeeService service;

    def "EmployeeService#get が期待された XML を返す"() {
        // ※実験的に書いたテストケース。XML 構造のテストに関しては別の層で行うため、記述は不要。
        when:
        def response = service.get()
        def writer = new StringWriter()
        JAXBContext.newInstance(response.class).createMarshaller().with {
            it.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true)
            it.marshal(response, writer)
        }

        then:
        writer.toString() == """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<employees>
    <employee>
        <employeeId>1</employeeId>
        <employeeName>スミス</employeeName>
        <hiredate>1980-12-17T00:00:00.000</hiredate>
        <salary>800</salary>
    </employee>
    <employee>
        <employeeId>2</employeeId>
        <employeeName>アレン</employeeName>
        <hiredate>1981-02-20T00:00:00.000</hiredate>
        <salary>1600</salary>
    </employee>
    <employee>
        <employeeId>3</employeeId>
        <employeeName>ワード</employeeName>
        <hiredate>1981-02-22T00:00:00.000</hiredate>
        <salary>1250</salary>
    </employee>
</employees>
"""
    }

    def "EmployeeService#get が期待された Employee の一覧を返す - Unitils 使用"() {
        // ※試しに書いたテストケース
        // assertReflectionEquals を使えば簡潔に書けるが、
        // ・LocalDateTime も内部状態の比較結果となるのでわかりにくい
        // ・トレースの「Compare Actual With Expected Test Result」が使えない
        // ため、推奨しない
        when:
        def response = service.get()

        then:
        assertReflectionEquals(response.employee, [
            new EmployeeResponse(employeeId: 1, employeeName: "スミス", hiredate: new LocalDateTime("1980-12-17T00:00:00.000"), salary:  800),
            new EmployeeResponse(employeeId: 2, employeeName: "アレン", hiredate: new LocalDateTime("1981-02-20T00:00:00.000"), salary: 1600),
            new EmployeeResponse(employeeId: 3, employeeName: "ワード", hiredate: new LocalDateTime("1981-02-22T00:00:00.000"), salary: 1250),
        ])
    }

    def "EmployeeService#get が期待された Employee の一覧を返す - Groovy"() {
        // ※Groovy の基本処理のみを使ったテストケース。やや煩雑。
        when:
        def response = service.get()
        def employees = response.employee.collect{ EmployeeResponse emp ->
            [
                employeeId:     emp.employeeId,
                employeeName:   emp.employeeName,
                hiredate:       emp.hiredate,
                salary:         emp.salary,
            ]
        }

        then:
        employees == [
            [ employeeId: 1, employeeName: "スミス", hiredate: new LocalDateTime("1980-12-17T00:00:00.000"), salary:  800 ],
            [ employeeId: 2, employeeName: "アレン", hiredate: new LocalDateTime("1981-02-20T00:00:00.000"), salary: 1600 ],
            [ employeeId: 3, employeeName: "ワード", hiredate: new LocalDateTime("1981-02-22T00:00:00.000"), salary: 1250 ],
        ]
    }
}
