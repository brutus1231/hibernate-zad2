package pl.sda.dao;

import pl.sda.domain.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class HibernateUtil {

    private final EntityManager entityManager;
    private final Class clazz;

    public HibernateUtil(EntityManager entityManager, Class clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public List<Department> findAll() {
        return entityManager.createQuery("From " + clazz.getName(), clazz).getResultList();
    }

    public void printAll() {
        System.out.println("Dane z tabeli: ");
        List<Department> departments = findAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    public void create(Object objectToCreate) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(objectToCreate);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void delete(Long id) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.remove(entityManager.find(clazz, id));
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
