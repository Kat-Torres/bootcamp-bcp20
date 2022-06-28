package com.bootcampjava.event.controller.Project2;


import com.bootcampjava.event.model.Project2.AfpModel;

import com.bootcampjava.event.service.Project2.IAfpService;
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
public class AfpController {
    private final IAfpService afpService;

    @GetMapping(path = { "afp" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<AfpModel> response =  afpService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "afp/{id}" }, produces = { "application/json" })
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception{
        AfpModel response = afpService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "afp")
    public ResponseEntity<Object> create(@RequestBody AfpModel afpModel) throws Exception {
        AfpModel response = afpService.create(afpModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "afp/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody AfpModel afpModel) throws Exception {
        afpService.update(id, afpModel);
    }


    @DeleteMapping({ "afp/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        afpService.deleteById(id);

    }
}
