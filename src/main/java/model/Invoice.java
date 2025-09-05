package model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
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
