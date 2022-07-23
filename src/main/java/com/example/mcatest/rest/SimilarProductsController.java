package com.example.mcatest.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
@Tag(name = "Similar products operations", description = "Endpoints to perform Application operations")
public class SimilarProductsController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find applications", description = "Find applications")
    public ResponseEntity<Void> getSimilarProduct(){
       return null;
    }

}
