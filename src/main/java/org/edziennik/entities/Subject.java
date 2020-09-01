package org.edziennik.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class  Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String className;
    @ManyToMany(mappedBy = "subjects")
    Set<Teacher> teachers;
}

//- przedmioty
//        - nazwa przedmiotu (matematyka, hisotria, itp)
