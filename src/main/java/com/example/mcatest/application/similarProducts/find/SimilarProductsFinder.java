package com.example.mcatest.application.similarProducts.find;

import com.example.mcatest.application.similarProducts.find.dto.ProductDetail;
import com.example.mcatest.application.similarProducts.find.dto.SimilarProducts;
import com.example.mcatest.domain.exception.NotFoundRestTemplateErrorException;
import com.example.mcatest.microservices.McaMicroservice.McaMicroservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SimilarProductsFinder {
    private final McaMicroservice mcaMicroservice;

    public SimilarProducts getSimilarProducts(String productId) {
        log.info("getting similar products for id {}", productId);
        List<Integer> similarProductIds = mcaMicroservice.getMcaSimilarProducts(productId);
        List<CompletableFuture<ProductDetail>> completableFutureList = new ArrayList<>();
        for (Integer similarProductId : similarProductIds) {
            completableFutureList.add(
                    mcaMicroservice.getAsyncMcaProductDetail(
                            String.valueOf(similarProductId)
                    ));
        }
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();
        List<ProductDetail> productDetailList = completableFutureList.stream()
                .map(completableFuture -> {
                    try {
                        return completableFuture.get();
                    } catch (InterruptedException | ExecutionException exception) {
                        throw new RuntimeException(exception);
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return SimilarProducts.builder().productDetailList(productDetailList).build();
    }


}
