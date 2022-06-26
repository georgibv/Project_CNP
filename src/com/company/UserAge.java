package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserAge {
    /**
     * Metoda calculeaza varsta utilizatorului prin a scadea initial anul curent - anul nasterii
     * iar apoi verifica daca luna curenta este mai mica in comparatie cu luna primita din data nasterii
     * caz in care, scade cu 1 anul obtinut din calcul initial al anului curent si cel al nasterii (deoarece
     * utilizatul nu si-a sarbatorit inca ziua de nastere in anul curent) altfel daca lunile sunt egale,
     * trebuie sa aplicam aceasi logica si pentru a verifica daca utilizatorul si-a sarbatorit deja ziua de nastere
     * sau nu, in luna respectiva.
     * @param birthDate - un string de forma dd-MM-yyyy
     * @return - un integer care reprezinta varsta
     */
    public int getUserAge(String birthDate) {
        ArrayList<Integer> formattedBirthDate = convertDateToInt(birthDate);
        ArrayList<Integer> formattedCurrentDate = convertDateToInt(getCurrentDate());

        int age = 0;

        age = formattedCurrentDate.get(2) - formattedBirthDate.get(2);

        if (formattedCurrentDate.get(1) < formattedBirthDate.get(1)) {
            age--;
        } else if (formattedCurrentDate.get(1) == formattedBirthDate.get(1)) {
            if (formattedCurrentDate.get(0) < formattedBirthDate.get(0)) {
                age--;
            }
        }
        return age;
    }
    /**
     * Metoda proceseaza un format de data (dd-MM-yyyy ex: 01-11-2001, 31-10-1976) si il converteste din string intr-o lista de numere intregi
     * @param date - o data de forma dd-MM-yyyy
     * @return o lista de numere intregi unde prima pozitie este ziua, a doua este luna iar a treia este anul
     */


    public ArrayList<Integer> convertDateToInt(String date) {
        ArrayList<Integer> splitDate = new ArrayList<>();
        String[] formattedDate = date.split("-");
        int day = Integer.parseInt(formattedDate[0]);
        int month = Integer.parseInt(formattedDate[1]);
        int year = Integer.parseInt(formattedDate[2]);

        splitDate.add(day);
        splitDate.add(month);
        splitDate.add(year);

        return splitDate;
    }

    /**
     * Metoda o sa returneze un string in forma dd-MM-yyyy folosid data curenta de la momentul apelari
     * @return - un string cu data de la momentul apelari
     */
    public String getCurrentDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = date.format(formatter);
        return currentDate;
    }
}
