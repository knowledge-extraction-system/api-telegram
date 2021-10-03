package kz.kaznu.api.telegram.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country {

    private Long id;
    private String code;
    private String name;

    public Country(Long id) {
        this.id = id;
    }

}
