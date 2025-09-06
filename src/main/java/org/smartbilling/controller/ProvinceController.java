package org.smartbilling.controller;

import org.smartbilling.model.Province;
import org.smartbilling.service.GenericService;
import org.springframework.beans.factory.annotation.Qualifier;
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

@RequestMapping("/provinces")
 /* @RequestMapping specifies the base URL path for all
 endpoints in this controller. All methods will start
 with '/provinces'.
 */

public class ProvinceController extends GenericController <Province, Long>{
    public ProvinceController(GenericService<Province, Long> service){
        super(service);
    }

    @GetMapping
    public List<Province> getAllProvinces() {
        return super.getAll();
    }


    @GetMapping("/{id}")
    public Province getProvinceById(@PathVariable Long id) {
        return super.getById(id);
    }
}
