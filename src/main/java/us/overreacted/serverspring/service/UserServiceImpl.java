package us.overreacted.serverspring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import us.overreacted.serverspring.entity.Customer;
import us.overreacted.serverspring.errors.BadRequestError;
import us.overreacted.serverspring.model.request.LoginRequest;
import us.overreacted.serverspring.model.request.RegisterRequest;
import us.overreacted.serverspring.repository.UsersRepository;

import java.util.Optional;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public UserServiceImpl(final PasswordEncoder passwordEncoder,
                           final UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public String login(final LoginRequest loginRequest) {
        this.validateLoginRequest(loginRequest);

        final Optional<Customer> oneByEmail = usersRepository.findOneByEmail(loginRequest.getEmail());
        if (oneByEmail.isPresent()) {
            final Customer customer = oneByEmail.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), customer.getPassword())) {
                return customer.getId();
            }
        }
        throw new BadRequestError("Invalid credentials!");
    }

    @Override
    public String registerUser(final RegisterRequest registerRequest) {
        this.validateRegisterRequest(registerRequest);

        final Optional<Customer> oneByEmail = usersRepository.findOneByEmail(registerRequest.getEmail());
        if (oneByEmail.isPresent()) {
            throw new BadRequestError("User already exists!");
        }

        final Customer customer = new Customer(registerRequest.getEmail(), registerRequest.getPassword());
        final Customer savedCustomer = usersRepository.save(customer);
        return savedCustomer.getId();
    }

    private void validateLoginRequest(final LoginRequest loginRequest) {
        loginRequest.setEmail(loginRequest.getEmail().toLowerCase());
    }

    private void validateRegisterRequest(final RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getRepeatPassword())) {
            throw new BadRequestError("Passwords do not match!");
        }

        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        registerRequest.setEmail(registerRequest.getEmail().toLowerCase());
    }

}
