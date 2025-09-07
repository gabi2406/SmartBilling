package org.smartbilling.repository;

import org.smartbilling.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface DistrictRepository extends JpaRepository<District, Long> {
    District findByName(String name);

    @Query("SELECT d FROM District d WHERE d.canton.id = :cantonId")
    List<District> listByCanton(@Param("cantonId") Long cantonId);
}
