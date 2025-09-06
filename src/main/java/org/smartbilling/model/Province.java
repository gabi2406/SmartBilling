package org.smartbilling.model;

import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
 /* @Entity Marks the class as a JPA entity,
 meaning it maps to a database table and can
 be persisted, updated, or deleted by JPA/Hibernate.
 */

@Getter
 /* @Getter is a Lombok annotation that automatically
 generates getter methods for all fields in the class
 at compile time, reducing boilerplate code
 */
public class Province {
    @Id
    private Long id;
    private String name;
}
