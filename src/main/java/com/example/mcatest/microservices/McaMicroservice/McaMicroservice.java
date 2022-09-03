package com.example.mcatest.microservices.McaMicroservice;

import com.example.mcatest.annotation.restTemplate.RestTemplateNotFound;
import com.example.mcatest.application.similarProducts.find.dto.ProductDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class McaMicroservice {

    @Value("${mcaMicroservice}")
    private String mcaMicroserviceUrl;
    private final RestTemplate restTemplate;

    @RestTemplateNotFound
    public List<Integer> getMcaSimilarProducts(String productId){
       return restTemplate.getForObject(
                String.format("%s/product/%s/similarids", mcaMicroserviceUrl, productId),
                List.class
        );
    }

    public ProductDetail getMcaProductDetail(String productId){
        return restTemplate.getForObject(
                String.format("%s/product/%s",mcaMicroserviceUrl, productId),
                ProductDetail.class
        );
    }

    @Async("asyncExecutor")
    @RestTemplateNotFound(throwError = false)
    public CompletableFuture<ProductDetail> getAsyncMcaProductDetail(String productId) {
        ProductDetail  productDetail = restTemplate.getForObject(
                    String.format("%s/product/%s", mcaMicroserviceUrl, productId),
                    ProductDetail.class
            );
        return CompletableFuture.completedFuture(productDetail);
    }

}
