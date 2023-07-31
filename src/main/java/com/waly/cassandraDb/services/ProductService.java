package com.waly.cassandraDb.services;

import com.waly.cassandraDb.model.dto.ProductDTO;
import com.waly.cassandraDb.model.entities.Product;
import com.waly.cassandraDb.repositories.ProductRepository;
import com.waly.cassandraDb.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(UUID id){
        Product entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id not found"));
        return new ProductDTO(entity);
    }

    public List<ProductDTO> ProductsByDepartment(String department) {
        List<Product> list = repository.findByDepartment(department);
        return list.stream().map(ProductDTO::new).toList();
    }
}
