package br.com.carv.registrations.repositories;

import br.com.carv.registrations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByFullName(String firstname);

    User findByEmail(String email);

    User findByEmailAndFullName(String email, String fullName);
}
