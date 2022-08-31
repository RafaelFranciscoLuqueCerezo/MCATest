package com.example.mcatest.application.similarProducts.find.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ApiModel(description = "List of similar products to a given one ordered by similarity")
public class SimilarProducts implements Serializable {
    private List<ProductDetail> productDetailList;
}
