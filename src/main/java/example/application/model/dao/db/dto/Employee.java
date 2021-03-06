package example.application.model.dao.db.dto;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    /** */
    @Id
    @Column(name = "EMPLOYEE_ID")
    BigDecimal employeeId;

    /** */
    @Column(name = "EMPLOYEE_NAME")
    String employeeName;

    /** */
    @Column(name = "HIREDATE")
    LocalDateTime hiredate;

    /** */
    @Column(name = "SALARY")
    BigDecimal salary;

    /** */
    @Version
    @Column(name = "VERSION_NO")
    BigDecimal versionNo;

    /**
     * Returns the employeeId.
     *
     * @return the employeeId
     */
    public BigDecimal getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employeeId.
     *
     * @param employeeId the employeeId
     */
    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Returns the employeeName.
     *
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the employeeName.
     *
     * @param employeeName the employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Returns the hiredate.
     *
     * @return the hiredate
     */
    public LocalDateTime getHiredate() {
        return hiredate;
    }

    /**
     * Sets the hiredate.
     *
     * @param hiredate the hiredate
     */
    public void setHiredate(LocalDateTime hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * Returns the salary.
     *
     * @return the salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Sets the salary.
     *
     * @param salary the salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * Returns the versionNo.
     *
     * @return the versionNo
     */
    public BigDecimal getVersionNo() {
        return versionNo;
    }

    /**
     * Sets the versionNo.
     *
     * @param versionNo the versionNo
     */
    public void setVersionNo(BigDecimal versionNo) {
        this.versionNo = versionNo;
    }
}