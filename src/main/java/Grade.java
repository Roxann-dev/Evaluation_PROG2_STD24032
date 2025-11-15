import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Grade {
    private Student student;
    private Exam exam;
    private List<GradeChange> history = new ArrayList<GradeChange>();

    public Grade(Student jean, Exam examFinal) {
        this.student = student;
        this.exam = exam;
        this.history = history;
    }

    public void addChange(double value, Instant timestamp, String reason){
        history.add(new GradeChange(value, timestamp, reason));
    }

    public List<GradeChange> getHistory(){
        return new ArrayList<>(history);
    }
}
