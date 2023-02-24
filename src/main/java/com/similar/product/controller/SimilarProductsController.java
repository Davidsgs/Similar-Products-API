package com.similar.product.controller;


import com.similar.product.messaging.ProductDetail;
import com.similar.product.service.SimilarProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
@Tag(name = "default")
public class SimilarProductsController {

    private final SimilarProductService productService;

    @GetMapping("/{productId}/similar")
    @Operation(summary = "Similar products")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ProductDetail.class)))}),
            @ApiResponse(responseCode = "404", description = "Product Not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<Set<ProductDetail>> getSimilarProductsFromProductId(@PathVariable(value = "productId") String productId) {
        return ResponseEntity.ok(productService.getSimilarProductsFromProductId(productId));
    }

}
