package kz.kaznu.api.telegram.models.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryEditRequest {
    private Long id;
    private String code;
    private String name;

    public CountryEditRequest(Long id) {
        this.id = id;
    }
}
