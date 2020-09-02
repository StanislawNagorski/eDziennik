package org.edziennik.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private int age;
    public enum Contract {MANDATE, B2B}
    private Contract contract;
    @ManyToMany
    private Set<Subject> subjects;


    public boolean addSubject(Subject subject){
       return subjects.add(subject);
    }

    public boolean removeSubjectByID(int subjectID){
        Optional<Subject> optionalSubject = subjects.stream()
                .filter(subject -> subject.id == subjectID)
                .findFirst();

        return optionalSubject.isPresent() && subjects.remove(optionalSubject.get());
    }
    public Teacher(){}

    public Teacher (String name, String surname, String email, int age, Contract contract, Set<Subject> subjects){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.contract = contract;
        this.subjects = subjects;
    }


}

// - infrmacje o nauczycielach
//         - imie
//         - nazwisko
//         - email
//         - wiek
//         .       -rodzaj umowy ( zlecenie / B2B )
//         .      - Przedmioty których uczy