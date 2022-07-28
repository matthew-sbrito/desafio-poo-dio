import br.com.dio.desafio.domain.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Course firstCourse = new Course();
        firstCourse.setTitle("Java course");
        firstCourse.setDescription("Description of Java course");
        firstCourse.setWorkload(8);

        Course secondCourse = new Course();
        secondCourse.setTitle("JS course");
        secondCourse.setDescription("Description JS course");
        secondCourse.setWorkload(4);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java mentoring");
        mentoring.setDescription("Description of Java mentoring ");
        mentoring.setDate(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Bootcamp Java developer");
        bootcamp.setDescription("Description of Bootcamp Java Developer");
        bootcamp.getContents().add(firstCourse);
        bootcamp.getContents().add(secondCourse);
        bootcamp.getContents().add(mentoring);

        Dev devMatheus = new Dev();
        devMatheus.setName("Matheus");
        devMatheus.registerBootcamp(bootcamp);
        System.out.println("Subscribed content " + devMatheus.getSubscribedContentString());
        devMatheus.toProgress();
        devMatheus.toProgress();
        System.out.println("-");
        System.out.println("Subscribed content " + devMatheus.getSubscribedContentString());
        System.out.println("Completed content " + devMatheus.getCompletedContentString());
        System.out.println("XP: " + devMatheus.calculateTotalXp());

        System.out.println("------------");

        Dev devCamila  = new Dev();
        devCamila.setName("Camila");
        devCamila.registerBootcamp(bootcamp);
        System.out.println("Subscribed content " + devCamila.getSubscribedContentString());
        devCamila.toProgress();
        devCamila.toProgress();
        devCamila.toProgress();
        System.out.println("-");
        System.out.println("Subscribed content " + devCamila.getSubscribedContentString());
        System.out.println("Completed content " + devCamila.getCompletedContentString());
        System.out.println("XP: " + devCamila.calculateTotalXp());

    }
}
