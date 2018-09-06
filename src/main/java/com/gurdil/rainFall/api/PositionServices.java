package com.gurdil.rainFall.api;

import com.gurdil.rainFall.dao.domain.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PositionServices {

    public Page<Position> getList(PageRequest pageRequest);

    public Page<Position> getList();

}
