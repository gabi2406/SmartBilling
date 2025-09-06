package repository;

import org.smartbilling.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository` provides CRUD operations, pagination,
sorting, and query method support for JPA entities.
*/
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
