package ng.WaRoom.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/systems")
public class SystemControllers {

    @GetMapping
    public @ResponseBody int getAllSystems(){
        return 1;
    }

    @GetMapping(value = "/{systemId}")
    public @ResponseBody int getSystem(@PathVariable("systemId") int systemId){
        return 1;
    }

    @PostMapping
    public void newSystem(@RequestBody JsonNode newSystem){

    }
}
