package id.my.hendisantika.emailanalyzer.dto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.36
 * To change this template use File | Settings | File Templates.
 */
public class EmailAnalysisResult {
    private String message;
    private boolean suspicious;
    private int score;
    private List<String> reasons;

    public EmailAnalysisResult(String message, boolean suspicious, int score, List<String> reasons) {
        this.message = message;
        this.suspicious = suspicious;
        this.score = score;
        this.reasons = List.copyOf(reasons);
    }

    // getters
    public String getMessage() { return message; }
    public boolean isSuspicious() { return suspicious; }
    public int getScore() { return score; }
    public List<String> getReasons() { return reasons; }
}
