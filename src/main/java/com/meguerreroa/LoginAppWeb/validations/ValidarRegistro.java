package com.meguerreroa.LoginAppWeb.validations;

import com.meguerreroa.LoginAppWeb.DAO.UserDAO;
import com.meguerreroa.LoginAppWeb.entities.User;

public class ValidarRegistro {
    private UserDAO userDAO;

    public ValidarRegistro(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String verificarRegistro(String nombre, String password, String repeatPassword){
        if(!validarLongitudNombre(nombre)){
            return "Longitud del nombre incorrecto";
        }else if(!validarLongitudPassword(password)){
            return "Longitud de contraseña incorrecto";
        }else if(!validarpasswords(password, repeatPassword)){
            return "las contraseñas no coinciden";
        }else{
            User user = new User();
            user.setNombre(nombre);
            user.setPassword(password);
            userDAO.insert(user);
            return "Usuario registrado";
        }
    }

    public boolean validarLongitudNombre(String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }

    public boolean validarLongitudPassword(String password){
        return (password.length() >= 3 && password.length() < 6);
    }

    public boolean validarpasswords(String password, String repeatPassword){
        return password.equals(repeatPassword);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
