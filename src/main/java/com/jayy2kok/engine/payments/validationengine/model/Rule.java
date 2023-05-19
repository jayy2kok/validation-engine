/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine.model;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(fluent = true, chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Rule {

  private Integer ruleSequence;

  @Id
  @Length(max = 36, min = 1, message = "ruleId length should be between 1-36 characters")
  private String ruleId = UUID.randomUUID().toString();

  @Length(max = 36, message = "groupId length should be between 0-36 characters")
  @EqualsAndHashCode.Include
  private String groupId;

  @EqualsAndHashCode.Include
  @NotNull(message = "ruleOperator cannot be null")
  private RuleOperator ruleOperator;

  private GroupOperator groupOperator;
  @EqualsAndHashCode.Include private String valueField;

  @EqualsAndHashCode.Include
  @NotNull(message = "valueToCompare cannot be null")
  private String valueToCompare;

  private ValueType valueType = ValueType.STRING;
  private PathType type = PathType.XPATH;

  @Length(min = 1, max = 10, message = "outputCode length should be between 1-10 characters")
  @NotNull(message = "outputCode cannot be null")
  private String outputCode;

  @Length(max = 255, message = "description length should be between 0-255 characters")
  private String description;

  public Rule(
      String valueField, String valueToCompare, RuleOperator ruleOperator, String outputCode) {
    this.valueField = valueField;
    this.valueToCompare = valueToCompare;
    this.ruleOperator = ruleOperator;
    this.outputCode = outputCode;
  }
}
