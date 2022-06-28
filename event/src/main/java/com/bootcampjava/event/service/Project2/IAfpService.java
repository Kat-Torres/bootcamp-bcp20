package com.bootcampjava.event.service.Project2;
import com.bootcampjava.event.model.Project2.AfpModel;
import java.util.List;

public interface IAfpService {
    List<AfpModel> findAll() throws Exception;

    AfpModel findById(Long id) throws Exception;

    AfpModel create(AfpModel afpModel) throws Exception;

    void update(Long id, AfpModel afpModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
