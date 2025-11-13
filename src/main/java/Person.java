import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Person {
    private int id;
    private String name;
    private String first_name;
    private LocalDate birth_date;
    private String email;
    private String phone;
}
