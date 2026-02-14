package id.my.hendisantika.emailanalyzer.controller;

import id.my.hendisantika.emailanalyzer.repository.EmailAnalysisRepository;
import org.springframework.stereotype.Controller;

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
}
