package com.bootcampjava.event.service.Project2;

import com.bootcampjava.event.model.Project2.AccountModel;
import com.bootcampjava.event.model.Project2.AfpModel;

import java.util.List;

public interface IAccountService {
    List<AccountModel> findAll() throws Exception;

    AccountModel findById(Long id) throws Exception;

    AccountModel create(AccountModel accountModel) throws Exception;

    void update(Long id, AccountModel accountModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
