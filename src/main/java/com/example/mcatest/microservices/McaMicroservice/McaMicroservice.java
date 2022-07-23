package com.example.mcatest.microservices.McaMicroservice;

import com.example.mcatest.application.similarProducts.find.dto.ProductDetail;
import com.example.mcatest.configuration.SimilarProductsServerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class McaMicroservice {
    private final SimilarProductsServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public List<Integer> getMcaSimilarProducts(String productId){
        List<Integer> similarProductIds =
                Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(
                        String.format("%s/product/%s/similarids", serverProperties.getMcaMicroservice(), productId),
                        int[].class
                ))).boxed().toList();
        return similarProductIds;
    }

    public ProductDetail getMcaProductDetail(String productId){
        ProductDetail productDetail = restTemplate.getForObject(
                String.format("%s/product/%s", serverProperties.getMcaMicroservice(), productId),
                ProductDetail.class
        );

        return  productDetail;
    }

}
