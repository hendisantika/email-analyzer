package id.my.hendisantika.emailanalyzer.controller;

import id.my.hendisantika.emailanalyzer.dto.EmailAnalysisResult;
import id.my.hendisantika.emailanalyzer.repository.EmailAnalysisRepository;
import id.my.hendisantika.emailanalyzer.service.EmailAnalysisService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * Time: 06.48
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class EmailAnalyzerController {

    private final EmailAnalysisService emailAnalysisService;
    private final EmailAnalysisRepository emailAnalysisRepository;

    public EmailAnalyzerController(EmailAnalysisService emailAnalysisService, EmailAnalysisRepository emailAnalysisRepository) {
        this.emailAnalysisService = emailAnalysisService;
        this.emailAnalysisRepository = emailAnalysisRepository;
    }

    @GetMapping("/analyze")
    public String showAnalyzePage() {
        return "analyze";
    }

    @PostMapping("/analyze")
    public String analyzeEmail(
            @RequestParam String emailContent,
            Model model, @AuthenticationPrincipal User user) {

        if (user == null) {
            return "redirect:/login";
        }
        EmailAnalysisResult result = emailAnalysisService.analyze(emailContent, user.getUsername());
        // EmailAnalysisEntity entity = new EmailAnalysisEntity();
        // entity.setUsername(user.getUsername());
        // entity.setContent(emailContent);
        // entity.setScore(result.getScore());
        // entity.setSuspicious(result.isSuspicious());
        // entity.setDate(LocalDateTime.now());

        // emailAnalysisRepository.save(entity);
        model.addAttribute("result", result);

        return "analyze";
    }
}
