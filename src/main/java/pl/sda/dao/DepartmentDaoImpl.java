package pl.sda.dao;

import pl.sda.domain.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DepartmentDaoImpl {

    private final EntityManager entityManager;

    public DepartmentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Department> findAll() {
        return entityManager.createQuery("From Department", Department.class).getResultList();
    }

    public void printAll() {
        List<Department> departments = findAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    public void create(Department departmentToCreate) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(departmentToCreate);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
