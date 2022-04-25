package ng.WaRoom.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/activities")
public class ActivityController {

    @GetMapping
    public @ResponseBody int getAllActivities(){
        return 1;
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
