import java.util.Scanner;
import java.util.Random;

public class FancyConverter {
    public static void main(String[] args) {
        int x = 6;
        Scanner input = new Scanner(System.in);

        while (x != 4) {
            System.out.println(
                    "Please type the number desired:  \n1. Volume Conversion \n2. Distance Conversion \n3. Temperature Conversion \n4. Random! \n5. Quit\n");
            int i = input.nextInt();
            System.out.println("");

            if (i == 5) {
                System.out.println("Goodbye!");
                x = 4;
            } else if (i == 1) {
                volConversions();
            } else if (i == 2) {
                distConversions();
            } else if (i == 3) {
                tempConversions();
            } else if (i == 4) {
                Random randNum = new Random();
                i = randNum.nextInt(3) + 1;

                if (i == 1) {
                    volConversions();
                } else if (i == 2) {
                    distConversions();
                } else if (i == 3) {
                    tempConversions();
                }

            } else {
                System.out.println("Please enter a valid number, or press 4 to escape.\n");
            }
        }

        input.close();

    }

    public static void volConversions() {
        Scanner input = new Scanner(System.in);
        int x = 1;

        while (x != 6) {
            System.out.println(
                    "Please type the number desired:  \n1. Cups to Teaspoons \n2. Teaspoons to Tablespoons \n3. US Gallons to Imperial Gallons \n4. Pints to Quarts \n5. Liters to Gallons \n6. Back to main menu\n");
            int i = input.nextInt();
            System.out.println("");

            if (i == 6) {
                x = 6;
            } else if (i == 1) {
                System.out.println("Please enter the number of cups:\n");
                int cups = input.nextInt();
                System.out.println("");
                int c2tsp = cups * 48;
                System.out.println(cups + " cup(s) in teaspoons is " + c2tsp + " tsps\n");
            } else if (i == 2) {
                System.out.println("Please enter the number of teaspoons:\n");
                int tsps = input.nextInt();
                System.out.println("");
                double tsp2tbl = tsps * 0.33333333;
                System.out.println(tsps + " teaspoon(s) in tablespoons is " + tsp2tbl + " tablespoons\n");
            } else if (i == 3) {
                System.out.println("Please enter the number of gallons:\n");
                int gallons = input.nextInt();
                System.out.println("");
                double ug2ig = gallons * 0.83267382;
                System.out.println(gallons + " US gallon(s) in Imperial gallons is " + ug2ig + " Imperial gal\n");
            } else if (i == 4) {
                System.out.println("Please enter the number of pints:\n");
                int pints = input.nextInt();
                System.out.println("");
                double pt2qt = pints * 0.5;
                System.out.println(pints + " pint(s) in quarts is " + pt2qt + " quarts\n");
            } else if (i == 5) {
                System.out.println("Please enter the number of liters:\n");
                int liters = input.nextInt();
                System.out.println("");
                double lt2gal = liters * 0.26417205;
                System.out.println(liters + " liter(s) in gallons is " + lt2gal + " gal\n");
            } else {
                System.out.println("Please enter a valid number, or press 6 to go to the main menu.\n");
            }
        }

    }

    public static void distConversions() {
        Scanner input = new Scanner(System.in);
        int x = 1;

        while (x != 6) {
            System.out.println(
                    "Please type the number desired:  \n1. Miles to Kilometers \n2. Light Years to Astronomical Units (AU) \n3. Inches to Yards \n4. Yards to Miles \n5. Kilometers to AU \n6. Back to main menu\n");
            int i = input.nextInt();
            System.out.println("");

            if (i == 6) {
                x = 6;
            } else if (i == 1) {
                System.out.println("Please enter the number of miles:\n");
                int miles = input.nextInt();
                System.out.println("");
                double m2km = miles * 1.609344;
                System.out.println(miles + " mile(s) in kilometers is " + m2km + " km\n");
            } else if (i == 2) {
                System.out.println("Please enter the number of light years:\n");
                int ly = input.nextInt();
                System.out.println("");
                double ly2au = ly * 63241.0771;
                System.out.println(ly + " light year(s) in astronomical units is " + ly2au + " AU\n");
            } else if (i == 3) {
                System.out.println("Please enter the number of inches:\n");
                int in = input.nextInt();
                System.out.println("");
                double in2yd = in * 0.02777778;
                System.out.println(in + " inch(es) in yards is " + in2yd + " yards\n");
            } else if (i == 4) {
                System.out.println("Please enter the number of yards:\n");
                int yd = input.nextInt();
                System.out.println("");
                double yd2mile = yd * 0.00056818;
                System.out.println(yd + " yard(s) in miles is " + yd2mile + " miles\n");
            } else if (i == 5) {
                System.out.println("Please enter the number of kilometers:\n");
                int km = input.nextInt();
                System.out.println("");
                double km2au = km * 0.0000000067;
                System.out.println(km + " kilometer(s) in astronomical units is " + km2au + " AU\n");
            } else {
                System.out.println("Please enter a valid number, or press 6 to go to the main menu.\n");
            }
        }

    }

    public static void tempConversions() {
        Scanner input = new Scanner(System.in);
        int x = 1;

        while (x != 5) {
            System.out.println(
                    "Please type the number desired:  \n1. Fahrenheit to Celsius \n2. Celsius to Kelvin \n3. Fahrenheit to Kelvin \n4. Celsius to Fahrenheit \n5. Back to main menu\n");
            int i = input.nextInt();
            System.out.println("");

            if (i == 5) {
                x = 5;
            } else if (i == 1) {
                System.out.println("Please enter the temperature in fahrenheit:\n");
                int fah = input.nextInt();
                System.out.println("");
                double f2c = (fah - 32) * 0.555555556;
                System.out.println(fah + " fahrenheit in celsius is " + f2c + " celsius\n");
            } else if (i == 2) {
                System.out.println("Please enter the temperature in celsius:\n");
                int cel = input.nextInt();
                System.out.println("");
                double c2k = cel + 273.15;
                System.out.println(cel + " celsius in kelvin is " + c2k + " kelvin\n");
            } else if (i == 3) {
                System.out.println("Please enter the temperature in fahrenheit:\n");
                int fah = input.nextInt();
                System.out.println("");
                double f2k = ((fah - 32) / 1.8) + 273.15;
                System.out.println(fah + " fahrenheit in kelvin is " + f2k + " kelvin\n");
            } else if (i == 4) {
                System.out.println("Please enter the temperature in celsius:\n");
                int cel = input.nextInt();
                System.out.println("");
                double c2f = (cel * (9 / 5)) + 32;
                System.out.println(cel + " celsius in fahrenheit is " + c2f + " fahrenheit\n");
            } else {
                System.out.println("Please enter a valid number, or press 5 to go to the main menu.\n");
            }
        }

    }
}
