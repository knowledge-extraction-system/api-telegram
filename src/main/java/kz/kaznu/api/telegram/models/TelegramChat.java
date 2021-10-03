package kz.kaznu.api.telegram.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TelegramChat {

    private Long id;
    private String type;
    private String title;
    private LocalDateTime date;
    private Boolean isChannel;
    private Long countryId;


    public TelegramChat(Long id) {
        this.id = id;
    }
}
