package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComplaintLocationConsultDTO {

    private Double latitude;

    private Double longitude;

    private Integer distance;

}
