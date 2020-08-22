package pl.sda.dao;

import pl.sda.domain.Department;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentDaoImpl {

    private final EntityManager entityManager;

    public DepartmentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Department> findAll() {
        return entityManager.createQuery("From Department", Department.class).getResultList();
    }

//    public Department create(Department departmentToCreate){
//
//    }
}
