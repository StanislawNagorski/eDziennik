package org.edziennik.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (length = 2000)
    private String description;
    @ManyToMany(mappedBy = "notes")
    private Set<Student> receivingStudents = new HashSet<>();
    @ManyToOne
    private Teacher teacher;

    public boolean addStudent(Student student){
        return receivingStudents.add(student);
    }

    public Note() {
    }

    public Note(String description, Set<Student> receivingStudents, Teacher teacher) {
        this.description = description;
        this.receivingStudents = receivingStudents;
        this.teacher = teacher;
    }
}

//- uwagi
//        - tresc uwagi
//        - kto dostał (jedna uwage może dostac wiele osob)
//        - kto wystawił
