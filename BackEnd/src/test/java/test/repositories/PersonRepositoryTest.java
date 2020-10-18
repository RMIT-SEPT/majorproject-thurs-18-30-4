package test.repositories;

import app.model.Person;
import app.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonRepositoryTest {


    @MockBean
    private PersonRepository personRepository;

    @Test
    public void whenFindByPersonIdentifier_thenReturnPerson() {
        Person p = new Person();
        p.setName("Bob");

        Person found = personRepository.findByPersonIdentifier(p.getPersonIdentifier());

        System.out.println(found.getName() + " " + p.getName());

        assertThat(found.getName()).isEqualTo(p.getName());
    }
}
