package org.eugens21.testcontainers.stepdefs;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.eugens21.testcontainers.config.storage.ScenarioContext;
import org.modelmapper.ModelMapper;

import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PROTECTED)
@RequiredArgsConstructor
public abstract class BaseStep {

    SoftAssertions softAssertions;
    ModelMapper modelMap;
    ScenarioContext context;

}
