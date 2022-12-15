package org.eugens21.testcontainers.config.storage;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Scope(SCOPE_CUCUMBER_GLUE)
public class ScenarioContext {

    Map<StorageKey, Object> store;

    public ScenarioContext() {
        this.store = new HashMap<>();
    }

    public void addValue(StorageKey key, Object value) {
        store.put(key, value);
    }

    public <T> T getValue(StorageKey key, Class<T> clazz) {
        return clazz.cast(store.get(key));
    }

}
