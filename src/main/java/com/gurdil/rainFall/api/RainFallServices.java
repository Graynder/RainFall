package com.gurdil.rainFall.api;

import com.gurdil.rainFall.dao.domain.Rainfall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RainFallServices {

    public Page<Rainfall> getList(PageRequest pageRequest);

    public Page<Rainfall> getList();

    public Page<Rainfall> getListByPositionId(PageRequest pageRequest, Long id);

    public Page<Rainfall> getListByPositionId(Long id);

    public Rainfall getElement(Long id);
}
