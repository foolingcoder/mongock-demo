package mu.mongock.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mu.mongock.demo.model.ExpenseCollection;

public interface ExpenseRepository extends MongoRepository<ExpenseCollection, String> {
    @Query("{'name': ?0}")
    Optional<ExpenseCollection> findByName(String name);
}