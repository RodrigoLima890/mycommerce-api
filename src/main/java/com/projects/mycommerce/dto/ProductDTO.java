package com.projects.mycommerce.dto;


import com.projects.mycommerce.entities.Product;
import jakarta.validation.constraints.*;

public class ProductDTO {

    private Long id;

    @NotBlank(message = "Campo Requerido")
    @Size(min = 3, max = 80, message = "O campo deve ter entre 3 e 80 caracteres")
    private String name;

    @NotBlank(message = "Campo Requerido")
    @Size(min = 10, message = "Deve ter no minimo 10 caracteres")
    private String description;
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgUrl;

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(){}

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
