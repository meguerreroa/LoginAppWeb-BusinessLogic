package com.meguerreroa.LoginAppWeb.controllers;
import com.meguerreroa.LoginAppWeb.DAO.UserDAO;
import com.meguerreroa.LoginAppWeb.entities.User;
import com.meguerreroa.LoginAppWeb.forms.IngresoForm;
import com.meguerreroa.LoginAppWeb.forms.RegistroForm;
import com.meguerreroa.LoginAppWeb.repositories.UserRepository;
import com.meguerreroa.LoginAppWeb.validations.ValidarIngreso;
import com.meguerreroa.LoginAppWeb.validations.ValidarRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class guiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ingreso")
    public String ingresoDefault(Model model){
        model.addAttribute("ingresoForm", new IngresoForm());
        model.addAttribute("result", "");
        return "ingreso";
    }
    @PostMapping("/ingreso")
    public String ingresoForm(@ModelAttribute IngresoForm form, Model model){
        UserDAO dao = new UserDAO(this.userRepository);
        User user = new User();
        user.setNombre(form.getNombre());
        user.setPassword(form.getPassword());
        ValidarIngreso validarIngreso = new ValidarIngreso(dao);
        model.addAttribute("result", validarIngreso.verificarIngreso(user));
        return "ingreso";
    }

    @GetMapping("/registro")
    public String registroDefault(Model model){
        model.addAttribute("registroForm", new RegistroForm());
        model.addAttribute("result", "");
        return "registro";
    }

    @PostMapping("/registro")
    public String ingresoForm(@ModelAttribute RegistroForm form, Model model){
        UserDAO dao = new UserDAO(this.userRepository);
        ValidarRegistro validarRegistro = new ValidarRegistro(dao);
        model.addAttribute("result", validarRegistro.verificarRegistro(form.getNombre(), form.getPassword(), form.getRepeatPassword()));
        return "registro";
    }
}
