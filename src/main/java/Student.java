import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student extends Person {
    private String group;
    private Tutor tutor;

    public Student(int id, String name, String first_name, LocalDate birth_date, String email, String phone, String group, Tutor tutor) {
        super(id, name, first_name, birth_date, email, phone);
        this.group = group;
        this.tutor = tutor;
    }
}
