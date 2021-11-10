package br.com.carv.registrations.repositories;

import br.com.carv.registrations.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

    User findByFullName(String firstname);

    User findByEmail(String email);

    User findByEmailAndFullName(String email, String fullName);

    @Query(value = "SELECT u FROM User u where u.fullName LIKE %:fullname%")
    Page<User> findByNamePage(@Param("fullname") String fullname, Pageable pageable);

    @Query(value = "SELECT u FROM User u where u.email LIKE %:email%")
    Page<User> findByEmailPage(@Param("email") String email, Pageable pageable);

}
