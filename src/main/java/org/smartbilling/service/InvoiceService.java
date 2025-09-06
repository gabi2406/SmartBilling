package org.smartbilling.service;

import org.smartbilling.model.Invoice;
import org.springframework.stereotype.Service;
import org.smartbilling.repository.InvoiceRepository;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class InvoiceService extends GenericService<Invoice, Long> {
    public InvoiceService(InvoiceRepository repository) {
        super(repository);
    }
}
