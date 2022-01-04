package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_PATIENTS = 300;
        String[] namesArray = new String[MAX_PATIENTS];
        inputNamesArray1(namesArray, MAX_PATIENTS);

        int arrayLength = 0;
        arrayLength = createArrayLength(arrayLength, namesArray);


        Patient[] patientArray = new Patient[arrayLength];

        inputNamesArray2(patientArray, namesArray);

        choicesForUser(patientArray);

    }

    public static void choicesForUser(Patient[] patientArray)
    {
        int choice = inputInt("What is your choice\n1. Exit\n2. Input further details\n3. Print details");
        choice = checkChoice(choice);

        while (choice != 1)
        {
            if (choice == 2)
            {
                String name = inputString("Who is the patient?");
                choice2(patientArray, name);
            }
            else if(choice == 3)
            {
                choice3(patientArray);
            }
            choice = inputInt("What is your choice\n1. Exit\n2. Input further details\n3. Print details");
            choice = checkChoice(choice);
        }
        print("Goodbye");
    }
    public static void inputNamesArray2(Patient[] pArray, String[] namesArray)
    {
        for (int i = 0; i < pArray.length; i++) {
            pArray[i] = createPatient();
            pArray[i].name = namesArray[i];
        }
    }

    public static int createArrayLength(int arrayLength, String[] array)
    {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
            {
                arrayLength = arrayLength + 1;
            }
        }

        return arrayLength;
    }
    public static void choice3(Patient[] pArray)
    {
        for (int i = 0; i < pArray.length; i++) {
            print(getName(pArray[i]));
            if (getRegime(pArray[i]) == null)
            {
                print("Details not yet input for this patient");
            }
            else
            {
                if (getHasDiabetes(pArray[i]))
                {
                    print("Has diabetes");
                }
                else
                {
                    print("Doesn't have diabetes");
                }
                print("Follows the regime of " + getRegime(pArray[i]));
            }

        }
    }
    public static void choice2(Patient[] pArray, String name)
    {
        for (int i = 0; i < pArray.length; i++) {
            if (name.equals(pArray[i].name))
            {
                pArray[i] = hasDiabetes(pArray[i]);
                pArray[i] = inputRegime(pArray[i]);
            }
        }
        print("This person doesn't exist");
    }

    public static Patient inputRegime(Patient p)
    {
        int choice = inputInt("What do you follow?\n1. Diet\n2. Exercise\n3. Drugs");
        choice = checkChoice(choice);

        if (choice == 1)
        {
            p.regime = "Diet";
        }
        else if (choice == 2)
        {
            p.regime = "Exercise";
        }
        else
        {
            p.regime = "Drugs";
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
    public static void inputNamesArray1(String[] names, int MAX_PATIENTS)
    {
        int i = 0;
        String name = inputString("What is the surname of active patients?");

        while (!name.equals("XXX") && i < MAX_PATIENTS)
        {
            names[i] = name;
            i++;

            name = inputString("What is the surname of active patients?");
        }
        print("Thank you");
    }

    public static Patient createPatient()
    {
        Patient p = new Patient();
        p.name = null;
        p.hasDiabetes = false;
        p.regime = null;

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

    public static boolean getHasDiabetes(Patient p)
    {
        return p.hasDiabetes;
    }

    public static String getRegime(Patient p)
    {
        return p.regime;
    }
}

class Patient{
    String name;
    boolean hasDiabetes;
    String regime;
}