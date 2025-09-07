package org.smartbilling.controller;

import org.smartbilling.model.Neighborhood;
import org.smartbilling.dto.NeighborhoodDTO;
import org.smartbilling.service.NeighborhoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
 /* @RestController marks the class as a REST controller,
 combining @Controller and @ResponseBody. Spring will
 handle HTTP requests and return responses in JSON format.
 */

@RequestMapping("/neighborhood")
 /* @RequestMapping specifies the base URL path for all
 endpoints in this controller. All methods will start
 with '/neighborhood'.
 */

public class NeighborhoodController extends GenericController <Neighborhood, Long>{
    private final NeighborhoodService service;
    public NeighborhoodController(NeighborhoodService service){
        super(service);
        this.service = service;
    }

    @GetMapping
    public List<Neighborhood> getAllNeighborhood() {
        return super.getAll();
    }


    @GetMapping("/{id}")
    public Neighborhood getNeighborhoodById(@PathVariable Long id) {
        return super.getById(id);
    }

    @GetMapping("/list/{districtId}")
    public List<NeighborhoodDTO> getNeighborhoodByDistrict(@PathVariable Long districtId) {
        return service.listAllByDistrict(districtId);
    }
}
