package Lab2.services;

import Lab2.aop.annotation.MET;
import Lab2.models.Person;
import Lab2.repositories.PeopleRepository;
import Lab2.services.serviceInterfaces.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//  @MET - Measuring the Execution Time (MET)

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    @MET
    @Override
    @Deprecated
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @MET
    @Override
    @Deprecated
    public List<Person> findByName(String name) {
        return peopleRepository.findByName(name);
    }

    @MET
    @Override
    public Person findById(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @MET
    @Override
    @Transactional
    public void createPerson(Person person) {
        enrichPerson(person);
        peopleRepository.save(person);
    }

    @MET
    @Override
    @Transactional
    public void updatePerson(int id, Person person) {
        enrichPerson(person);
        peopleRepository.save(person);
    }

    @MET
    @Override
    @Transactional
    public void deletePerson(int id) {
        peopleRepository.deleteById(id);
    }

    private void enrichPerson(Person person){
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setUpdatedBy("Fedor");
    }
}
