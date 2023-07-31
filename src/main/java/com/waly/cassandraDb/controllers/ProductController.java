package com.waly.cassandraDb.controllers;

import com.waly.cassandraDb.model.dto.DepartmentDTO;
import com.waly.cassandraDb.model.dto.ProductDTO;
import com.waly.cassandraDb.model.entities.Product;
import com.waly.cassandraDb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id){
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
}
