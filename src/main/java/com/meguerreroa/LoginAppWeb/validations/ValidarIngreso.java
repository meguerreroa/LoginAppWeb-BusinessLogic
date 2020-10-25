package com.meguerreroa.LoginAppWeb.validations;

import com.meguerreroa.LoginAppWeb.DAO.UserDAO;
import com.meguerreroa.LoginAppWeb.entities.User;

public class ValidarIngreso {

    private UserDAO userDAO;

    public ValidarIngreso(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String verificarIngreso(User user){
        if(!validarLongitudNombre(user.getNombre())){
            return "Longitud del nombre incorrecto";
        }else if(!validarLongitudPassword(user.getPassword())){
            return "Longitud de contraseña incorrecto";
        }else if(this.userDAO.select(user)){
            return "Bienvenido";
        }else{
            return "Datos incorrectos";
        }
    }

    private boolean validarLongitudNombre(String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }

    private boolean validarLongitudPassword(String password){
        return (password.length() >= 3 && password.length() < 6);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
