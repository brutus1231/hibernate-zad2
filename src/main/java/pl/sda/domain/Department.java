package pl.sda.domain;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {

    @Column(length = 200, nullable = false)
    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + getId() + ", name='" + name + '\'' + '}';
    }
}
