package repository;

import model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    Neighborhood findByName(String name);
}
