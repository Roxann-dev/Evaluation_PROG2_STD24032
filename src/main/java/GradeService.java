import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class GradeService {

    private static final List<Grade> grades = new ArrayList<Grade>();

    public static void addGrade(Grade grade) {
        grades.add(grade);
    }

    public static double getExamGrade(Exam exam, Student student, Instant t) {
        Grade grade = grades.stream()
                .filter(g -> g.getExam().equals(exam) && g.getStudent().equals(student))
                .findFirst()
                .orElse(null);

        if (grade == null) {
            return 0;
        }

        return grade.getHistory().stream()
                .filter(change -> change.getTimeStamp().isBefore(t))
                .sorted((a,b) -> b.getTimeStamp().compareTo(a.getTimeStamp()))
                .mapToDouble(GradeChange::getValue)
                .findFirst()
                .orElse(0);
    }

    public static double getCourseGrade(Course course, Student student, Instant t) {
        var examWithGrade = grades.stream()
                .filter(g -> g.getStudent().equals(student))
                .map(Grade::getExam)
                .filter(exam -> exam.getCourse().equals(course))
                .filter(exam -> getExamGrade(exam, student, t) > 0)
                .toList();

        if (examWithGrade.isEmpty()) {
            return 0;
        }

        double sommePonderee = 0.0;
        double sommeCoeffs = 0.0;

        for (Exam exam : examWithGrade) {
            double note = getExamGrade(exam, student, t);
            double coef = exam.getCoefficient();

            sommePonderee += note * coef;
            sommeCoeffs += coef;
        }
        return sommePonderee / sommeCoeffs;
    }
}
