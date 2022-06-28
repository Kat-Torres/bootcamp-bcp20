package com.bootcampjava.event.mapper.Project2;

import com.bootcampjava.event.domain.Project2.Request;
import com.bootcampjava.event.model.Project2.RequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    Request RequestModelToRequest (RequestModel model);

    RequestModel RequestToRequestModel (Request domain);

    List<RequestModel> RequestsToRequestModels (List<Request> domains);
    void update(@MappingTarget Request entity, RequestModel updateEntity);
}
