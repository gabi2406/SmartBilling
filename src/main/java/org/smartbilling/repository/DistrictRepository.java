package org.smartbilling.repository;

import org.smartbilling.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface DistrictRepository extends JpaRepository<District, Long> {
    District findByName(String name);
}
