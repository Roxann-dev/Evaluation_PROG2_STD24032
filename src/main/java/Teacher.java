import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Teacher extends Person {
    private String specialty;

    public Teacher(int id, String name, String first_name, LocalDate birth_date, String email, String phone) {
        super(id, name, first_name, birth_date, email, phone);
    }
}
