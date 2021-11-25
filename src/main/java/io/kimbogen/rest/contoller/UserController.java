package io.kimbogen.rest.contoller;

import io.kimbogen.rest.entity.User;
import io.kimbogen.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String register(@RequestBody User newUser) {
        return this.userService.register(newUser);
    }

    @GetMapping("/users/{id}")
    public User find(@PathVariable String id) {
        return this.userService.find(id);
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @PutMapping("/users")
    public void modify(@RequestBody User newUser) {
        this.userService.modify(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void remove(@PathVariable String id) {
        this.userService.remove(id);
    }
}
