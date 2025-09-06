package org.smartbilling.model;

import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
 /* @Entity Marks the class as a JPA entity,
 meaning it maps to a database table and can
 be persisted, updated, or deleted by JPA/Hibernate.
 */

public class Province {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected Province() {}

    public Province(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
