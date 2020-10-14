package eu.overreacted.serverspring.repository;

import eu.overreacted.serverspring.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

    Optional<User> findOneByEmail(final String email);

}
