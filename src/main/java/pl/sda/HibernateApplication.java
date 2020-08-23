package pl.sda;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.dao.HibernateUtil;
import pl.sda.domain.Department;
import pl.sda.domain.Worker;

public class HibernateApplication {

    public static void main(String[] args) {
        final SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Department.class)
                        .addAnnotatedClass(Worker.class)
                        .buildSessionFactory();

        HibernateUtil departmentDao = new HibernateUtil(sf.createEntityManager(), Department.class);

        Department departmentToCreate = new Department("Dział HR");
        departmentDao.create(departmentToCreate);
        Department departmentToCreate2 = new Department("Departament IT");
        departmentDao.create(departmentToCreate2);

        departmentDao.delete(departmentToCreate.getId());

        departmentDao.printAll();
    }
}
