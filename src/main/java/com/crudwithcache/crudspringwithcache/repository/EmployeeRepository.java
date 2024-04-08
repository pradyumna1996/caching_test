package com.crudwithcache.crudspringwithcache.repository;

import com.crudwithcache.crudspringwithcache.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Repository of an Employee that extends Jpa Repo
 * Added Method to find employee by specific id
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    /**
     * A Method provided to fetch vale of model by id
     * @param id parameter to pass for employee id
     * @return Employee object of passed id
     */
    Employee getEmployeeById(Long id);
}
