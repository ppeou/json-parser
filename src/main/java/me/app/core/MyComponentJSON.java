package me.app.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyComponentJSON {

    @JsonProperty("component")
    public String component;

    @JsonProperty("items")
    public MyComponentJSON[] items;

    public String label;
    public String testId;

    @SuppressWarnings("unchecked")
    @JsonProperty("metaData")
    private void unpackNested(Map<String,Object> metaData) {
        this.label = (String)metaData.get("label");
        this.testId = (String)metaData.get("data-testid");
    }
}
