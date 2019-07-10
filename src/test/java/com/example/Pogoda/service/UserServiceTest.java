package com.example.Pogoda.service;

import com.example.Pogoda.model.User;
import com.example.Pogoda.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository, passwordEncoder);
        user = new User.Builder()
                .withLogin("login1")
                .withPassword("password")
                .withActive(1)
                .build();

        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.existsByLogin("login")).thenReturn(true);
    }

    @Test
    public void testFindUserByLogin() {
        // given
        // when
        final boolean result = userServiceUnderTest.userExist("login");

        // then
        assertTrue(result);
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String login = "login1";
        final User user = new User.Builder()
                .withLogin("login1")
                .withPassword("password")
                .withActive(1)
                .build();

        // Run the test
        User result = userServiceUnderTest.registerNewUser(user);

        // Verify the results
        assertEquals(login, result.getLogin());
    }
}
