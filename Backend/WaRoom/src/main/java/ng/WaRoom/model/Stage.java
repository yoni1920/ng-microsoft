package ng.WaRoom.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class Stage {
    private Integer id;
    private LocalDateTime estimatedTime;
    private LocalDateTime actualTime;
    private String description;
    private String impact;
    private Status status;
}
