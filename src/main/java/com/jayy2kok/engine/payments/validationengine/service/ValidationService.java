/* @Author jayy2kok (C)2023 */
package com.jayy2kok.engine.payments.validationengine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayy2kok.engine.payments.validationengine.model.PathType;
import com.jayy2kok.engine.payments.validationengine.model.Rule;
import com.jayy2kok.engine.payments.validationengine.repository.RulesRepository;

import lombok.Builder.Default;

@Service
public class ValidationService {

    @Autowired
    private RulesRepository repository;

    public void validate(String payload, PathType type) {
        Map<String, Set<Rule>> ruleGroups = new HashMap<>();

        List<String> outputCodeList = new ArrayList<>();

        repository
                .findAllOrderBygroupId()
                .forEach(
                        rule -> {
                            String key = Objects.requireNonNullElse(rule.groupId(), UUID.randomUUID().toString());
                            ruleGroups.putIfAbsent(key, new HashSet<>());
                            ruleGroups.get(key).add(rule);
                        });

        ruleGroups.forEach(group -> {

        });
    }
}
