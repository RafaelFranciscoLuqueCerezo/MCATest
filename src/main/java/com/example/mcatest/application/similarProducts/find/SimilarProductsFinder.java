package com.example.mcatest.application.similarProducts.find;

import com.example.mcatest.application.similarProducts.find.dto.ProductDetail;
import com.example.mcatest.application.similarProducts.find.dto.SimilarProducts;
import com.example.mcatest.microservices.McaMicroservice.McaMicroservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimilarProductsFinder {
    private final McaMicroservice mcaMicroservice;

    public SimilarProducts getSimilarProducts(String productId){
        List<Integer> similarProductIds = mcaMicroservice.getMcaSimilarProducts(productId);
        List<ProductDetail> productDetailList = similarProductIds.stream().map(id->mcaMicroservice.getMcaProductDetail(String.valueOf(id))).collect(Collectors.toList());
        return SimilarProducts.builder().productDetailList(productDetailList).build();
    }
}
