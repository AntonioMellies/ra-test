package models;

import com.mongodb.client.model.geojson.Point;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "locations")
public class Location {

    @Id
    private String id;

    private Point point;

    private String city;

    private String state;

    private String country;

}
