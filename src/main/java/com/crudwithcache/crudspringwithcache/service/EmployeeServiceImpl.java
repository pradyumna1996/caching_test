package com.crudwithcache.crudspringwithcache.service;

import com.crudwithcache.crudspringwithcache.model.Employee;
import com.crudwithcache.crudspringwithcache.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation of Service Class implements different services
 * CRUD Operations
 */
@Service
public class EmployeeServiceImpl implements  EmployeeService {

    /**
     * Employee Repository Injected
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Implementation of getting all emoloyees
     * @return all employees
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll() ;
    }

    /**
     * Method To Save Employee
     * @param employee A Request Body Object of JSON Type
     * @return Employee Object
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    /**
     * Method to delete employee by an id
     * @param id Employee of Id to Be Deleted
     * @return True if deleted
     */
    @Override
    @CacheEvict(cacheNames = "employees", key = "#id")
    public boolean deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    /**
     * Method To Update Employee of specific id
     * @param employee An Updated Employee Object
     * @param id Employee with an id to be updated
     * @return updated Employee
     */
    @Override
    @CachePut(cacheNames = "employees", key = "#employee.id")
    public Employee updateEmployeeById(Employee employee, Long id) {

        Employee updatedEmployee = new Employee();

        Employee employeeDb =employeeRepository.getEmployeeById(id);


        String empName =employee.getEmployeeName();
        String empAddress = employee.getEmployeeAddress();

        employeeDb.setId(id);
        employeeDb.setEmployeeName(empName);
        employeeDb.setEmployeeAddress(empAddress);
        employeeRepository.save(employeeDb);

        return employeeDb;
    }

    /**
     * Gets Employee of Specific Passing Id
     * @param id The id of employee to be fetched
     * @return Specific employee of passed id
     */
    @Override
    @Cacheable(cacheNames = "employees",key="#id")
    public Employee getEmployeeById(Long id) {
        System.out.println(" Fetched From Db !!!");
        return employeeRepository.getEmployeeById(id);
    }

    /**
     * Method to delete all employees
     * @return true if all are deleted
     */
    @Override
    public boolean deleteAllEmployee() {
        employeeRepository.deleteAll();
        return true;
    }


}
