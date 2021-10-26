package br.com.carv.registrations.services;

import br.com.carv.registrations.model.User;
import br.com.carv.registrations.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserByName() {
        User user = new User(null, "João Gabriel Carvalho", "27.joaogabriel@gmai.com", "14 998045007");
        User user2 = new User(null, "Carvalho Lopes da Cruz", "27.joaogabriel@gmai.com", "14 998045007");

        userRepository.save(user);
        userRepository.save(user2);

        List<User> users = userService.findUsersByName("Carvalho");
        Assertions.assertTrue(!users.isEmpty());
    }

    @Test
    public void testFindUsersByEmail() {
        User user = new User(null, "Son Gohan", "gohan.dbz@@gmail.com", "14 998045007");
        User user2 = new User(null, "Piccolo", "piccolo.dbz@gmai.com", "14 998045007");

        userRepository.save(user);
        userRepository.save(user2);

        List<User> users = userService.findUsersByEmail("dbz");
        Assertions.assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserByName() {
        User user = new User(null, "Son Gohann", "gohan.dbz@@gmail.com", "14 998045007");

        userRepository.save(user);

        User anotherUser = userService.findUserByName("Son Gohann");
        Assertions.assertTrue(user!=null);
    }

    @Test
    public void findUserByEmail() {
        User user = new User(null, "Son Gohann", "gohan.dbz.z.@gmail.com", "14 998045007");

        userRepository.save(user);

        User anotherUser = userService.findUserByEmail("gohan.dbz.z.@gmail.com");
        Assertions.assertTrue(user!=null);
    }

}
