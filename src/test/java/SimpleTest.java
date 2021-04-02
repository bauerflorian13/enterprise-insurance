

import java.util.List;

import com.enterprise.insurance.contract.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    public void crud() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        create(session);
        read(session);
//
//        update(session);
//        read(session);
//
//        delete(session);
//        read(session);

        session.close();
    }

    private void delete(Session session) {
//        System.out.println("Deleting mondeo record...");
//        Car mondeo = (Car) session.get(Car.class, "mondeo");
//
//        session.beginTransaction();
//        session.delete(mondeo);
//        session.getTransaction().commit();
    }

    private void update(Session session) {
//        System.out.println("Updating mustang price...");
//        Car mustang = (Car) session.get(Car.class, "mustang");
//        mustang.setModel("mustang");
//        mustang.setPrice("£35,250.00");
//
//        session.beginTransaction();
//        session.saveOrUpdate(mustang);
//        session.getTransaction().commit();
    }

    private void create(Session session) {
        System.out.println("Creating person records...");
        Person person = new Person("Hansi", "Meier");
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }

    private void read(Session session) {
        Query<Person> q = session.createQuery("select p from Person p");

        List<Person> persons = q.list();

        System.out.println("Reading records...");
        System.out.println("FirstName\tLastName");
        for (Person p : persons) {
            System.out.println(p.getFirstName() + "\t" + p.getLastName());
        }
    }
}
