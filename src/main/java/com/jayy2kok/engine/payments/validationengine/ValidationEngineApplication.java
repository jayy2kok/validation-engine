/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidationEngineApplication {

  /*  @Autowired
  private Rules testRules;
   */
  public static void main(String[] args) {
    SpringApplication.run(ValidationEngineApplication.class, args);
  }
  /*
  public void run(String... args) throws Exception {
      Rule testRule1 = new Rule("field1", "100", RuleOperator.EQAL, "RF01");
      Rule testRule2 = new Rule("field2", "100", RuleOperator.EQAL, "RF01").ruleId(UUID.randomUUID().toString() + "random");
      testRules.addRule(testRule1).addRule(testRule2);

  } */
}
