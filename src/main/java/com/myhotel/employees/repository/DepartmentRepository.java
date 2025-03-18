package com.myhotel.employees.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.myhotel.employees.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
