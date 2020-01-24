package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComplaintCreateDTO {

    private String consumerId;

    private String companyId;

    private String title;

    private String description;

}
