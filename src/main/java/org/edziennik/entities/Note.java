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
    private Set<Integer> recivingStudents_Id;
    private int issuerTeacherId;
}

//- uwagi
//        - tresc uwagi
//        - kto dostał (jedna uwage może dostac wiele osob)
//        - kto wystawił
