package Lab2SpringAOP.repositories;

import Lab2SpringAOP.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    //@Query (value = "SELECT * FROM person WHERE username LIKE :name%", nativeQuery = true)
    @Query ("FROM Person WHERE username = ?1")
    List<Person> findByName(String name);
}
