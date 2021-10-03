package kz.kaznu.api.telegram.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NlpUserToken {

    private TelegramUser telegramUser;
    private NlpToken nlpToken;
    private Long count;

    public NlpUserToken(TelegramUser telegramUser, NlpToken nlpToken) {
        this.telegramUser = telegramUser;
        this.nlpToken = nlpToken;
    }
}
