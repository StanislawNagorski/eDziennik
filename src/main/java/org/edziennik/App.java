package org.edziennik;

import org.edziennik.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

       // DataFiller.fillUpDataBase();
        canAddNoteWithCharsMoreThen250();
        HibernateFactory.getSessionFactory().close();

    }

    private static void canAddNoteWithCharsMoreThen250(){
        SchoolDAO<Teacher> tDAO = new SchoolDAO<>();
        Teacher teacher = tDAO.getById(Teacher.class, 1);
        SchoolDAO<Student> sDAO = new SchoolDAO<>();
        Student student = sDAO.getById(Student.class, 1);
        SchoolDAO<Note> nDAO = new SchoolDAO<>();
        String longString = "Broly to jasnoskóry Saiyanin o czarnych oczach i długich czarnych włosach sięgających do połowy pleców ma też grzywkę. Kiedy był dzieckiem, miał na sobie czarną tunikę z brązowym sznurkiem szare spodnie i brązowe buty. Jako dorosły, Broly jest bardzo wysoki i szczupły, ale dobrze zbudowany. Nosi na czole specjalne urządzenie z niebieskim klejnotem, którego używa jego ojciec, Paragus, aby powstrzymać go przed przekształceniem w Legendarnego Super Saiyanina. Oprócz tego urządzenia, Broly nosi złoty naszyjnik, buty, opaski na rękę i pas, które również posiadają niebieski klejnot. Reszta jego stroju składa się z białych spodni i czerwonej płachty podobnej do tej, którą nosi Kibito.\n" +
                "Jako Super Saiyanin, nosząc urządzenie do kontroli, włosy Broly'ego przybierają kolor neonowo-niebieski z purpurowym odcieniem i wydają się być całkowicie purpurowe w ciemnym otoczeniu. Jako Super Saiyanin bez urządzenia kontroli jego włosy przyjmują charakterystyczny złoty kolor tej formy.";
        Note longNote = new Note(longString, Set.of(student),teacher);
        nDAO.save(longNote);
    }


}
