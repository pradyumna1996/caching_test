package com.crudwithcache.crudspringwithcache.controller;

import com.crudwithcache.crudspringwithcache.handler.MyResponseHandler;
import com.crudwithcache.crudspringwithcache.model.Employee;
import com.crudwithcache.crudspringwithcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * A Rest Controller to Save , Get and Delete Employee
 */
@RestController
public class EmployeeController {

    /**
     * Bean Injection of Employee Service
     */
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
    }

    /**
     * Method to get all employees
     * @return Employees in JSON
     */
    @GetMapping("/employee")
    public ResponseEntity<Object> getAllEmployee(){
       List<Employee> empList = employeeService.getAllEmployee();
       if(!empList.isEmpty()){
           return MyResponseHandler.generateResponse(true, HttpStatus.OK,empList);
       }
        return MyResponseHandler.generateResponse(false, HttpStatus.NO_CONTENT,empList);
    }

    /**
     * Method to save employee
     * @param employee Request Body of Employee
     * @return Employee Object with custom response
     */
    @PostMapping("/employee")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee){

            Employee employee1 = employeeService.saveEmployee(employee);

        if(!(employee1==null)){
            return MyResponseHandler.generateResponse(true,HttpStatus.CREATED,employee);
        }
        return MyResponseHandler.generateResponse(false,HttpStatus.INTERNAL_SERVER_ERROR,null);

    }

    /**
     * Method To Delete Employee By Id
     * @param id Long Employee Id
     * @return String with message
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){


        boolean isDeleted = employeeService.deleteEmployeeById(id);

        if(isDeleted){
            return ResponseEntity.ok("Employee Deleted !");
        }
        return ResponseEntity.ok("Employee Deleted Unsuccessfully !!");
    }

    /**
     * Method to Update Employee By Id
     * @param employee Employee Object That is Passed
     * @param id employee ids to be updated
     * @return Updated Employee Object
     */
    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployeeById(@RequestBody Employee employee , @PathVariable Long id){

        Employee updatedEmployee = employeeService.updateEmployeeById(employee , id);

        return MyResponseHandler.generateResponse(true,HttpStatus.OK,updatedEmployee);

    }

    /**
     * Method To Fetch Employee By Id
     * @param id Id Passed
     * @return Employee Object of entered Id
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id){
        Employee emp = employeeService.getEmployeeById(id);
        return MyResponseHandler.generateResponse(true,HttpStatus.FOUND,emp);
    }

    /**
     * Method To Delete All Employee
     * @return Response String
     */
    @DeleteMapping("/employee/deleteAll")
    public ResponseEntity<String> deleteAllEmployee(){

        boolean areDeleted= employeeService.deleteAllEmployee();

        if(areDeleted){
            return  ResponseEntity.ok("All Employee are Deleted !");
        }
        return  ResponseEntity.unprocessableEntity().body("Deletion Unsuccessful");

    }



}
