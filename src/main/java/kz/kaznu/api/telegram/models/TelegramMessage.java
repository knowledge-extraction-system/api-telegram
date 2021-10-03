package kz.kaznu.api.telegram.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TelegramMessage {

    private Long id;
    private TelegramChat telegramChat;
    private TelegramUser telegramUser;
    private String message;
    private LocalDateTime date;
    private Long messageId;
    private boolean isDeleted;
    private LocalDateTime deletionDate;

    public TelegramMessage(TelegramChat telegramChat, TelegramUser telegramUser, String message, Long messageId) {
        this.telegramChat = telegramChat;
        this.telegramUser = telegramUser;
        this.message = message;
        this.date = LocalDateTime.now();
        this.messageId = messageId;
        this.isDeleted = false;
    }
}
