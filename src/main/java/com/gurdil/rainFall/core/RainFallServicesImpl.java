package com.gurdil.rainFall.core;

import com.gurdil.rainFall.api.RainFallServices;
import com.gurdil.rainFall.dao.domain.Rainfall;
import com.gurdil.rainFall.dao.repository.RainFallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RainFallServicesImpl implements RainFallServices {

    @Autowired
    private RainFallRepository rainFallRepository;

    @Override
    public Page<Rainfall> getList(PageRequest pageRequest) {
        return rainFallRepository.findAll(pageRequest);
    }

    @Override
    public Page<Rainfall> getList() {
        return rainFallRepository.findAll(Pageable.unpaged());
    }

    @Override
    public Page<Rainfall> getListByPositionId(PageRequest pageRequest, Long id) {
        Pageable pageable = PageRequest.of(1,1);
        return rainFallRepository.findAllByPositionId(id, pageable);
    }

    @Override
    public Page<Rainfall> getListByPositionId(Long id) {
        return rainFallRepository.findAllByPositionId(id,null);
    }

    @Override
    public Rainfall getElement(Long id) {
        return rainFallRepository.findById(id).get();
    }
}
