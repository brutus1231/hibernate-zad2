package pl.sda.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WORKER")
public class Worker extends BaseEntity {

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 200)
    private String lastName;

    @Column
    private Integer age;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Worker() {
    }

    public Worker(String firstName, String lastName, Integer age, LocalDate hireDate, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hireDate = hireDate;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + getId() + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", " +
                "age=" + age + ", hireDate=" + hireDate + ", department=" + department + '}';
    }
}
