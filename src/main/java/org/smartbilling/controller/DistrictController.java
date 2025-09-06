package org.smartbilling.controller;

import org.smartbilling.model.District;
import org.smartbilling.service.GenericService;
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

@RequestMapping("/districts")
 /* @RequestMapping specifies the base URL path for all
 endpoints in this controller. All methods will start
 with '/districts'.
 */

public class DistrictController extends GenericController <District, Long>{
    public DistrictController(GenericService<District, Long> service){
        super(service);
    }

    @GetMapping
    public List<District> getAllDistricts() {
        return super.getAll();
    }


    @GetMapping("/{id}")
    public District getDistrictById(@PathVariable Long id) {
        return super.getById(id);
    }
}
