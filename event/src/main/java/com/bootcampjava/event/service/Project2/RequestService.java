package com.bootcampjava.event.service.Project2;

import com.bootcampjava.event.domain.Project2.Account;
import com.bootcampjava.event.domain.Project2.Afp;
import com.bootcampjava.event.domain.Project2.Request;
import com.bootcampjava.event.mapper.Project2.AccountMapper;
import com.bootcampjava.event.mapper.Project2.AfpMapper;
import com.bootcampjava.event.mapper.Project2.RequestMapper;
import com.bootcampjava.event.model.Project2.RequestModel;
import com.bootcampjava.event.repository.Project2.AccountRepository;
import com.bootcampjava.event.repository.Project2.AfpRepository;
import com.bootcampjava.event.repository.Project2.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestService implements IRequestService{
    private final RequestRepository requestRepository;
    private final AccountRepository accountRepository;
    private final RequestMapper requestMapper;
    private final AccountMapper accountMapper;
    @Override
    public List<RequestModel> findAll() throws Exception {
        List<Request> list = requestRepository.findAll();
        return requestMapper.RequestsToRequestModels(list);
    }

    @Override
    public RequestModel findById(Long id) throws Exception {
        Optional<Request> domain = requestRepository.findById(id);
        if(domain.isPresent())	return requestMapper.RequestToRequestModel(domain.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public RequestModel create(RequestModel requestModel) throws Exception {

        // Obtiene sus datos de la cuenta
        Optional<Account> optionalAccount = accountRepository.findByDocument(requestModel.getDocument());
        if(optionalAccount.isPresent()) {
            Account update = optionalAccount.get();

            // Validamos que el monto de la solicitud sea mayor al 50%
            double d_monto_50 = update.getAvailable() / 2;

            if (requestModel.getAmount() < d_monto_50) {
                throw new Exception("Monto mínimo no cubierto, por favor revise el monto minímo a retirar");
            }

            double d_monto = update.getAvailable() - requestModel.getAmount();

            if (d_monto < 0) {
                throw new Exception("No se podra registrar la solicitud, monto mayor que el permitido");
            } else {
                update.setAvailable(update.getAvailable() - requestModel.getAmount());
                accountMapper.update(update, accountMapper.AccountToAccountModel(update));
                accountRepository.save(update);
            }
        } else {
            throw new Exception("No existe cuenta de AFP, para el empleado");
        }

        Request domain = requestRepository.save(requestMapper.RequestModelToRequest(requestModel));
        return requestMapper.RequestToRequestModel(domain);
    }

    @Override
    public void update(Long id, RequestModel requestModel) throws Exception {
        Optional<Request> optional = requestRepository.findById(id);

        if(optional.isPresent()) {
            Request update = optional.get();
            requestMapper.update(update, requestModel);
            requestRepository.save(update);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        requestRepository.deleteById(id);
    }
}
