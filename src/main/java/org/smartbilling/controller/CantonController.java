package org.smartbilling.controller;

import org.smartbilling.dto.CantonDTO;
import org.smartbilling.model.Canton;
import org.smartbilling.service.CantonService;
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

@RequestMapping("/cantons")
 /* @RequestMapping specifies the base URL path for all
 endpoints in this controller. All methods will start
 with '/cantons'.
 */

public class CantonController extends GenericController <Canton, Long>{
    private final CantonService service;
    public CantonController(CantonService service){
        super(service);
        this.service = service;
    }

    @GetMapping
    public List<Canton> getAllCantons() {
        return super.getAll();
    }


    @GetMapping("/{id}")
    public Canton getCantonsById(@PathVariable Long id) {
        return super.getById(id);
    }


    @GetMapping("/list/{provinceId}")
    public List<CantonDTO> getCantonsByProvince(@PathVariable Long provinceId) {
        return service.listAllByProvince(provinceId);
    }
}
