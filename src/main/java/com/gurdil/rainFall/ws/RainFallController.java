package com.gurdil.rainFall.ws;

import com.gurdil.rainFall.api.RainFallServices;
import com.gurdil.rainFall.common.validator.PaginationValidator;
import com.gurdil.rainFall.dao.domain.Rainfall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RainFallController {

    private static final Logger LOGGER = LogManager.getLogger((RainFallController.class));


    @Autowired
    private RainFallServices rainFallServices;

    @GetMapping(value = "/rainfall", produces = "application/json")
    public Page<Rainfall> listRainFall(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        LOGGER.info("START with page={} and limit={}", page, limit);

        Page<Rainfall> listRainFall = null;

        PageRequest pageRequest = PaginationValidator.paginationValidator(page, limit);

        if (pageRequest == null) {
            listRainFall = rainFallServices.getList();
        } else {
            listRainFall = rainFallServices.getList(pageRequest);
        }
        LOGGER.info("number of element returned: {}", listRainFall.getNumberOfElements());
        return listRainFall;
    }

    @GetMapping(value = "/rainfall/{rainId}", produces = "application/json")
    public Rainfall getRainFall(@PathVariable Long rainId) {

        return rainFallServices.getElement(rainId);
    }

    @GetMapping(value = "positions/{posId}/rainfall", produces = "application/json")
    public Page<Rainfall> listRainFallByPositionId(@PathVariable Long posId,
                                                   @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
        LOGGER.info("START with page={} and limit={}", page, limit);

        Page<Rainfall> listRainFall = null;

        PageRequest pageRequest = PaginationValidator.paginationValidator(page, limit);

        if (pageRequest == null) {
            listRainFall = rainFallServices.getListByPositionId(posId);
        } else {
            listRainFall = rainFallServices.getListByPositionId(pageRequest, posId);
        }
        LOGGER.info("number of element returned: {}", listRainFall.getNumberOfElements());
        return listRainFall;
    }

    @GetMapping(value = "positions/{posId}/rainfall/{rainId}", produces = "application/json")
    public Rainfall getRainFallByPositionId(@PathVariable Long rainId) {
        return rainFallServices.getElement(rainId);
    }
}
