package com.waly.cassandraDb.services;

import com.waly.cassandraDb.model.dto.DepartmentDTO;
import com.waly.cassandraDb.model.entities.Department;
import com.waly.cassandraDb.repositories.DepartmentRepository;
import com.waly.cassandraDb.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<DepartmentDTO> findAll(){
        List<Department> list = repository.findAll();
        return list.stream().map(DepartmentDTO::new).toList();
    }

    public DepartmentDTO findById(UUID id) {
        Department dept = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("id not found"));
        return new DepartmentDTO(dept);
    }

    public DepartmentDTO insert(DepartmentDTO dto) {
        Department dept = new Department();
        dept.setName(dto.getName());
        dept.setId(UUID.randomUUID());
        repository.save(dept);
        return new DepartmentDTO(dept);
    }
    public DepartmentDTO update(UUID id, DepartmentDTO dto) {
        Department dept = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id not found"));
        dept.setName(dto.getName());
        repository.save(dept);
        return new DepartmentDTO(dept);
    }

    public void delete(UUID id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("id not found");
        }
        repository.deleteById(id);
    }
}
