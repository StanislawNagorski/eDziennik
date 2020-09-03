package org.edziennik;

import org.edziennik.entities.*;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        List<Subject> sl = List.of(
                new Subject("Lewitacja"),
                new Subject("EnergyBalls"),
                new Subject("Karate Basics"),
                new Subject("Lewitacja"),
                new Subject("Teleportacja"),
                new Subject("DOOOOOOGE!"));

        List<Teacher> teacherList = List.of(
                new Teacher("Son", "Goku", "songoku111@aol.com", 32, Teacher.Contract.MANDATE, Set.of(sl.get(1), sl.get(4))),
                new Teacher("Vegeta", "Prince", "vegetaIsDeBest@vegeta.vegeta", 35, Teacher.Contract.B2B, Set.of(sl.get(2), sl.get(3))),
                new Teacher("Picollo", "Szatan", "serduszko@buziaczek.pl", 44, Teacher.Contract.B2B, Set.of(sl.get(5))));

        SchoolDAO<Grade> gradeSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Note> noteSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Student> studentSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Subject> subjectSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Teacher> teacherSchoolDAO = new SchoolDAO<>();

        sl.forEach(subjectSchoolDAO::save);
        teacherList.forEach(teacherSchoolDAO::save);

        HibernateFactory.getSessionFactory().close();

    }
}
