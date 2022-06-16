/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

/**
 *
 * @author BiG
 */
@Named
@RequestScoped
public class JsonFlow {

    @Inject
    private BeanCDI bean;
    private String jsonString;

    public void setBean(BeanCDI bean) {
        this.bean = bean;
    }

    public JsonFlow(BeanCDI bean) {
        this.bean = bean;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public String generateJson() {
        StringWriter stringWriter = new StringWriter();
        try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter)) {
            jsonGenerator.writeStartObject().
                    write("address", bean.getAddress()).
                    write("city", bean.getCity()).
                    write("postalCode", bean.getPostalCode()).
                    writeEnd();
        }

        StringWriter stringWriter2 = new StringWriter();
        try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter2)) {
            jsonGenerator.writeStartObject().
                    write("name", bean.getName()).
                    write("status", bean.getStatus()).
                    write("index", bean.getIndex()).
                    write("traditional", bean.isTraditional()).
                    write("contact", bean.getContact()).
                    write("role", bean.getRole()).
                    writeEnd();
        }
        setJsonString(stringWriter.toString());
        setJsonString(stringWriter2.toString());
        return "generate_json_flow";

    }

    public String parseJson() {
        StringReader stringReader = new StringReader(jsonString);
        JsonParser jsonParser = Json.createParser(stringReader);
        Map<String, Object> jsonMap = new HashMap<>();
        String jsonKey = null;
        Object jsonValue = null;
        
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event.equals(JsonParser.Event.KEY_NAME)) {
                jsonKey = jsonParser.getString();
            } else if (event.equals(JsonParser.Event.VALUE_STRING)) {
                jsonValue = jsonParser.getString();
            } else if (event.equals(JsonParser.Event.VALUE_NUMBER)) {
                jsonValue = jsonParser.getInt();
            }
            jsonMap.put(jsonKey, jsonValue);
        }
        bean.setName((String) jsonMap.get("name"));
        bean.setContact((String) jsonMap.get("contact"));
        bean.setStatus((String) jsonMap.get("status"));
        bean.setIndex((Integer) jsonMap.get("index"));
        bean.setCity((String) jsonMap.get("city"));
        bean.setRole((String) jsonMap.get("role"));
        bean.setPostalCode((Integer) jsonMap.get("postalCode"));
        bean.setTraditional((Boolean) jsonMap.get("traditional"));
        bean.setAddress((String) jsonMap.get("address"));
        return "parse_json_flow";
    }

}
