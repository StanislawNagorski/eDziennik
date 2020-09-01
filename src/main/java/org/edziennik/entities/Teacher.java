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
    private Set<Subject> subjects;

}

// - infrmacje o nauczycielach
//         - imie
//         - nazwisko
//         - email
//         - wiek
//         .       -rodzaj umowy ( zlecenie / B2B )
//         .      - Przedmioty których uczy