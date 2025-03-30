package com.projects.mycommerce.services;

import com.projects.mycommerce.dto.ProductDTO;
import com.projects.mycommerce.entities.Product;
import com.projects.mycommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product  = repository.findById(id).get();
        return new ProductDTO(product);
    }
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> productsResult = repository.findAll(pageable);
        return productsResult.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

}
