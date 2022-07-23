package com.example.mcatest.application.similarProducts.find;

import com.example.mcatest.application.similarProducts.find.dto.SimilarProducts;
import com.example.mcatest.configuration.SimilarProductsServerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SimilarProductsFinder {

    private final SimilarProductsServerProperties serverProperties;
    private final RestTemplate restTemplate;

    public SimilarProducts getSimilarProducts(String productId){
        List<Integer> similarProductIds =
        Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(
                String.format("%s/product/%s/similarids", serverProperties.getMcaMicroservice(), productId),
                int[].class
        ))).boxed().toList();

        System.out.println(similarProductIds);
        return SimilarProducts.builder().build();
    }
}
