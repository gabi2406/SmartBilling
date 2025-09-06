package org.smartbilling.service;

import org.smartbilling.dto.NeighborhoodDTO;
import org.smartbilling.model.Neighborhood;
import org.springframework.stereotype.Service;
import org.smartbilling.repository.NeighborhoodRepository;

import java.util.List;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class NeighborhoodService extends GenericService<Neighborhood, Long> {

    private final NeighborhoodRepository neighborhoodRepository;
    public NeighborhoodService(NeighborhoodRepository repository) {
        super(repository);
        this.neighborhoodRepository = repository;
    }

    public List<NeighborhoodDTO> getAllNeighborhoods() {
        return neighborhoodRepository.findAll()
                .stream()
                .map(n -> new NeighborhoodDTO(n.getId(), n.getName(), n.getDistrict().getId()))
                .toList();
    }
}
