package core;

import com.enterprise.insurance.contract.Person;
import com.enterprise.insurance.contract.PersonDAO;
import org.junit.jupiter.api.Test;

public class AbstractDaoTest {

//    public PersonDAO personDAO = new PersonDAO();

    @Test
    public void testInsert(){
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();
        person.setLastName("Huber");
        person.setFirstName("Hansi");
//        Object object = personDAO.save(person);
//        System.out.println(object);
    }
}
