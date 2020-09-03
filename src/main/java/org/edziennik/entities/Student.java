package org.edziennik.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "student")
    private Set<Grade> grades = new HashSet<>();
    @ManyToMany
    private Set<Note> notes = new HashSet<>();

    public boolean addGrade(Grade grade){
        return grades.add(grade);
    }

    public boolean addNote(Note note){
        return notes.add(note);
    }

}

// - informacje o uczniach:
//         - imie
//         - nazwisko
//         - adres email