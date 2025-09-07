package org.smartbilling.repository;

import org.smartbilling.model.Canton;
import org.smartbilling.model.District;
import org.smartbilling.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    Neighborhood findByName(String name);

    @Query("SELECT n FROM Neighborhood n WHERE n.district.id = :districtId")
    List<Neighborhood> listByDistrict(@Param("districtId") Long districtId);
}
