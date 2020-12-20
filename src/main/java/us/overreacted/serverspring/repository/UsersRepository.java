package us.overreacted.serverspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.overreacted.serverspring.entity.Customer;

import java.util.Optional;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */

@Repository
public interface UsersRepository extends CrudRepository<Customer, String> {

    Optional<Customer> findOneByEmail(final String email);

}
