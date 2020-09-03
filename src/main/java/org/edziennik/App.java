package org.edziennik;

import org.edziennik.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        //DataFiller.fillUpDataBase();

        HibernateFactory.getSessionFactory().close();

    }
}
