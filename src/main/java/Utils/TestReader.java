package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestReader {
    private final ObjectMapper objectMapper;
    private ObjectNode objectNode;
    public TestReader(Path filepath) throws IOException {
        objectMapper = new ObjectMapper();
        String readContents = new String(Files.readAllBytes(filepath));
        objectNode = (ObjectNode) objectMapper.readTree(readContents);
    }

    public TestReader(String filepath) throws IOException {
        this(Path.of(filepath));
    }
    //JSON Reader
    public void readFile(String filepath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Path.of(filepath));
        JsonNode jsonNode = objectMapper.readTree(fileBytes);
        if(jsonNode instanceof ObjectNode) {
            objectNode = (ObjectNode) jsonNode;
        }else {
            throw new IllegalArgumentException("Config file must contain Json object");
        }
    }
    public List<Object> getList(String key) {
        JsonNode node = objectNode.get(key);
        if (node.isArray()) {
            List<Object> list = new ArrayList<>();
            for (JsonNode element : node) {
                if (element.isValueNode()) {
                    list.add(element.asText());
                } else if (element.isObject()) {
                    list.add(objectMapper.convertValue(element, Map.class));
                } else {
                    throw new IllegalArgumentException(key + " contains an invalid element");
                }
            }
            return list;
        } else {
            throw new IllegalArgumentException(key + " is not an array");
        }
    }
    public Map<String, Object> getMap(String key) {
        JsonNode node = objectNode.get(key);
        if (node.isObject()) {
            Map<String, Object> map = new HashMap<>();
            for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                String fieldName = it.next();
                JsonNode valueNode = node.get(fieldName);
                if (valueNode.isValueNode()) {
                    map.put(fieldName, valueNode.asText());
                } else if (valueNode.isObject()) {
                    map.put(fieldName, objectMapper.convertValue(valueNode, Map.class));
                } else {
                    throw new IllegalArgumentException(key + " contains an invalid value");
                }
            }
            return map;
        } else {
            throw new IllegalArgumentException(key + " is not an object");
        }
    }
}
