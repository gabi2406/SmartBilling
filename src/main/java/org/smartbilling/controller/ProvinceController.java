package org.smartbilling.controller;

import service.ProvinceService;
import org.smartbilling.model.Province;
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
public class ProvinceController {
    private final ProvinceService provinceService;
    public ProvinceController(ProvinceService provinceService){
        this.provinceService = provinceService;
    }

    @GetMapping
    /* Handles HTTP GET requests to '/provinces'.
    Returns a list of all provinces.
    */
    public List<Province> getAll(){
        return provinceService.getAllProvince();
    }

    @GetMapping("/{id}")
    /* Handles HTTP GET requests to '/provinces/{id}'.
    @PathVariable binds the URL 'id' to the method parameter.
    Returns a single Province by its ID.
    */
    public Province getById(@PathVariable Long id){
        return provinceService.getProvinceById(id);
    }
}
