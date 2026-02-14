package id.my.hendisantika.emailanalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.47
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
