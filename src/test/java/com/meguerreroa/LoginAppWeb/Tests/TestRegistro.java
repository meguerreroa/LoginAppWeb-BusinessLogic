package com.meguerreroa.LoginAppWeb.Tests;

import com.meguerreroa.LoginAppWeb.DAO.UserDAO;
import com.meguerreroa.LoginAppWeb.entities.User;
import com.meguerreroa.LoginAppWeb.repositories.UserRepository;
import com.meguerreroa.LoginAppWeb.validations.ValidarRegistro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestRegistro {

    public final boolean SUCCESSFUL_OPERATION = true;
    public final boolean FAILURE_OPERATION = false;
    public final String AUTHORIZED_USER = "Usuario registrado";

    @Autowired
    private UserRepository userRepository;

    private ValidarRegistro validarRegistro = new ValidarRegistro(new UserDAO(userRepository));


    @Test
    public void testNombre(){
        User user = new User();

        user.setNombre("Gabriela");
        user.setPassword("12345");
        assertEquals(FAILURE_OPERATION, validarRegistro.validarLongitudNombre(user.getNombre()));

    }

    @Test
    public void testPassword(){
        User user = new User();

        user.setNombre("Maria");
        user.setPassword("1234567");
        assertEquals(FAILURE_OPERATION, validarRegistro.validarLongitudPassword(user.getPassword()));

    }

    @Test
    public void testPasswords(){
        User user = new User();

        user.setNombre("Henry");
        user.setPassword("1234");
        String repeatPassword = "123";
        assertEquals(FAILURE_OPERATION, validarRegistro.validarpasswords(user.getPassword(), repeatPassword));

    }

    @Test
    public void testSuccess(){
        validarRegistro = new ValidarRegistro(new UserDAO(userRepository));
        User user = new User();

        user.setNombre("Juan");
        user.setPassword("1234");
        String repeatPassword = "1234";
        assertEquals(AUTHORIZED_USER, validarRegistro.verificarRegistro(user.getNombre(), user.getPassword(), repeatPassword));

        user.setNombre("Pedro");
        user.setPassword("123");
        repeatPassword = "123";
        assertEquals(AUTHORIZED_USER, validarRegistro.verificarRegistro(user.getNombre(), user.getPassword(), repeatPassword));

        user.setNombre("María");
        user.setPassword("12345");
        repeatPassword = "12345";
        assertEquals(AUTHORIZED_USER, validarRegistro.verificarRegistro(user.getNombre(), user.getPassword(), repeatPassword));

    }
}