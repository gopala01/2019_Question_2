package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_PATIENTS = 5;
        Patient[] pArray = new Patient[MAX_PATIENTS];
        inputSurnames(pArray, MAX_PATIENTS);

        int choice = inputInt("What is your choice\n1. Exit\n2. Input further details\n3. Print details");
        choice = checkChoice(choice);

        while (choice != 1)
        {
            if (choice == 2)
            {
                String name = inputString("What is the patient?");
                choice2(pArray, name);
            }
        }

    }

    public static void choice2(Patient[] pArray, String name)
    {
        for (int i = 0; i < pArray.length; i++) {
            if (name.equals(pArray[i].name))
            {
                pArray[i] = hasDiabetes(pArray[i]);
            }
        }
        print("This person doesn't exist");
    }

    public static Patient hasDiabetes(Patient p)
    {
        String choice = inputString("Do you have diabetes? (Y/N)");
        while (!choice.equals("Y") && !choice.equals("N"))
        {
            choice = inputString("Choose from the two choices");
        }
        if (choice.equals("Y"))
        {
            p.hasDiabetes = true;
        }
        else
        {
            p.hasDiabetes = false;
        }
        return p;
    }
    public static int checkChoice(int choice)
    {
        while (choice != 1 && choice != 2 && choice != 3)
        {
            choice = inputInt("Choose one of the three");
        }
        return choice;
    }

    public static void inputSurnames(Patient[] pArray, int max)
    {
        String sName = inputString("What is the surname?");

        int i = 0;
        while (i < max && !sName.equals("XXX"))
        {
           pArray[i] = inputPatient(sName);
            i++;
            sName = inputString("What is the surname?");
        }
        print("Thank you;");

    }

    public static Patient inputPatient(String sName)
    {
        Patient p = new Patient();
        p.name = sName;
        p.hasDiabetes = false;
        p.improvementRegime = null;
        return p;
    }

    public static void print(String m)
    {
        System.out.println(m);
    }

    public static String inputString(String m)
    {
        String answer;
        Scanner scanner = new Scanner(System.in);
        print(m);
        answer = scanner.nextLine();

        return answer;
    }

    public static int inputInt(String m)
    {
        int answer;
        Scanner scanner = new Scanner(System.in);
        print(m);
        answer = scanner.nextInt();

        return answer;
    }

    public static String getName(Patient p)
    {
        return p.name;
    }

    public static String getImprovementRegime(Patient p)
    {
        return p.improvementRegime;
    }
}

class Patient{
    String name;
    boolean hasDiabetes;
    String improvementRegime;
}