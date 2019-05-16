package co.nz.wone.jsonutils;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import io.restassured.response.ResponseBody;

@NoArgsConstructor
public class JsonMapper {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Converts json object to string.
     * @param obj the represent json
     * @param <T> of type
     * @return the string equivalent of json object
     */
    public <T> String jsonObjectToString(T obj) {
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    /**
     * Reads a json file and converts it to json object.
     * @param jsonFile file object
     * @param clazz model class
     * @param <T> type
     * @return the json object
     */
    public <T> T fileToJsonObject(File jsonFile, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(jsonFile, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     * Reads a string and maps it to a class to convert it to json object.
     * @param jsonString file object
     * @param clazz model class
     * @param <T> type
     * @return the json object
     */
    public <T> T stringToJsonObject(String jsonString, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     * Converts json response body into json object.
     * @param jsonResponseBody the response from rest service
     * @param clazz the class to map response to
     * @param <T> the generic type
     * @return the json object
     */
    public <T> T responseToJsonObject(ResponseBody jsonResponseBody, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(jsonResponseBody.asInputStream(),clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

}
