package pl.fox.allezon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fox.allezon.model.User;
import pl.fox.allezon.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
//   @ResponseStatus(HttpStatus. OK)
    public ResponseEntity<?> create(@RequestBody User u) {
        service.saveUser(u);
        return ResponseEntity.ok("ALLES GUT!");
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Object o) {
        HttpHeaders headers = new HttpHeaders();
        if(service.loginUser(o)){
            headers.add("Responded", "UserController");
            return ResponseEntity.ok().headers(headers).body("Logged In successfuly!");
        }

        headers.add("Invalid", "BAD");
        return ResponseEntity.badRequest().headers(headers).body("Invalid mail or password!");
    }

    @GetMapping(value = "/get")
    public User getById(@RequestParam Integer id) { return service.getById(id); }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }

}
