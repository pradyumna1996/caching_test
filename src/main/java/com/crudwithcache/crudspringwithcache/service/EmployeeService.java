package com.crudwithcache.crudspringwithcache.service;

import com.crudwithcache.crudspringwithcache.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Employee Service Interface
 * This Interface Provides The Abstract Services for
 * Creating , Updating , Getting, Deleting Employee
 */
@Service
public interface EmployeeService {

    /**
     * A Service Method To Get All Employees
     * @return List of Employees
     */
    List<Employee> getAllEmployee();

    /**
     * Method To Save an Employee
     * @param employee A Request Body Object of JSON Type
     * @return Employee Object with custom response
     */
    Employee saveEmployee(Employee employee);

    /**
     * This service method provides deleting a employee of specific id
     * @param id Employee of Id to Be Deleted
     * @return boolean value true if deleted
     */

    boolean deleteEmployeeById(Long id);

    /**
     * This service method provides service to update employee
     * @param employee An Updated Employee Object
     * @param id Employee with an id to be updated
     * @return An updated employee
     */
    Employee updateEmployeeById(Employee employee, Long id);

    /**
     * Service method to fetch specific Employee with an Id
     * @param id The id of employee to be fetched
     * @return Employee object with passed id with custom response
     */
    Employee getEmployeeById(Long id);

    /**
     * Service method to delete all employee
     * @return True if all deleted
     */
    boolean deleteAllEmployee();
}
