package com.similar.product.service;

import com.similar.product.feign.ProductFeignClient;
import com.similar.product.messaging.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimilarProductService {

    private final ProductFeignClient feignClient;

    @Cacheable("similarProducts")
    public Set<ProductDetail> getSimilarProductsFromProductId(String productId) {
        return feignClient.getSimilarProductsIdsForAProductId(productId)
                .stream()
                .map(feignClient::getProductDetailById)
                .collect(Collectors.toSet());
    }
}
