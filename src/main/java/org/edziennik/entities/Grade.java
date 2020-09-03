package org.edziennik.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  int gradeValue; //TODO dodaj ograniczenie zakresu od 1 do 6 z połówkami.
    @ManyToOne //TODO dodaj ograniczenie, tylko nauczyciel uczący moze wystawic z tego ocene
    private  Teacher teacher;
    @ManyToOne
    private  Student student;
    @ManyToOne
    private  Subject subject;

    public Grade(int gradeValue, Teacher teacher,Student student, Subject subject){
        this.gradeValue = gradeValue;
        this.teacher = teacher;
        this.student = student;
        this.subject = subject;
    }

    public Grade(){}
}


//- oceny
//        - ocena xD
//        - kto wystawił
//        - kto dostał
//        - przedmiot
