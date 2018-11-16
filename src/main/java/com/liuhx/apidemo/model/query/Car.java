package com.liuhx.apidemo.model.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program apidemo
 * @description: car mongo实体
 * @author: liuhx
 * @create: 2018/11/16 11:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "car")
public class Car {
    @Id
    private String id;

    @Indexed(unique = true, name = "uk_carId")
    private Long carId;

    private String model;

    private String brand;

    private String style;


}
