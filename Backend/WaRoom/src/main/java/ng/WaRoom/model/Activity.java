package ng.WaRoom.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Data
public class Activity {
    private Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String operationalImpact;
    private String customerImpact;
    private System system;
    private Status status;
    private List<Stage> stagesPerActivity;
}
