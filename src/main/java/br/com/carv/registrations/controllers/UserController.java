package br.com.carv.registrations.controllers;

import br.com.carv.registrations.model.User;
import br.com.carv.registrations.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hi")
    @ResponseStatus(HttpStatus.OK)
    public String hi() {
        return "hi...";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/findUserById/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {

        User user = userService.findUserById(id);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allUsers")
    public List<User> getAllUser() {
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User userUpdated = userService.updateUser(id, user);
        return ResponseEntity.ok().body(userUpdated);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        userService.sendEmail(user);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findUsersByName")
    public List<User> findUsersByName(@RequestParam("username")String username) {
        List<User> users = userService.findUsersByName(username);
        return users;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/findUsersByEmail")
    public List<User> findUsersByEmail(@RequestParam("email")String email) {
        List<User> users = userService.findUsersByEmail(email);
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAllUsersPage")
    public Page<User> findAllUserPage() {
        return userService.findAllUsersPage();

    }


}
