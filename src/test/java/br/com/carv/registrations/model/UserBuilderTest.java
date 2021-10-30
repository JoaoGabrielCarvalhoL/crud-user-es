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

        UserBuilder user = new UserBuilder().setUserId(null).setFullName("Teste 123").setEmail("teste@gmail.com")
                .setCellphone("123456798");

        System.out.println(user);
    }

    @Test
    public void testUserBuilder2() {

      Builder user = new Builder().setUserId(null).setFullName("Teste Builder").setEmail("testebuilder@gmail.com")
                .setCellphone("65487564");

        System.out.println(user);
    }


}
