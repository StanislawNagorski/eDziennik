package org.edziennik.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private int age;
    private enum Contract {MANDATE, B2B}
    private Contract contract;
    @ManyToMany
    private Set<Subject> subjects = new HashSet<>();


    public boolean addSubject(Subject subject){
       return subjects.add(subject);
    }

    public boolean removeSubjectByID(int subjectID){
        Optional<Subject> optionalSubject = subjects.stream()
                .filter(subject -> subject.id == subjectID)
                .findFirst();

        return optionalSubject.isPresent() && subjects.remove(optionalSubject.get());
    }
}

// - infrmacje o nauczycielach
//         - imie
//         - nazwisko
//         - email
//         - wiek
//         .       -rodzaj umowy ( zlecenie / B2B )
//         .      - Przedmioty których uczy