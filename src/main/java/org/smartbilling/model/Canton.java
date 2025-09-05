package org.smartbilling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

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

public class Canton {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Province province;
}
