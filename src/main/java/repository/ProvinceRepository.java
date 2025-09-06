package repository;

import org.smartbilling.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByName(String name);
}
