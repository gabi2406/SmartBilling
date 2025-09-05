package repository;

import model.Canton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantonRepository extends JpaRepository<Canton, Long> {
    Canton findByName(String name);
}
