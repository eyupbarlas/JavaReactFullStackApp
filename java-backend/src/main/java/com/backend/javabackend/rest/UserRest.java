package com.backend.javabackend.rest;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.backend.javabackend.constants.FullStackAppConstants.API_V_1_USER;

@RestController
@RequestMapping(value = API_V_1_USER)
@RequiredArgsConstructor
public class UserRest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
