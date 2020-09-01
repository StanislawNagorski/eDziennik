package org.edziennik.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @OneToMany
    private Set<Student> recivingStudents;
    private int issuerTeacherId;

    public boolean addStudent(Student student){
        return recivingStudents.add(student);
    }

}

//- uwagi
//        - tresc uwagi
//        - kto dostał (jedna uwage może dostac wiele osob)
//        - kto wystawił
