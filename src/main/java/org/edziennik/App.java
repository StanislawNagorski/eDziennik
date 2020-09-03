package org.edziennik;

import org.edziennik.entities.*;

import java.util.ArrayList;
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

        List<Student> studentList = List.of(
                new Student("Son", "Gohan", "whoIsGreatSaiyamana@nobodyKnows.jp"),
                new Student("Son","Goten", "giggels@gmail.com"),
                new Student("Trunks", "Vegeta", "paniczTrunks@capsule.corp")
        );

        Note noteFromPicollo = new Note("They didn`t DOOOOGE!!", Set.copyOf(studentList), teacherList.get(2));
        Note noteFromVegeta = new Note("such a disapointment...", Set.of(studentList.get(2)), teacherList.get(1));

        List<Grade> grades = new ArrayList<>();
        studentList.forEach(student -> grades.add(new Grade(1, teacherList.get(2), student, sl.get(5) )));
        studentList.forEach(student -> grades.add(new Grade(3, teacherList.get(1), student, sl.get(2) )));
        grades.add(new Grade(5,teacherList.get(0),studentList.get(2),sl.get(4)));


        SchoolDAO<Grade> gradeSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Note> noteSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Student> studentSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Subject> subjectSchoolDAO = new SchoolDAO<>();
        SchoolDAO<Teacher> teacherSchoolDAO = new SchoolDAO<>();

        sl.forEach(subjectSchoolDAO::save);
        teacherList.forEach(teacherSchoolDAO::save);
        studentList.forEach(studentSchoolDAO::save);
        noteSchoolDAO.save(noteFromPicollo);
        noteSchoolDAO.save(noteFromVegeta);
        grades.forEach(gradeSchoolDAO::save);

        HibernateFactory.getSessionFactory().close();

    }
}
