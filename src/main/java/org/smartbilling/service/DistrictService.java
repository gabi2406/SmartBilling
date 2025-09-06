package org.smartbilling.service;

import org.smartbilling.model.District;
import org.springframework.stereotype.Service;
import org.smartbilling.repository.DistrictRepository;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class DistrictService extends GenericService<District, Long> {
    public DistrictService(DistrictRepository repository) {
        super(repository);
    }
}
