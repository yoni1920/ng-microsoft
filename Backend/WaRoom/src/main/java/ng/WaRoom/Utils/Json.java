package ng.WaRoom.Utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Json {

    public static ArrayNode readJsonFile(String filePath){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath))
        {
            return (ArrayNode) jsonParser.parse(reader);

        } catch (Exception e) {
            System.out.println("fuck");
        }
        return null;
    }
}
