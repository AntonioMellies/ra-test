package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import utils.GeoJsonDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "companies")
public class Company {

    @Id
    private String id;

    private String name;

    @JsonDeserialize(using = GeoJsonDeserializer.class)
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    private String city;

    private String state;

    private String country;

}
