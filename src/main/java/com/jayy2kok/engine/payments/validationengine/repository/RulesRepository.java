/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine.repository;

import com.jayy2kok.engine.payments.validationengine.model.Rule;
import java.util.Set;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RulesRepository extends MongoRepository<Rule, String> {

  Set<Rule> findAllOrderBygroupId();
}
