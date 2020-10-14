package us.overreacted.serverspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import us.overreacted.serverspring.entity.User;

import java.util.Optional;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

    Optional<User> findOneByEmail(final String email);

}
