package org.edziennik.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int score; //TODO dodaj ograniczenie zakresu od 1 do 6 z połówkami.
    int teacher_id;
    int student_id;
    Subject subject;

    public Grade(int score, int teacher_id, int student_id, Subject subject) {
        this.score = score;
        this.teacher_id = teacher_id;
        this.student_id = student_id;
        this.subject = subject;
    }

    public Grade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}


//- oceny
//        - ocena xD
//        - kto wystawił
//        - kto dostał
//        - przedmiot
