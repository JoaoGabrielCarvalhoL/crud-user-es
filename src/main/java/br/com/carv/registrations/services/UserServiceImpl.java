package br.com.carv.registrations.services;

import br.com.carv.registrations.exceptions.UserException;
import br.com.carv.registrations.model.User;
import br.com.carv.registrations.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JavaMailSender emailSender;

    public UserServiceImpl(UserRepository userRepository, JavaMailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {

        Optional<User> user= Optional.of(userRepository.findById(id).get());

        return user.orElseThrow(() -> new UserException("User not found! Id: " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAllPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findUserByName(String userName) {

        Optional<User> user = Optional.of(userRepository.findByFullName(userName));
        return user.orElseThrow(() -> new UserException("User not found! Name user: " + userName.getClass().getName()));
    }

    @Override
    public User findUserByEmail(String userEmail) {

        Optional<User> user = Optional.of(userRepository.findByEmail(userEmail));
        return user.orElseThrow(() -> new UserException("User not found! Email user: " + userEmail.getClass().getName()));
    }

    @Override
    public void deleteUserById(Long id) {

        User user = userRepository.findById(id).get();
        if (user != null) {
            userRepository.delete(user);
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        User userUpdated = userRepository.findById(id).get();
        if (userUpdated == null) {
            throw new ObjectNotFoundException(id, User.class.getName());
        }
        userUpdated.setFullName(user.getFullName());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setCellphone(user.getCellphone());
        return userUpdated;
    }

    @Override
    public List<User> findUsersByName(String userName) {

        List<User> users = userRepository.findAll();
        Stream<User> result = users.stream().filter(user -> user.getFullName().contains(userName));
        return result.collect(Collectors.toList());
        /*
        List<User> usersResult = new ArrayList<User>();
        for (User user : users) {
            if (user.getFullName().contains(userName)) {
                usersResult.add(user);
            }
        }
        return usersResult;
        */
    }

    @Override
    public List<User> findUsersByEmail(String userEmail) {
        List<User> users = userRepository.findAll();
        Stream<User> result = users.stream().filter(user -> user.getEmail().contains(userEmail));
        return result.collect(Collectors.toList());

        /*
        List<User> usersResult = new ArrayList<User>();
        for (User user : users) {
            if (user.getEmail().contains(userEmail)) {
                usersResult.add(user);
            }
        }
        return usersResult;
         */
    }

    public void sendEmail(User user) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("testdevelopment70@gmail.com");
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("CRUD-Users");
            mailMessage.setText("Registration successful!");
            emailSender.send(mailMessage);

        } catch (MailException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    @Override
    public Page<User> findAllUsersPage() {

        return userRepository.findAll(PageRequest.of(0,100));
    }

    public Page<User> findUsersPage(String username) {

        List<User> users = userRepository.findAll();
        Stream<User> result = users.stream().filter(user -> user.getFullName().contains(username));
        return null;


    }




}
