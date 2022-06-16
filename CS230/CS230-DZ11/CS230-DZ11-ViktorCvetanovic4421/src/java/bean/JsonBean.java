/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.StringReader;
import java.io.StringWriter;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

/**
 *
 * @author BiG
 */
@Named
@RequestScoped
public class JsonBean {

    @Inject
    private BeanCDI bean;
    private String jsonString;

    public JsonBean(BeanCDI bean) {
        this.bean = bean;
    }

    public void setBean(BeanCDI bean) {
        this.bean = bean;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public String generateJson() {
        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
        JsonObject address = addressBuilder.add("address", bean.getAddress()).
                add("city", bean.getCity()).
                add("postalCode", bean.getPostalCode()).build();

        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonObject jsonObject = builder.
                add("name", bean.getName()).
                add("status", bean.getStatus()).
                add("index", bean.getIndex()).
                add("traditional", bean.isTraditional()).
                add("contact", bean.getContact()).
                add("role", bean.getRole()).
                add("address", address).
                build();

        StringWriter stringWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(jsonObject);
        }
        setJsonString(stringWriter.toString());

        return "generate_json";
    }

    public String parseJson() {
        JsonObject jsonObject;

        try (JsonReader jsonReader = Json.createReader(new StringReader(jsonString))) {
            jsonObject = jsonReader.readObject();
        }

        bean.setName(jsonObject.getString("name"));
        bean.setContact(jsonObject.getString("contact"));
        bean.setStatus(jsonObject.getString("status"));
        bean.setIndex(jsonObject.getInt("index"));
        bean.setCity(jsonObject.getJsonObject("address").getString("city"));
        bean.setRole(jsonObject.getString("role"));
        bean.setPostalCode(jsonObject.getJsonObject("address").getInt("postalCode"));
        bean.setTraditional(jsonObject.getBoolean("traditional"));
        bean.setAddress(jsonObject.getJsonObject("address").getString("address"));
        return "parse_json";

    }
}
