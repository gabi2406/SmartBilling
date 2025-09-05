package org.smartbilling.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
 /* @Entity Marks the class as a JPA entity,
 meaning it maps to a database table and can
 be persisted, updated, or deleted by JPA/Hibernate.
 */

@Data
 /* @Data is a Lombok annotation that combines several features:
 Generates getters for all fields.
 Generates setters for all non-final fields.
 Implements toString(), equals(), and hashCode().
 Creates a required-args constructor (for final fields).
 It’s a shortcut for @Getter, @Setter, @EqualsAndHashCode, @ToString, and @RequiredArgsConstructor.
 */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identification;
    private String name;
    private String lastname;
    private String email;
    private int phoneNumber;
    @ManyToOne
    private Neighborhood neighborhood;
}
