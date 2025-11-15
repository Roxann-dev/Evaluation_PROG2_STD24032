import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GradeServiceTest {
    private static Student Jean;
    private static Course prog2;
    private static Exam controle1, examFinal;
    private static Instant t1, t2, t3;

    @BeforeAll
    static void setUpAll() {
        t1 = Instant.parse("2025-11-05T08:00:00Z"); // 05 nov
        t2 = Instant.parse("2025-11-11T12:00:00Z"); // 11 nov
        t3 = Instant.parse("2025-11-13T15:00:00Z"); // 13 nov

        Jean = new Student(1, "Rakoto", "Jean", LocalDate.of(2004, 1, 1),
                "jean@gmail.com", "0321177700", "K1", null);

        Teacher profAndry = new Teacher(1, "Rabe", "Andry", LocalDate.of(1980, 1, 1),
                "andry@gmail.com", "0348866644", "back-end");

        prog2 = new Course(1, "PROG2", 8, profAndry);

        controle1 = new Exam(1, "Contrôle 1", prog2, t1, 2.0);
        examFinal = new Exam(2, "Examen Final", prog2, t1, 3.0);
    }

    @Test
    @DisplayName("Test de la méthode getExamGrade avec une historique")
    void testGetExamGrade() {
        Grade g = new Grade(Jean, examFinal);
        g.addChange(15.0, t1, "première saisie");
        g.addChange(17.0, t3, "correction");
        GradeService.addGrade(g);

        assertEquals(15.0, GradeService.getExamGrade(examFinal, Jean, t2));
        assertEquals(17.0, GradeService.getExamGrade(examFinal, Jean, Instant.parse("2025-11-20T15:00:00Z")));
    }

    @Test
    @DisplayName("Test de getCourseGrade")
    void testGetCourseGrade() {
        Grade g1 = new Grade(Jean, controle1);
        g1.addChange(10.0, t1, "Controle 1");
        GradeService.addGrade(g1);

        Grade g2 = new Grade(Jean, examFinal);
        g2.addChange(15.0, t1, "première saisie");
        g2.addChange(17.0, t3, "correction");
        GradeService.addGrade(g2);

        assertEquals(13.0, GradeService.getCourseGrade(prog2, Jean, t2));
        assertEquals(14.2, GradeService.getCourseGrade(prog2, Jean, Instant.parse("2025-11-20T15:00:00Z")));
    }
}