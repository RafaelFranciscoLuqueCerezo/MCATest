package com.example.mcatest.rest;

import com.example.mcatest.application.similarProducts.find.SimilarProductsFinder;
import com.example.mcatest.application.similarProducts.find.dto.SimilarProducts;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class SimilarProductsController {

    private final SimilarProductsFinder finder;

    @GetMapping(value = "/{productId}/similar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimilarProducts> getSimilarProduct(
            @PathVariable @ApiParam(value = "product id",defaultValue = "2") String productId
    ){
        return ResponseEntity.ok(finder.getSimilarProducts(productId));
    }

}
