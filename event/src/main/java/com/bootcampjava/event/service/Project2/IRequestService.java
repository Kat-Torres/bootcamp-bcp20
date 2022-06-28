package com.bootcampjava.event.service.Project2;

import com.bootcampjava.event.model.Project2.RequestModel;

import java.util.List;

public interface IRequestService {
    List<RequestModel> findAll() throws Exception;

    RequestModel findById(Long id) throws Exception;

    RequestModel create(RequestModel requestModel) throws Exception;

    void update(Long id, RequestModel requestModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
