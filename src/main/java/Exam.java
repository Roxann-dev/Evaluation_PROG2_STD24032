import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant date_time;
    private double coefficient;
}
