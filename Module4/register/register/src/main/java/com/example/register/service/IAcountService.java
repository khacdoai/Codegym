package com.example.register.service;

import com.example.register.model.Acount;
import org.springframework.stereotype.Service;


public interface IAcountService {
    void saveAcount(Acount acount);
    boolean checkExistingAccountByAcount(String acount);
}
