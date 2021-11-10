package br.com.carv.registrations.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserBuilderTest {

    @Test
    public void testUserBuilder() {

        User user = User.builder().setFullName("Teste User Builder").
                setEmail("teste@gmail.com").
                setCellphone("1234579").
                setHairColor("sadasdsad").
                createUser();

        System.out.println(user.getFullName());
    }




}
