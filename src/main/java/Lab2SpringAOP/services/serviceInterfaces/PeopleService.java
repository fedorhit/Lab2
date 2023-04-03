package Lab2SpringAOP.services.serviceInterfaces;

import Lab2SpringAOP.models.Person;

import java.util.List;

public interface PeopleService {
    List<Person> findAll();
    List<Person> findByName(String name);
    Person findById(int id);
    void createPerson(Person person);
    void updatePerson(int id, Person person);
    void deletePerson(int id);
}
