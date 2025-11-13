import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tutor extends Person {
    private String link_description;

    public Tutor(int id, String name, String first_name, LocalDate birth_date, String email, String phone, String link_description) {
        super(id, name, first_name, birth_date, email, phone);
        this.link_description = link_description;
    }
}
