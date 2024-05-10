package util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;


public final class ConfigReader {

    private final static String CONFIG_FILE_NAME = "config.yml";

    private static ConfigReader instance;

    private Config config;

    private ConfigReader() throws IOException {
        File file = new File(CONFIG_FILE_NAME);

        SimpleModule levelModule = new SimpleModule("LevelModule");
        levelModule.addSerializer(Level.class, new LevelJsonSerializer());
        levelModule.addDeserializer(Level.class, new LevelJsonDeserializer());

        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.registerModule(levelModule);
        config = om.readValue(file, Config.class);

    }


    public static ConfigReader instance() throws IOException {
        instance = instance == null ? new ConfigReader() : instance;
        return instance;
    }

    public Config getTestConfiguration() {
        return config;
    }


    static class LevelJsonSerializer extends JsonSerializer<Level> {

        @Override
        public void serialize(Level value, JsonGenerator gen, SerializerProvider serializers) throws IOException, IOException {
            gen.writeString(value.getName());
        }
    }

    static class LevelJsonDeserializer extends JsonDeserializer<Level> {

        @Override
        public Level deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String name = p.getText();

            return Level.parse(name);
        }
    }


}
