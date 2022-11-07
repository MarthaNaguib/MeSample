package com.example.mesample.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@Document(collection="MEtable")
@AllArgsConstructor
@NoArgsConstructor
public class Bucket {
    @Id
    private int id;
    private String type;
    private int capacity;
}