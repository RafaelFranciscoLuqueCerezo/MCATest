package com.example.mcatest.application.similarProducts.find.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Schema(description = "Product detail", type = "Object")
public class ProductDetail implements Serializable {

    @Schema(description = "Product id", required = true, minLength = 1)
    @JsonProperty(value = "id",required = true)
    private String id;

    @Schema(description = "Product name", required = true, minLength = 1)
    @JsonProperty(value = "name",required = true)
    private String name;

    @Schema(description = "Product price", required = true)
    @JsonProperty(value = "price",required = true)
    private Number price;

    @Schema(description = "Product availability", required = true)
    @JsonProperty(value = "availability",required = true)
    private boolean availability;

}
