package com.company;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your CNP: ");
        String cnp = sc.nextLine();

        PersonCNP person = new PersonCNP();
        person.setCnp(cnp);

        System.out.println("Gender is:");
        System.out.println(person.getGender());

        System.out.println("Birth date is:");
        System.out.println(person.getBirthDate());

        System.out.println("Age is: ");
        System.out.println(person.getAge());

        System.out.println("Region:");
        System.out.println(person.getRegion());

    }
}

