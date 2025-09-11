package org.smartbilling.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.smartbilling.model.User;
import org.smartbilling.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser_Success() {
        User userToSave = new User();
        userToSave.setEmail("test@exmple.com");
        userToSave.setName("Name1");
        userToSave.setLastname("LastName1");
        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setEmail("test@example.com");
        savedUser.setName("Name1");
        savedUser.setLastname("LastName1");

        when(userRepository.save(userToSave)).thenReturn(savedUser);

        User result = userService.save(userToSave);

        assertNotNull(result);
        assertEquals(savedUser.getId(), result.getId());
        assertEquals(savedUser.getEmail(), result.getEmail());
        verify(userRepository, times(1)).save(userToSave);
    }


}
