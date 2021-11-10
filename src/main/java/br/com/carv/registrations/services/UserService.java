package br.com.carv.registrations.services;

import br.com.carv.registrations.model.User;
import javafx.concurrent.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findUserById(Long id);

    List<User> findAll();

    User findUserByName(String userName);

    User findUserByEmail(String userEmail);

    void deleteUserById(Long id);

    User updateUser(Long id, User user);

    List<User> findUsersByName(String userName);

    List<User> findUsersByEmail(String userEmail);

    void sendEmail(User user);

     Page<User> findAllUsersPage();

    Page<User> findAllPage(Pageable pageable);

}
