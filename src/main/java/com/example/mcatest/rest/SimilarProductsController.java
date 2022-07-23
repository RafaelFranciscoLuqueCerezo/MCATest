package com.example.mcatest.rest;

import com.example.mcatest.application.similarProducts.find.SimilarProductsFinder;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Similar products operations", description = "Endpoints to perform Application operations")
public class SimilarProductsController {

    private final SimilarProductsFinder finder;

    @GetMapping(value = "/{productId}/similar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getSimilarProduct(@PathVariable String productId){
        finder.getSimilarProducts(productId);
        return null;
    }

}
