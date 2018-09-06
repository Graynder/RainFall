package com.gurdil.rainFall.ws;

import com.gurdil.rainFall.api.PositionServices;
import com.gurdil.rainFall.common.validator.PaginationValidator;
import com.gurdil.rainFall.dao.domain.Position;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    private static final Logger LOGGER = LogManager.getLogger((PositionController.class));


    @Autowired
    private PositionServices positionServices;

    @GetMapping(value = "/positions", produces = "application/json")
    public Page<Position> listPosition(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        LOGGER.info("START with page={} and limit={}", page, limit);

        Page<Position> listPos = null;

        PageRequest pageRequest = PaginationValidator.paginationValidator(page, limit);

        if (pageRequest == null) {
            listPos = positionServices.getList();
        } else {
            listPos = positionServices.getList(pageRequest);
        }
        LOGGER.info("number of element returned: {}", listPos.getNumberOfElements());
        return listPos;
    }
}
