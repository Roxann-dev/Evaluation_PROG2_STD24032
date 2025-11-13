import lombok.*;

import java.lang.classfile.Label;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Course {
    private int id;
    private String label;
    private int credits;
    private Teacher teacher;
}
