/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine.service;

import com.jayy2kok.engine.payments.validationengine.model.Rule;
import com.jayy2kok.engine.payments.validationengine.repository.RulesRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RulesService {

  @Autowired private RulesRepository repository;

  @Autowired private Validator validator;

  public Rule addRule(Rule rule) {
    Set<ConstraintViolation<Rule>> violations = validator.validate(rule);
    for (ConstraintViolation<Rule> violation : violations) {
      log.error(violation.getMessage());
    }
    if (!violations.isEmpty()) {
      throw new IllegalArgumentException("Rules cannot be added, due to errors");
    }
    return repository.save(rule);
  }

  public Set<Rule> findAllRules() {
    return repository.findAllOrderBygroupId();
  }
}
