/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine.controller;

import com.jayy2kok.engine.payments.validationengine.model.Rule;
import com.jayy2kok.engine.payments.validationengine.service.RulesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RulesController {

  @Autowired private RulesService service;

  @PostMapping("rules")
  public ResponseEntity<Rule> addRule(@Valid @RequestBody Rule rule) {
    return new ResponseEntity<>(service.addRule(rule), HttpStatus.CREATED);
  }
}
