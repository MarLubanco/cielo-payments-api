package com.cielo.service;

import com.cielo.exception.NotExistIntegration;
import com.cielo.model.IntegrationBank;
import com.cielo.repository.IntegrationBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationBankService {

    @Autowired
    private IntegrationBankRepository integrationBankRepository;

    /**
     * Persist legacy system integration data
     * @param integrationBank
     * @return
     */
    public IntegrationBank saveIntegration(IntegrationBank integrationBank) {
        return integrationBankRepository.save(integrationBank);
    }

    /**
     * Returns integration by id
     * @param id
     * @return
     */
    public IntegrationBank findById(Integer id) {
        return integrationBankRepository.findById(id)
                .orElseThrow(() -> new NotExistIntegration("Essa integração não existe!"));
    }
}
