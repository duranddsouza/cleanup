package com.marshmallow.test.durand.controller;

import com.marshmallow.test.durand.mapper.CleanupMapper;
import com.marshmallow.test.durand.model.*;
import com.marshmallow.test.durand.service.CleanupService;
import com.marshmallow.test.durand.validator.CleanupValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cleanup")
public class CleanupController {

    @Autowired
    private CleanupValidator validator;

    @Autowired
    private CleanupMapper mapper;

    @Autowired
    private CleanupService service;

    Logger log = LoggerFactory.getLogger(CleanupController.class);

    @PostMapping
    public @ResponseBody ResponseEntity cleanup(@RequestBody CleanupDto cleanupDto) {
        try {
            log.info("Received request: " + cleanupDto.toString());
            validator.validate(cleanupDto);
            Cleanup cleanupData = mapper.dtoToModel(cleanupDto);
            CleanupResponse response = service.start(cleanupData);
            CleanupResponseDto responseDto = mapper.modelToDto(response);
            log.info("Response served: " + responseDto.toString());
            return ResponseEntity.ok(responseDto);
        } catch (IllegalStateException e) {
            log.warn(e.getMessage(), e);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto("Please contact support"));
        }
    }
}
