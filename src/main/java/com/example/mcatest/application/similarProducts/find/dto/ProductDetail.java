package com.example.mcatest.application.similarProducts.find.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Schema(description = "Product detail", type = "Object")
public class ProductDetail implements Serializable {

    //@Schema(description = "Product id", required = true, minLength = 1)
    private String id;
    //@Schema(description = "Product name", required = true, minLength = 1)
    private String name;
    //@Schema(description = "Product price", required = true)
    private Number price;
    //@Schema(description = "Product availability", required = true)
    private boolean availability;

}
