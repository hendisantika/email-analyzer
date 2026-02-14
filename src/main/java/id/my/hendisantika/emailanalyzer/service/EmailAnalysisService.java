package id.my.hendisantika.emailanalyzer.service;

import id.my.hendisantika.emailanalyzer.dto.EmailAnalysisResult;
import id.my.hendisantika.emailanalyzer.entity.EmailAnalysisEntity;
import id.my.hendisantika.emailanalyzer.repository.EmailAnalysisRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public EmailAnalysisService(EmailAnalysisRepository repo) {
        this.repo = repo;
    }

    public EmailAnalysisResult analyze(String emailContent, String username) {
        // score calculation as before
        int score = 0;
        List<String> foundKeywords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : SUSPICIOUS_KEYWORDS.entrySet()) {
            String content = emailContent.toLowerCase();

            if (content.contains(entry.getKey())) {
                // if (emailContent.contains(entry.getKey())) {
                score += entry.getValue();
                foundKeywords.add(entry.getKey());
            }
        }

        // Détection des liens
        Pattern linkPattern = Pattern.compile("(https?:\\/\\/\\S+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = linkPattern.matcher(emailContent);

        while (matcher.find()) {
            score += 4;
            foundKeywords.add("Lien suspect : " + matcher.group());
        }


        boolean suspicious = score >= 5;
        String message = suspicious ? "⚠️ Suspicious email detected" : "Secure email";
        EmailAnalysisResult result = new EmailAnalysisResult(message, suspicious, score, foundKeywords);


        EmailAnalysisEntity entity = new EmailAnalysisEntity();
        entity.setUsername(username);
        entity.setContent(emailContent);
        entity.setSuspicious(result.isSuspicious());
        entity.setScore(result.getScore());
        entity.setReasons(result.getReasons());

        repo.save(entity);

        return result;
    }

}
