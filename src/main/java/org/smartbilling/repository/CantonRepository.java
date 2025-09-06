package org.smartbilling.repository;

import org.smartbilling.model.Canton;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface CantonRepository extends JpaRepository<Canton, Long> {
    Canton findByName(String name);
}
