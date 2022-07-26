package com.example.mcatest.application.similarProducts.find.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Product detail")
public class ProductDetail implements Serializable {

    @Schema(description = "Product id", required = true, minLength = 1)
    @JsonProperty(value = "id",required = true)
    private String id;

    @Schema(description = "Product name", required = true, minLength = 1)
    @JsonProperty(value = "name",required = true)
    private String name;

    @Schema(description = "Product price", required = true)
    @JsonProperty(value = "price",required = true)
    private int price;

    @Schema(description = "Product availability", required = true)
    @JsonProperty(value = "availability",required = true)
    private boolean availability;

}
