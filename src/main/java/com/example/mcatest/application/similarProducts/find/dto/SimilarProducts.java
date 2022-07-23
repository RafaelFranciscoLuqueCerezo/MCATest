package com.example.mcatest.application.similarProducts.find.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Schema(description = "List of similar products to a given one ordered by similarity", type = "Array")
public class SimilarProducts implements Serializable {
    private List<ProductDetail> productDetailList;
}
