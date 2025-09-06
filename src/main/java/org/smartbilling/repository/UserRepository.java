package org.smartbilling.repository;

import java.util.Optional;
import org.smartbilling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
  //Optional<User> findByNeighborhood(Long neighborhood);
}
