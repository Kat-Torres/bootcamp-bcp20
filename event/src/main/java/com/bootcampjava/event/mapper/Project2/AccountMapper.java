package com.bootcampjava.event.mapper.Project2;

import com.bootcampjava.event.domain.Project2.Account;
import com.bootcampjava.event.domain.Project2.Afp;
import com.bootcampjava.event.model.Project2.AccountModel;
import com.bootcampjava.event.model.Project2.AfpModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account AccountModelToAccount (AccountModel model);

    AccountModel AccountToAccountModel (Account domain);

    List<AccountModel> AccountToAccountModels (List<Account> domains);
    void update(@MappingTarget Account entity, AccountModel updateEntity);
}
