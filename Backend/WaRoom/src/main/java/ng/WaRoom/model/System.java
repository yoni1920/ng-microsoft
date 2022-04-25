package ng.WaRoom.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class System {
    private Integer id;
    private String name;
    private String unit;
    private String teamLeader;
    private String leaderPhone;
    private String officePhone;
}
