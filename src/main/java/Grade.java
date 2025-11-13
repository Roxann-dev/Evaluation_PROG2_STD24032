import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Grade {
    private Student student;
    private Exam exam;
    private List<GradeChange> history = new ArrayList<GradeChange>();

    public void addChange(double value, Instant timestamp, String reason){
        history.add(new GradeChange(value, timestamp, reason));
    }

    public List<GradeChange> getHistory(){
        return new ArrayList<>(history);
    }
}
