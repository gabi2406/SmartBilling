package org.smartbilling.repository;

import org.smartbilling.model.Canton;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
@Repository
public interface CantonRepository extends JpaRepository<Canton, Long> {
    Canton findByName(String name);

    @Query("SELECT c FROM canton c WHERE c.province_id = :provinceId")
    List<Canton> listByProvince(@Param("provinceId") Long provinceId);
}

