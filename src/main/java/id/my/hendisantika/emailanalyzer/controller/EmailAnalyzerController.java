package id.my.hendisantika.emailanalyzer.controller;

import id.my.hendisantika.emailanalyzer.repository.EmailAnalysisRepository;
import id.my.hendisantika.emailanalyzer.service.EmailAnalysisService;
import org.springframework.stereotype.Controller;

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
}
