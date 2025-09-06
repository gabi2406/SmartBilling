package repository;

import org.smartbilling.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    Neighborhood findByName(String name);
}
