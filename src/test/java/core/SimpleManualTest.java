package core;

import java.util.List;

import com.enterprise.insurance.contract.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class SimpleManualTest {

    public Long id;

    @Test
    public void crud() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        create(session);
        read(session);

        update(session);
        read(session);

        delete(session);
        read(session);

        session.close();
    }

    private void delete(Session session) {
        System.out.println("Deleting Hansi record...");
        Person person = session.get(Person.class, id);

        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
    }

    private void update(Session session) {
        System.out.println("Updating Hansi...");
        Person person = session.get(Person.class, id);
        person.setLastName("Huberito");

        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
    }

    private void create(Session session) {
        System.out.println("Creating person records...");
        Person person = new Person();
        person.setFirstName("Hansi");
        person.setLastName("Huber");
        session.beginTransaction();
        id = (Long) session.save(person);
        session.getTransaction().commit();
    }

    private void read(Session session) {
        Query<Person> q = session.createQuery("select p from Person p", Person.class);

        List<Person> persons = q.list();

        System.out.println("Reading records...");
        System.out.println("Id\tFirstName\tLastName");
        for (Person p : persons) {
            System.out.println(p.getId() + "\t" + p.getFirstName() + "\t" + p.getLastName());
        }
    }
}
