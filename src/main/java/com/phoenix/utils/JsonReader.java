package com.phoenix.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {

    public static JsonNode readJsonData(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Or throw an exception if you prefer
        }
    }

    public static String getJsonValue(JsonNode node, String key) {
        JsonNode valueNode = node.get(key);
        return valueNode != null ? valueNode.asText() : null;
    }
}