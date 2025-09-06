package org.smartbilling.service;

import org.smartbilling.dto.UserDTO;
import org.smartbilling.model.User;
import org.springframework.stereotype.Service;
import org.smartbilling.repository.UserRepository;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class UserService extends GenericService<User, Long> {
    private final UserRepository userRepository;
    public UserService(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User findByNeighborhood(Long id) {
        return userRepository.findByNeighborhood(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getIdentification(),
                user.getName(),
                user.getLastname(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getNeighborhood() != null ? user.getNeighborhood().getName() : null
        );
    }

}
