package kz.kaznu.api.telegram.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NlpChatToken {

    private TelegramChat telegramChat;
    private NlpToken nlpToken;
    private Long count;

    public NlpChatToken(TelegramChat telegramChat, NlpToken nlpToken) {
        this.telegramChat = telegramChat;
        this.nlpToken = nlpToken;
    }
}
