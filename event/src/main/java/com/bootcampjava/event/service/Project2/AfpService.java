package com.bootcampjava.event.service.Project2;

import com.bootcampjava.event.domain.Project2.Afp;
import com.bootcampjava.event.mapper.Project2.AfpMapper;
import com.bootcampjava.event.model.Project2.AfpModel;

import com.bootcampjava.event.repository.Project2.AfpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AfpService implements IAfpService {

    private final AfpRepository afpRepository;
    private final AfpMapper afpMapper;

    @Override
    public List<AfpModel> findAll() throws Exception {
        List<Afp> list = afpRepository.findAll();
        return afpMapper.domainsTomodels(list);
    }

    @Override
    public AfpModel findById(Long id) throws Exception {
        Optional<Afp> domain = afpRepository.findById(id);
        if(domain.isPresent())	return afpMapper.domainTomodel(domain.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public AfpModel create(AfpModel afpModel) throws Exception {
        Afp afp = afpRepository.save(afpMapper.modelTodomains(afpModel));
        return afpMapper.domainTomodel(afp);
    }

    @Override
    public void update(Long id, AfpModel afpModel) throws Exception {
        Optional<Afp> afpOptional = afpRepository.findById(id);

        if(afpOptional.isPresent()) {
            Afp afpToUpdate = afpOptional.get();
            afpMapper.update(afpToUpdate, afpModel);
            afpRepository.save(afpToUpdate);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        afpRepository.deleteById(id);
    }
}
