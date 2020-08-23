package pl.sda;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import pl.sda.dao.HibernateUtil;
import pl.sda.domain.Department;
import pl.sda.domain.Worker;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class HibernateApplication {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        final SessionFactory sf =
                configuration.configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Department.class)
                        .addAnnotatedClass(Worker.class)
                        .buildSessionFactory();

        HibernateUtil departmentDao = new HibernateUtil(sf.createEntityManager(), Department.class);
        HibernateUtil workerDao = new HibernateUtil(sf.createEntityManager(), Worker.class);

        Department departmentToCreate = new Department("Dział HR");
        departmentDao.create(departmentToCreate);
        Department departmentToCreate2 = new Department("Departament IT");
        departmentDao.create(departmentToCreate2);

        //departmentDao.delete(departmentToCreate.getId());

        departmentDao.printAll();

        Worker worker = new Worker("firstName", "lastName", -20, LocalDate.now(), departmentToCreate2);

        workerDao.create(worker);
        workerDao.printAll();
        System.out.println(worker.getId());

//        System.out.println(departmentDao.findById(2L));
        sf.close();

    }
}
