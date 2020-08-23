package pl.sda;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.dao.DepartmentDaoImpl;
import pl.sda.domain.Department;
import pl.sda.domain.Worker;

public class HibernateApplication {

    public static void main(String[] args) {
        final SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Department.class)
                        .addAnnotatedClass(Worker.class)
                        .buildSessionFactory();

        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(sf.createEntityManager());

        Department departmentToCreate = new Department("Dział HR");
        departmentDao.create(departmentToCreate);

        departmentDao.printAll();
    }
}
