package com.bootcampjava.event.controller.Project2;

import com.bootcampjava.event.model.Project2.AccountModel;
import com.bootcampjava.event.model.Project2.AfpModel;
import com.bootcampjava.event.service.Project2.IAccountService;
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
public class AccountController {
    private final IAccountService accountService;

    @GetMapping(path = { "account" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<AccountModel> response =  accountService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "account/{id}" }, produces = { "application/json" })
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception{
        AccountModel response = accountService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "account")
    public ResponseEntity<Object> create(@RequestBody AccountModel accountModel) throws Exception {
        AccountModel response = accountService.create(accountModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "account/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody AccountModel accountModel) throws Exception {
        accountService.update(id, accountModel);
    }


    @DeleteMapping({ "account/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        accountService.deleteById(id);

    }
}
