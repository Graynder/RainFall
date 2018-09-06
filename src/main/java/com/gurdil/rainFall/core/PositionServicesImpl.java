package com.gurdil.rainFall.core;

import com.gurdil.rainFall.api.PositionServices;
import com.gurdil.rainFall.dao.domain.Position;
import com.gurdil.rainFall.dao.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PositionServicesImpl implements PositionServices {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Page<Position> getList(PageRequest pageRequest) {
        return positionRepository.findAll(pageRequest);
    }

    @Override
    public Page<Position> getList() {
        return positionRepository.findAll(Pageable.unpaged());
    }

}
