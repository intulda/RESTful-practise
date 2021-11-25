package io.kimbogen.rest.service.logic;

import io.kimbogen.rest.UserRestApplication;
import io.kimbogen.rest.entity.User;
import io.kimbogen.rest.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = UserRestApplication.class)
public class UserServiceLogicTest {

    @Autowired
    private UserService userService;

    private User kim;
    private User lee;

    @BeforeEach
    public void startUp() {
        this.kim = new User("Kim", "kim@naver.com");
        this.lee = new User("Lee", "lee@naver.com");
        this.userService.register(this.kim);
        this.userService.register(this.lee);
    }

    @Test
    public void registerTest() {
        User sample = User.sample();

        assertThat(this.userService.register(sample))
                .isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);

        this.userService.remove(sample.getId());
    }

    @Test
    public void findTest() {
        assertThat(this.userService.find(kim.getId()))
                .isNotNull();
        assertThat(this.userService.find(kim.getId()).getEmail())
                .isEqualTo(kim.getEmail());
        assertThat(this.userService.find(kim.getId()))
                .isInstanceOf(User.class);
    }

    @AfterEach
    public void cleanUp() {
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }
}
