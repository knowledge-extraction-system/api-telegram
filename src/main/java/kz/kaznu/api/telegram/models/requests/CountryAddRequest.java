package kz.kaznu.api.telegram.models.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryAddRequest {
    private String code;
    private String name;
}
