package id.my.hendisantika.emailanalyzer.controller;

import id.my.hendisantika.emailanalyzer.repository.EmailAnalysisRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.50
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HistoryController {

    private final EmailAnalysisRepository repo;

    public HistoryController(EmailAnalysisRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/history")
    public String history(
            @AuthenticationPrincipal UserDetails user,
            Model model) {

        model.addAttribute("history",
                repo.findByUsernameOrderByAnalyzedAtDesc(user.getUsername()));

        return "history";
    }
}
