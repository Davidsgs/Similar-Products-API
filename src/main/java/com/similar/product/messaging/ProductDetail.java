package com.similar.product.messaging;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDetail implements Serializable {
    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Boolean availability;
}
