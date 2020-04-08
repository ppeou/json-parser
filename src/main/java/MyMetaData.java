import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyMetaData {
    @JsonProperty("data-testid")
    public String testId;

    @JsonProperty("label")
    public String label;
}
