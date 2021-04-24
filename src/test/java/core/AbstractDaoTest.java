package core;

import com.enterprise.insurance.contract.Person;
import com.enterprise.insurance.contract.PersonDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractDaoTest {

    PersonDAO personDAO;

    @BeforeEach
    public void init(){
        personDAO = new PersonDAO();
        personDAO.startNewTransaction();
    }

    @AfterEach
    public void reset(){
        personDAO.rollback();
    }


    @Test
    public void testInsert(){
        Person person = new Person();
        person.setLastName("Huber");
        person.setFirstName("Hansi");
        Object object = personDAO.save(person);
        System.out.println(object);
    }

    @Test
    public void testLoad(){
        Person person = new Person();
        person.setLastName("Huber");
        person.setFirstName("Hansi");
        Person personSaved = personDAO.save(person);
        Person personFromDb = personDAO.getById(personSaved.getId());
        assertEquals(personSaved, personFromDb);
    }
}
