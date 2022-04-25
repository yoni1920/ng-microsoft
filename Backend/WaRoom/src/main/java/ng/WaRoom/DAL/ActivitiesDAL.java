package ng.WaRoom.DAL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import ng.WaRoom.Utils.Json;
import ng.WaRoom.model.Activity;
import org.springframework.asm.TypeReference;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ActivitiesDAL {

    static ObjectMapper mapper = new ObjectMapper();
    //final static String activitiesPath = "\"C:\\\\Users\\\\danro\\\\Documents\\\\projects\\\\hakaton2022\\\\ng-microsoft\\\\Backend\\\\WaRoom\\\\src\\\\main\\\\java\\\\ng\\\\WaRoom\\\\Utils\\\\Json.java\""
    public static List<Activity> getActivities(){
//        return StreamSupport.stream(Json.readJsonFile(activitiesPath).spliterator(),false)
//                .map(json -> mapper.readValue(json,Activity.class))
//                .collect(Collectors.toCollection(List<Activity>));
        return null;
    }

    public static List<Activity> getActivityById(){
        return null;
    }
}
