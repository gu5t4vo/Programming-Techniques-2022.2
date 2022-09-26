package list4.Q06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Type the material mass: ");
        Material material = new Material(read.nextInt(), new HalfLife(50, TimeMeasures.SECONDS));

        System.out.println("The material mass will be 0.5g in " + material.timeToHalfLife(0.5f));
    }
}
