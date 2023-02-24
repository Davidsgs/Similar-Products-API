package com.similar.product.feign;

import com.similar.product.messaging.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(value = "productFeignClient", url = "${client.product.url}/product")
public interface ProductFeignClient {

    @GetMapping(value = "/{productId}/similarids", consumes = "application/json", produces = "application/json")
    Set<String> getSimilarProductsIdsForAProductId(@PathVariable("productId") String productId);

    @GetMapping(value = "/{productId}", consumes = "application/json", produces = "application/json")
    ProductDetail getProductDetailById(@PathVariable("productId") String productId);
}
