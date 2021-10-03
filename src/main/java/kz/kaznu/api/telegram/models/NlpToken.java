package kz.kaznu.api.telegram.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NlpToken {

    private Long id;
    private String token;

    public NlpToken(String token) {
        this.token = token;
    }

    public NlpToken(Long id) {
        this.id = id;
    }
}
