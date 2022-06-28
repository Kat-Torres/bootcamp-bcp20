package com.bootcampjava.event.mapper.Project2;

import com.bootcampjava.event.domain.Project2.Afp;
import com.bootcampjava.event.model.Project2.AfpModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AfpMapper {
    Afp modelTodomains (AfpModel model);

    AfpModel domainTomodel (Afp domain);

    List<AfpModel> domainsTomodels (List<Afp> domains);
    void update(@MappingTarget Afp entity, AfpModel updateEntity);
}
