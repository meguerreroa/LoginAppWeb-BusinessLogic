package com.meguerreroa.LoginAppWeb.DAO;

import com.meguerreroa.LoginAppWeb.entities.User;
import com.meguerreroa.LoginAppWeb.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDAOTest {

    public final boolean SUCCESSFUL_OPERATION = true;
    public final boolean FAILURE_OPERATION = false;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void TestInsert() {
        UserDAO dao = new UserDAO(this.userRepository);

        User user = new User();
        user.setNombre("Juan");
        user.setPassword("1234");
        assertEquals(SUCCESSFUL_OPERATION, dao.insert(user));

        user = new User();
        user.setNombre("Pedro");
        user.setPassword("123");
        assertEquals(SUCCESSFUL_OPERATION, dao.insert(user));

        user = new User();
        user.setNombre("María");
        user.setPassword("12345");
        assertEquals(SUCCESSFUL_OPERATION, dao.insert(user));

        user = new User();
        user.setNombre("John");
        user.setPassword("4567");
        assertEquals(SUCCESSFUL_OPERATION, dao.insert(user));

    }

    @Test
    public void TestSelect() {
        UserDAO dao = new UserDAO(this.userRepository);

        User user = new User();
        user.setNombre("Henry");
        user.setPassword("1234");
        assertEquals(FAILURE_OPERATION, dao.select(user));

        user = new User();
        user.setNombre("Juan");
        user.setPassword("1234");
        assertEquals(SUCCESSFUL_OPERATION, dao.select(user));

    }

    @Test
    public void TestUpdate() {
        UserDAO dao = new UserDAO(this.userRepository);

        User oldUser = new User();
        User newUser = new User();

        newUser.setNombre("Henry");
        newUser.setPassword("1234");
        oldUser.setNombre("Henry");
        oldUser.setPassword("123");
        assertEquals(FAILURE_OPERATION, dao.update(oldUser, newUser));

        newUser.setNombre("Pedro");
        newUser.setPassword("321");
        oldUser.setNombre("Pedro");
        oldUser.setPassword("123");
        assertEquals(SUCCESSFUL_OPERATION, dao.update(oldUser, newUser));

    }

    @Test
    public void TestDelete() {
        UserDAO dao = new UserDAO(this.userRepository);

        User user = new User();
       /* user = new User();
        user.setNombre("John");
        user.setPassword("4567");
        assertEquals(SUCCESSFUL_OPERATION, dao.insert(user));*/

        user.setNombre("Henry");
        user.setPassword("1234");
        assertEquals(FAILURE_OPERATION, dao.delete(user));

        user = new User();
        user.setNombre("John");
        user.setPassword("4567");
        assertEquals(SUCCESSFUL_OPERATION, dao.delete(user));

    }
}
