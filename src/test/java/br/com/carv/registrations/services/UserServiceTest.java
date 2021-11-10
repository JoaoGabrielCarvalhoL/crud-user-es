package br.com.carv.registrations.services;

import br.com.carv.registrations.model.User;
import br.com.carv.registrations.model.UserBuilder;
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

        User user = new UserBuilder().setUserId(null).setFullName("João Gabriel Carvalho").setEmail("27.joaogabriel@gmai.com").setCellphone("14 998045007").createUser();
        User user2 = new UserBuilder().setUserId(null).setFullName("Carvalho Lopes da Cruz").setEmail("27.joaogabriel@gmai.com").setCellphone("14 998045007").createUser();


        userRepository.save(user);
        userRepository.save(user2);

        List<User> users = userService.findUsersByName("Carvalho");
        Assertions.assertTrue(!users.isEmpty());

    }

    @Test
    public void testFindUsersByEmail() {

        User user = new UserBuilder().setUserId(null).setFullName("Son Gohan").setEmail("gohan.dbz@@gmail.com").setCellphone("14 998045007").createUser();
        User user2 = new UserBuilder().setUserId(null).setFullName("Piccolo").setEmail("piccolo.dbz@gmai.com").setCellphone("14 998045007").createUser();

        userRepository.save(user);
        userRepository.save(user2);

        List<User> users = userService.findUsersByEmail("dbz");
        Assertions.assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserByName() {

        User user = new UserBuilder().setUserId(null).setFullName("Son Gohann").setEmail("gohan.dbz@@gmail.com").setCellphone("14 998045007").createUser();

        userRepository.save(user);

        User anotherUser = userService.findUserByName("Son Gohann");
        Assertions.assertTrue(user!=null);

    }

    @Test
    public void findUserByEmail() {

        User user = new UserBuilder().setUserId(null).setFullName("Son Gohann").setEmail("gohan.dbz.z.@gmail.com").setCellphone("14 998045007").createUser();
        userRepository.save(user);

        User anotherUser = userService.findUserByEmail("gohan.dbz.z.@gmail.com");
        Assertions.assertTrue(user!=null);

    }

}
