package org.smartbilling.service;

import org.smartbilling.model.Province;
import org.smartbilling.repository.ProvinceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class ProvinceService extends GenericService<Province, Long> {
    public ProvinceService(ProvinceRepository repository) {
        super(repository);
    }
}
