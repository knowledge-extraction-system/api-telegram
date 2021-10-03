package kz.kaznu.api.telegram.models;

import kz.kaznu.api.telegram.models.enums.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TelegramUser {

    private Long id;
    private String firstName = "";
    private String lastName = "";
    private String userName = "";
    private String phoneNumber = "";
    private String languageCode;
    private String type;
    private Long countryId;
    private Gender gender;

    public TelegramUser(Long id) {
        this.id = id;
    }
}
