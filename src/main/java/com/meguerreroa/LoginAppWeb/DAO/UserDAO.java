package com.meguerreroa.LoginAppWeb.DAO;

import com.meguerreroa.LoginAppWeb.entities.User;
import com.meguerreroa.LoginAppWeb.repositories.UserRepository;

public class UserDAO {

    private UserRepository userRepository;

    public boolean insert(User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean select( User user){
        Iterable<User> users = userRepository.findAll();
        for(User u : users){
            if(u.getNombre().equals(user.getNombre()) && u.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    public boolean update(User oldUser, User newUser){
        Iterable<User> users =  userRepository.findAll();
        for(User u : users){
            if(u.getNombre().equals(oldUser.getNombre()) && u.getPassword().equals(oldUser.getPassword())){
                u.setNombre(newUser.getNombre());
                u.setPassword(newUser.getPassword());
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    public boolean delete(User user){
        Iterable<User> users = userRepository.findAll();
        for(User u : users){
            if(u.getNombre().equals(user.getNombre()) && u.getPassword().equals(user.getPassword())){
                userRepository.deleteById(u.getId());
                return true;
            }
        }
        return false;
    }

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}