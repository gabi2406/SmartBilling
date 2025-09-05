package org.smartbilling.model;

import lombok.Data;
import java.util.Date;
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
public class Invoice {
    @Id
    private Long id;
    @OneToOne
    private User user;
    private Date period;
    private Date expiredDate;
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status = InvoiceStatus.PENDING;
    private Long amount;
}
