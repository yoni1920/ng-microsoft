package ng.WaRoom.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import ng.WaRoom.BL.ActivitiesBL;
import ng.WaRoom.model.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/activities")
public class ActivityController {

    @GetMapping
    public @ResponseBody List<Activity> getAllActivities(){
        return ActivitiesBL.allActivities();
    }

    @GetMapping(value = "/{systemId}")
    public @ResponseBody int getAllActivitiesBySystem(){
        return 1;
    }

    @PostMapping(value = "/{systemId}/{activityId}")
    public void updateActivity(@RequestBody JsonNode newActivity){

    }

    @PostMapping
    public void newActivity(@RequestBody JsonNode newActivity){

    }
}
