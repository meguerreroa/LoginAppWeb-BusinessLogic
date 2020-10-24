package com.meguerreroa.LoginAppWeb.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class guiController {
    @GetMapping("/")
    public String view(){
        return "index";
    }
    @GetMapping("/ingreso")
    public String ingreso(){
        return "ingreso";
    }
    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }
}
