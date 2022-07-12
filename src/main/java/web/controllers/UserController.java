package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.EntityConfig;
import web.service.UserService;
import web.service.UserServiceImp;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.showUsers());

        return "users";
    }

    @GetMapping("/{id}")
    public String showUserById(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userService.findUserById(id));

        return "users";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam(name = "id", required = false) int id, Model model) {
        userService.removeUser(id);
        model.addAttribute("users", userService.showUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUser(@RequestParam(name = "id", required = false) int id, Model model) {
        userService.removeUser(id);
        model.addAttribute("users", userService.showUsers());
        return "users";
    }
}
