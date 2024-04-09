package com.crudwithcache.crudspringwithcache.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *An Employee Model
 * Use of Lombok and JPA
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    /**
     * Variable of Long Type that holds an unique ID of an employee generated self
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Variable of String type that holds name of an employee
     */
    private String employeeName;

    /**
     * Variable of type String that holds an address of an employee
     */
    private String employeeAddress;


}
