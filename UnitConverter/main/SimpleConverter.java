import java.util.Scanner;

public class SimpleConverter {
    public static void main(String[] args) {
        int x = 5;
        Scanner input = new Scanner(System.in);

        while (x != 4) {
            System.out.println(
                    "Please type the number desired:  \n1. Cups to Teaspoons \n2. Miles to Kilometers \n3. US Gallons to Imperial Gallons \n4. Quit\n");
            int i = input.nextInt();
            System.out.println("");

            if (i == 4) {
                System.out.println("Goodbye!");
                x = 4;
            } else if (i == 1) {
                x = 1;
                System.out.println("Please enter the number of cups:\n");
                int cups = input.nextInt();
                System.out.println("");
                int c2tsp = cups * 48;
                System.out.println(cups + " cup(s) in teaspoons is " + c2tsp + " tsps\n");
            } else if (i == 2) {
                x = 2;
                System.out.println("Please enter the number of miles:\n");
                int miles = input.nextInt();
                System.out.println("");
                double m2km = miles * 1.609344;
                System.out.println(miles + " mile(s) in kilometers is " + m2km + " km\n");
            } else if (i == 3) {
                x = 3;
                System.out.println("Please enter the number of gallons:\n");
                int gallons = input.nextInt();
                System.out.println("");
                double ug2ig = gallons * 0.83267382;
                System.out.println(gallons + " US gallon(s) in Imperial gallons is " + ug2ig + " Imperial gal\n");
            } else {
                System.out.println("Please enter a valid number, or press 4 to escape.\n");
            }

        }

        input.close();
    }
}
