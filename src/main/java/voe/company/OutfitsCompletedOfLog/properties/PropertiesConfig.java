package voe.company.OutfitsCompletedOfLog.properties;

import lombok.Data;

import java.util.Properties;

@Data
public class PropertiesConfig {

   private final Properties properties = new Properties();

    public String getLocalhost() {
        return properties.getProperty("localhost");

    }

    public String getOffsetResetEarliest(){
        return properties.getProperty("offset_reset_earliest");
    }

    public String getTopicName(){
        return properties.getProperty("topic_name");
    }
}
