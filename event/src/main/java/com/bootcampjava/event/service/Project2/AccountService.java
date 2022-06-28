package com.bootcampjava.event.service.Project2;

import com.bootcampjava.event.domain.Project2.Account;
import com.bootcampjava.event.domain.Project2.Afp;
import com.bootcampjava.event.domain.Project2.Employee;
import com.bootcampjava.event.mapper.Project2.AccountMapper;
import com.bootcampjava.event.model.Project2.AccountModel;
import com.bootcampjava.event.repository.Project2.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountModel> findAll() throws Exception {
        List<Account> list = accountRepository.findAll();
        return accountMapper.AccountToAccountModels(list);
    }

    @Override
    public AccountModel findById(Long id) throws Exception {
        Optional<Account> domain = accountRepository.findById(id);
        if(domain.isPresent())	return accountMapper.AccountToAccountModel(domain.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public AccountModel create(AccountModel accountModel) throws Exception {
        Optional<Account> optional = accountRepository.findByDocument(accountModel.getDocument());
        if(optional.isPresent()) {
            throw new Exception("Empleado ya cuenta con AFP registrado");
        } else {
            Account account = accountRepository.save(accountMapper.AccountModelToAccount(accountModel));
            return accountMapper.AccountToAccountModel(account);
        }
    }

    @Override
    public void update(Long id, AccountModel accountModel) throws Exception {
        Optional<Account> optional = accountRepository.findById(id);

        if(optional.isPresent()) {
            Account update = optional.get();
            accountMapper.update(update, accountModel);
            accountRepository.save(update);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        accountRepository.deleteById(id);
    }
}
