package iu.msronan.edu.c322spring2024homework2.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to Guitar Inventory";
    }
}
