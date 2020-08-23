package pl.sda.dao;

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

    public List<Object> findAll() {
        return entityManager.createQuery("From " + clazz.getName(), clazz).getResultList();
    }

    public void printAll() {
        System.out.println("Dane z tabeli: ");
        List<Object> entities = findAll();
        for (Object entity : entities) {
            System.out.println(entity);
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
