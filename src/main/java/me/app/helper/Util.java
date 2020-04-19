package me.app.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.util.*;

public class Util {
    public static MetaDataComponent clone(MetaDataComponentJson item) {
        MetaDataComponent newItem = new MetaDataComponent();
        newItem.component = item.component;
        newItem.label = item.label;
        newItem.testId = item.testId;
        return newItem;
    }
    public static Map<String, MetaDataComponent> flatNestedArray(MetaDataComponentJson myComponent, Map newMap) {
        if(newMap == null) {
            newMap = new HashMap<String, MetaDataComponent>();
        }
        newMap.put(myComponent.testId, clone(myComponent));
        if(myComponent.items != null && myComponent.items.length > 0) {
            for(MetaDataComponentJson x : myComponent.items) {
                flatNestedArray(x, newMap);
            }
        }

        return newMap;
    }

    public static Map<String, MetaDataComponent> readJSONFile(String profileFile) {
        try {
            FileReader fileReader = new FileReader(profileFile);
            ObjectMapper mapper = new ObjectMapper();

            //load JSON file into me.app.core.MyComponentJSON object
            MetaDataComponentJson obj = mapper.readValue(fileReader, MetaDataComponentJson.class);

            //flat me.app.core.MyComponentJSON nested structure into flat Map<String, me.app.core.MyComponent>
            return Util.flatNestedArray(obj, null);
        } catch (Exception ex) {
            return null;
        }
    }
}
