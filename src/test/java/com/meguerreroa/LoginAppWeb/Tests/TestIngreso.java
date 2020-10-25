package com.meguerreroa.LoginAppWeb.Tests;

import com.meguerreroa.LoginAppWeb.DAO.UserDAO;
import com.meguerreroa.LoginAppWeb.entities.User;
import com.meguerreroa.LoginAppWeb.repositories.UserRepository;
import com.meguerreroa.LoginAppWeb.validations.ValidarIngreso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestIngreso {

    public final String LONG_NOMBRE_INCORRECTO = "Longitud del nombre incorrecto";
    public final String LONG_PASSWORD_INCORRECTO = "Longitud de contraseña incorrecto";
    public final String DATOS_INCORRECTOS = "Datos incorrectos";
    public final String AUTHORIZED_USER = "Bienvenido";

    @Autowired
    private UserRepository userRepository;

    private ValidarIngreso validarIngreso = new ValidarIngreso(new UserDAO(userRepository));


    @Test
    public void testLongitudNombre(){
        User user = new User();

        user.setNombre("R");
        user.setPassword("123456");
        assertEquals(LONG_NOMBRE_INCORRECTO, validarIngreso.verificarIngreso(user));

        user.setNombre("Roberto");
        user.setPassword("123456");
        assertEquals(LONG_NOMBRE_INCORRECTO, validarIngreso.verificarIngreso(user));

    }

    @Test
    public void testLongitudPassword(){
        User user = new User();

        user.setNombre("Pepe");
        user.setPassword("12");
        assertEquals(LONG_PASSWORD_INCORRECTO, validarIngreso.verificarIngreso(user));

        user.setNombre("Pepe");
        user.setPassword("123456");
        assertEquals(LONG_PASSWORD_INCORRECTO, validarIngreso.verificarIngreso(user));

    }

    @Test
    public void testNombre(){
        validarIngreso = new ValidarIngreso(new UserDAO(userRepository));

        User user = new User();

        user.setNombre("Henry");
        user.setPassword("12345");
        assertEquals(DATOS_INCORRECTOS, validarIngreso.verificarIngreso(user));
    }

    @Test
    public void testPassword(){
        validarIngreso = new ValidarIngreso(new UserDAO(userRepository));

        User user = new User();

        user.setNombre("Maria");
        user.setPassword("1234");
        assertEquals(DATOS_INCORRECTOS, validarIngreso.verificarIngreso(user));

    }

    @Test
    public void testDatos(){
        validarIngreso = new ValidarIngreso(new UserDAO(userRepository));

        User user = new User();

        user.setNombre("Henry");
        user.setPassword("1234");
        assertEquals(DATOS_INCORRECTOS, validarIngreso.verificarIngreso(user));

    }

    @Test
    public void testSuccess(){
        validarIngreso = new ValidarIngreso(new UserDAO(userRepository));
        User user = new User();

        user.setNombre("Juan");
        user.setPassword("1234");
        assertEquals(AUTHORIZED_USER, validarIngreso.verificarIngreso(user));

        user.setNombre("Pedro");
        user.setPassword("123");
        assertEquals(AUTHORIZED_USER, validarIngreso.verificarIngreso(user));

        user.setNombre("María");
        user.setPassword("12345");
        assertEquals(AUTHORIZED_USER, validarIngreso.verificarIngreso(user));

    }





}
