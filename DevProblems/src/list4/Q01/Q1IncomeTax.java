package list4.Q01;

import java.util.Scanner;

public class Q1IncomeTax {
    public static float incomeTax(float salary){

        float minimumWage   = 1212f;
        float bruteTax;
        float additionalTax = 1.04f;

        if (salary/minimumWage >= 12){
            bruteTax = 0.2f;
        }
        else if(salary/minimumWage > 5){
            bruteTax = 0.08f;
        }
        else {
            bruteTax = 0;
        }

        return salary * bruteTax * additionalTax;
    }

    public static float incomeTaxRestitution(int dependents){
        return (float)dependents * 0.02f;
    }

    public static void main(String[] args) {
        Scanner read            = new Scanner(System.in);
        float   salary;
        int     dependents;

        System.out.println("==========================================================================");
        System.out.println("HI, IT'S THE GOVERNMENT LION, TIME TO PAY YOUR TAXES, LET'S GO," +
                "\nGIVE ME YOUR MONEY!");
        System.out.println("==========================================================================");

        System.out.print("YOUR SALARY: ");
        salary = read.nextFloat();


        System.out.print("DO YOU HAVE ANY DEPENDENT? (TYPE 0 IF YOU DON'T HAVE ANY): ");
        dependents = read.nextInt();

        if (incomeTax(salary) != 0) {
            System.out.printf("SO, BASED ON YOU DATA, YOU HAVE TO GIVE R$%.2f TO THE IRS LION.\n", incomeTax(salary));

            if (dependents > 0){
                System.out.printf("BUT HEY, GOOD NEWS, YOU HAVE %d DEPENDENTS,YOU WILL BE REFUNDED AT %.0f%%\n",
                        dependents, (0.04 * dependents) * 100);
                System.out.printf("YOUR RESTITUTION: R$%.2f", incomeTax(salary) * incomeTaxRestitution(dependents));
            }

            else {
                System.out.println("NO DEPENDENTS, NO RESTITUTION");
            }
        }
        else {
            System.out.println("LUCKY DAY, YOU SALARY ISN'T HIGH ENOUGH FOR THE GOVERNMENT LION\n" +
                    "YOU ARE DISMISSED, HAVE A NICE DAY");
        }



    }
}
