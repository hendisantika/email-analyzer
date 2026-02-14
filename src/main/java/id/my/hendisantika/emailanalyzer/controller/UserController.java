package id.my.hendisantika.emailanalyzer.controller;

import id.my.hendisantika.emailanalyzer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.51
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(
            @RequestParam(required = false) String username) {

        if (username != null && userService.usernameExists(username)) {
            return "redirect:/login";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password) {

        if (userService.usernameExists(username)) {
            return "redirect:/register?error";
        }

        try {
            userService.registerUser(username, password);
        } catch (IllegalArgumentException e) {
            return "redirect:/register?weakPassword=true";
        }

        //userService.registerUser(username, password);

        // on laisse Spring Security gérer l’authentification
        return "redirect:/login";
    }
}
