package pl.sda;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.dao.HibernateUtil;
import pl.sda.domain.Department;
import pl.sda.domain.Worker;

import java.time.LocalDate;
import java.util.Scanner;

public class HibernateApplication {

    public static void main(String[] args) {
        final SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Department.class)
                        .addAnnotatedClass(Worker.class)
                        .buildSessionFactory();

        HibernateUtil departmentDao = new HibernateUtil(sf.createEntityManager(), Department.class);
        HibernateUtil workerDao = new HibernateUtil(sf.createEntityManager(), Worker.class);

        Department departmentToCreate = new Department("Dział HR");
        departmentDao.create(departmentToCreate);
        Department departmentToCreate2 = new Department("Departament IT");
        departmentDao.create(departmentToCreate2);

        departmentDao.delete(departmentToCreate.getId());

        departmentDao.printAll();

        Worker worker = new Worker("firstName", "lastName", 20, LocalDate.now(), departmentToCreate2);

        workerDao.create(worker);
        workerDao.printAll();
        System.out.println(worker.getId());

        departmentDao.close();
        workerDao.close();
        sf.close();

    }
}
