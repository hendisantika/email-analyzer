package id.my.hendisantika.emailanalyzer.service;

import id.my.hendisantika.emailanalyzer.repository.EmailAnalysisRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.40
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EmailAnalysisService {

    private final EmailAnalysisRepository repo;
    private static final Map<String, Integer> SUSPICIOUS_KEYWORDS = Map.of(
            "urgent", 2,
            "verify", 3,
            "password", 5,
            "click", 4,
            "account", 2,
            "bank", 5,
            "confirm", 3
    );

}
