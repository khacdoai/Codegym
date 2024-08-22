package com.example.register.service;

import com.example.register.model.Acount;
import com.example.register.repository.IAcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;

@Service
public class acountService implements IAcountService {
    @Autowired
    IAcountRepository iAcountRepository ;

    @Override
    public void saveAcount(Acount acount) {
        iAcountRepository.save(acount);
    }

    @Override
    public boolean checkExistingAccountByAcount(String email) {
        return iAcountRepository.existsByEmail(email);
    }
}
