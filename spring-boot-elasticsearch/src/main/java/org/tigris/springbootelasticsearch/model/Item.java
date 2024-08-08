package org.tigris.springbootelasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "items")
@Data
public class Item {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String model;
    @Field(type = FieldType.Integer)
    private Integer createdAt;
    @Field(type = FieldType.Text)
    private String brand;
    @Field(type = FieldType.Nested)
    private List<Owner> owners; // <1>
}
