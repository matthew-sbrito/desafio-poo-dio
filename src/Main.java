import br.com.dio.desafio.domain.Course;
import br.com.dio.desafio.domain.Mentoring;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Course firstCourse = new Course();
        firstCourse.setTitle("Java course");
        firstCourse.setDescription("Java course description");
        firstCourse.setWorkload(8);

        Course secondCourse = new Course();
        secondCourse.setTitle("JS course");
        secondCourse.setDescription("JS course description");
        secondCourse.setWorkload(8);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java mentoring");
        mentoring.setDescription("Java mentoring description");
        mentoring.setDate(LocalDate.now());

        System.out.println(firstCourse);
        System.out.println(secondCourse);
    }
}
