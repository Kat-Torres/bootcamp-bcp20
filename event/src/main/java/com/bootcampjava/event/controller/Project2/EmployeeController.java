package com.bootcampjava.event.controller.Project2;

import com.bootcampjava.event.model.Project2.AfpModel;
import com.bootcampjava.event.model.Project2.EmployeeModel;
import com.bootcampjava.event.service.Project2.IAfpService;
import com.bootcampjava.event.service.Project2.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Slf4j
public class EmployeeController {
    private final IEmployeeService service;

    @GetMapping(path = { "employee" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<EmployeeModel> response =  service.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "employee/{id}" }, produces = { "application/json" })
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception{
        EmployeeModel response = service.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "employee")
    public ResponseEntity<Object> create(@RequestBody EmployeeModel model) throws Exception {
        EmployeeModel response = service.create(model);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "employee/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody EmployeeModel model) throws Exception {
        service.update(id, model);
    }


    @DeleteMapping({ "employee/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        service.deleteById(id);

    }
}
