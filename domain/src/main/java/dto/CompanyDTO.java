package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {

    private String id;

    private String name;

    private String city;

    private String state;

    private String country;

    private Double latitude;

    private Double longitude;
}
