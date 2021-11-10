package br.com.carv.registrations.controllers;

import br.com.carv.registrations.model.User;
import br.com.carv.registrations.repositories.UserRepository;
import br.com.carv.registrations.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {

        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/hi")
    @ResponseStatus(HttpStatus.OK)
    public String hi() {
        return "hi...";
    }


    //@RequestMapping(method = RequestMethod.GET, value = "/findUserById/{id}")
    @GetMapping("/findUserById/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {

        User user = userService.findUserById(id);

        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/allUsers")
    @GetMapping("/allUsers")
    public List<User> getAllUser() {
        List<User> users = userService.findAll();
        return users;
    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    //@RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User userUpdated = userService.updateUser(id, user);
        return ResponseEntity.ok().body(userUpdated);

    }

    //@RequestMapping(method = RequestMethod.POST, value = "/saveUser")
    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        userService.sendEmail(user);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/findUsersByName")
    @GetMapping("/findUsersByName")
    public List<User> findUsersByName(@RequestParam("username")String username) {
        List<User> users = userService.findUsersByName(username);
        return users;

    }

    //@RequestMapping(method = RequestMethod.GET, value = "/findUsersByEmail")
    @GetMapping("/findUsersByEmail")
    public List<User> findUsersByEmail(@RequestParam("email")String email) {
        List<User> users = userService.findUsersByEmail(email);
        return users;
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/findAllUsersPage")
    @GetMapping("/findAllUsersPage")
    public Page<User> findAllUserPage() {
        return userService.findAllUsersPage();

    }

    @GetMapping("/findAllPage")
    public Page<User> findAllPage(Pageable pageable) {
        return userService.findAllPage(pageable);
    }

    @GetMapping("/findUsersByNamePageFilter")
    public Page<User> findUsersByNamePageFilter(@RequestParam("username") String username, Pageable pageable) {
        return userRepository.findByNamePage(username, pageable);
    }

    @GetMapping("/findUsersByEmailPageFilter")
    public Page<User> findUsersByEmailPageFilter(@RequestParam("email") String email, Pageable pageable) {
        return userRepository.findByEmailPage(email, pageable);
    }


}
