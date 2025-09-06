package org.smartbilling.service;

import org.smartbilling.dto.CantonDTO;
import org.smartbilling.model.Canton;
import org.springframework.stereotype.Service;
import org.smartbilling.repository.CantonRepository;

import java.util.List;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class CantonService extends GenericService<Canton, Long> {
    private final CantonRepository repository;
    public CantonService(CantonRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<CantonDTO> listAllByProvince(Long provinceId){
        return repository.listByProvince(provinceId)
                .stream()
                .map(n -> new CantonDTO(
                        n.getId(),
                        n.getName(),
                        n.getProvince().getId()
                ))
                .toList();
    }
}
