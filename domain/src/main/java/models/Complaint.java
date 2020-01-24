package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "complaints")
public class Complaint {

    @Id
    private String id;

    private Consumer consumer;

    private Company company;

    private String title;

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updateAt;

}
