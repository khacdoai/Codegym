package com.example.case_study.service.impl;

import com.example.case_study.model.BoPhan;
import com.example.case_study.repository.IBoPhanRepository;
import com.example.case_study.repository.impl.BoPhanRepository;
import com.example.case_study.service.IBoPhanService;

import java.util.List;

public class BoPhanService implements IBoPhanService {
    private static IBoPhanRepository boPhanRepository = new BoPhanRepository();
    @Override
    public List<BoPhan> showlist() {
        return boPhanRepository.showlist();
    }
}
