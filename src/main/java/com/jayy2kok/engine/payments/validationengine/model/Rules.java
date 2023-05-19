/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Slf4j
@Component
public class Rules {

  @NonNull @Autowired private Validator validator;
  private Set<Rule> rules = new HashSet<Rule>();
  private String description;

  public Rules addRule(Rule rule) {
    if (!this.rules.add(rule)) {
      throw new IllegalArgumentException("Unable to add duplicate rule: " + rule.toString());
    }
    Set<ConstraintViolation<Rule>> violations = validator.validate(rule);
    for (ConstraintViolation<Rule> violation : violations) {
      log.error(violation.getMessage());
    }
    if (!violations.isEmpty()) {
      throw new IllegalArgumentException("Rules cannot be added, due to errors");
    }
    return this;
  }
}
