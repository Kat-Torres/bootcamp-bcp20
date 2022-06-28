package com.bootcampjava.event.controller.Project2;

import com.bootcampjava.event.model.Project2.AfpModel;
import com.bootcampjava.event.model.Project2.RequestModel;
import com.bootcampjava.event.service.Project2.IAfpService;
import com.bootcampjava.event.service.Project2.IRequestService;
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
public class RequestController {
    private final IRequestService requestService;

    @GetMapping(path = { "request" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<RequestModel> response =  requestService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "request/{id}" }, produces = { "application/json" })
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception{
        RequestModel response = requestService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "request")
    public ResponseEntity<Object> create(@RequestBody RequestModel requestModel) throws Exception {
        RequestModel response = requestService.create(requestModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "request/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody RequestModel requestModel) throws Exception {
        requestService.update(id, requestModel);
    }


    @DeleteMapping({ "request/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        requestService.deleteById(id);

    }
}
