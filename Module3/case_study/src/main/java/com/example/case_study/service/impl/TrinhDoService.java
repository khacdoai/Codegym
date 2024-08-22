package com.example.case_study.service.impl;

import com.example.case_study.model.TrinhDo;
import com.example.case_study.repository.ITrinhDoRepository;
import com.example.case_study.repository.impl.TrinhDoRepository;
import com.example.case_study.service.ITrinhDoService;

import java.util.List;

public class TrinhDoService implements ITrinhDoService {
    public static ITrinhDoRepository trinhDoRepository = new TrinhDoRepository();
    @Override
    public List<TrinhDo> showList() {
        return trinhDoRepository.showList();
    }
}
