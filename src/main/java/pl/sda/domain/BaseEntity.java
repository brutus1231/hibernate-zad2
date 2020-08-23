package pl.sda.domain;

import javax.persistence.*;

@MappedSuperclass
@NamedQuery(name = "findById", query = "from Department where id = ?1")
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
