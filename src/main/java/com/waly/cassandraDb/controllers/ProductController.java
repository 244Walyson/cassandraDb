package com.waly.cassandraDb.controllers;

import com.waly.cassandraDb.model.dto.DepartmentDTO;
import com.waly.cassandraDb.model.dto.ProductDTO;
import com.waly.cassandraDb.model.entities.Product;
import com.waly.cassandraDb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public ResponseEntity<List<ProductDTO>> productsByDepartment(@RequestParam(value = "department", defaultValue = "") String department){
        List<ProductDTO> dto = service.ProductsByDepartment(department);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(@RequestParam(value = "text", defaultValue = "") String text){
        List<ProductDTO> dto = service.findByDescription(text);
        return ResponseEntity.ok(dto);
    }
}
