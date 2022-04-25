package ng.WaRoom.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Status {
    private Integer id;
    private String status;
}
