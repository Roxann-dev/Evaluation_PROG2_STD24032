import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GradeChange {
    private double value;
    private Instant timeStamp;
    private String reason;
}
