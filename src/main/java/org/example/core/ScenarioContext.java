package org.example.core;

import org.example.core.ui.AbstractPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext {

    private Map<String, String> context;

    private List<String> contextList;

    private AbstractPage home;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public void setContext(final String key, final String value) {
        String updatedValue = value;
        if(context.containsKey(key)) {
            updatedValue = value.concat(",").concat(context.get(key));
        }
        context.put(key, updatedValue);
    }

    public String getValue(final String key) {
        return context.get(key);
    }

}
