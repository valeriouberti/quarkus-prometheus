package it.ubetorbi.quarkus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import it.ubetorbi.quarkus.domain.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PersonRepository implements PanacheMongoRepositoryBase<Person, String> {

    public Optional<Person> findByName(String name){
        return find("name", name).firstResultOptional();
    }
}
