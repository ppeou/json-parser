import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyComponent {

    @JsonProperty("component")
    String component;

    @JsonProperty("items")
    public MyComponent[] items;

    @JsonProperty("metaData")
    public MyMetaData metaData;

}
