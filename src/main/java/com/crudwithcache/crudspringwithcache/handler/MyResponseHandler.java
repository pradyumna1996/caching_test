package com.crudwithcache.crudspringwithcache.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * Response Handler Class that provides custom response
 */
public class MyResponseHandler {

    /**
     * A method That Provides Custom Response
     * @param success Server Response as True/False
     * @param status Server Status as HTTP Status
     * @param responseObj   A list that is being passed and returned
     * @return Custom Response adding to the list
     */
    public static ResponseEntity<Object> generateResponse(Boolean success, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("records", responseObj);
        return new ResponseEntity<>(map, status);


    }


}
