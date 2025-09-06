package org.smartbilling.controller;

import org.smartbilling.model.Neighborhood;
import org.smartbilling.model.User;
import org.smartbilling.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 /* @RestController marks the class as a REST controller,
 combining @Controller and @ResponseBody. Spring will
 handle HTTP requests and return responses in JSON format.
 */

@RequestMapping("/users")
 /* @RequestMapping specifies the base URL path for all
 endpoints in this controller. All methods will start
 with '/users'.
 */

public class UserController extends GenericController <User, Long>{
    public UserController(GenericService<User, Long> service){
        super(service);
    }

    @GetMapping
    /*
     @GetMapping Handles HTTP GET requests to retrieve resources.
     Returns data from the server, typically used for reading information.
     */
    public List<User> getAllUsers() {
        return super.getAll();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return super.getById(id);
    }

    @PostMapping
    /*
    @PostMapping: Handles HTTP POST requests to create new resources.
    Accepts data in the request body (e.g., JSON) and persists it.
     */
    public User create(User entity) {
        return super.create(entity);
    }

   /* public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll().stream()
                .map(userService::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.toDTO(userService.getById(id));
    }

    @GetMapping("/email/{email}")
    public UserDTO getByEmail(@PathVariable String email) {
        return userService.toDTO(userService.findByEmail(email));
    }

    @GetMapping("/neighborhood/{neighborhoodId}")
    public List<UserDTO> getByNeighborhood(@PathVariable Long neighborhoodId) {
        return userService.findByNeighborhood(neighborhoodId).stream()
                .map(userService::toDTO)
                .toList();
    }*/

}
