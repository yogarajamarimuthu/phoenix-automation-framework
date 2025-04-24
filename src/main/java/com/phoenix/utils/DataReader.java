package com.phoenix.utils;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public class DataReader {

    public static List<Object[]> getTestData(String fileType, String filePath, String sheetName) {
        if ("excel".equalsIgnoreCase(fileType)) {
            return ExcelReader.readExcelData(filePath, sheetName);
        } else {
            throw new IllegalArgumentException("Unsupported data file type: " + fileType);
        }
    }

    public static JsonNode getJsonData(String filePath){
        return JsonReader.readJsonData(filePath);
    }

    public static String getJsonValue(JsonNode node, String key){
        return JsonReader.getJsonValue(node, key);
    }
}
