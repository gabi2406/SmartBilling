package repository;

import org.smartbilling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

 /* JpaRepository` provides CRUD operations, pagination,
 sorting, and query method support for JPA entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
