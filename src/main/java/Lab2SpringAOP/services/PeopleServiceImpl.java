package Lab2SpringAOP.services;

import Lab2SpringAOP.aop.annotation.MET;
import Lab2SpringAOP.models.Person;
import Lab2SpringAOP.repositories.PeopleRepository;
import Lab2SpringAOP.services.serviceInterfaces.PeopleService;
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
    @Deprecated // Повесил для проверки работы логирования при Deprecated аннотации
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @MET
    @Override
    @Deprecated // Повесил для проверки работы логирования при Deprecated аннотации
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
        person.setCreatedBy("ADMIN");
    }
}
