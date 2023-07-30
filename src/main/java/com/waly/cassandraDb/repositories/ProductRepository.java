package com.waly.cassandraDb.repositories;

import com.waly.cassandraDb.model.entities.Department;
import com.waly.cassandraDb.model.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
