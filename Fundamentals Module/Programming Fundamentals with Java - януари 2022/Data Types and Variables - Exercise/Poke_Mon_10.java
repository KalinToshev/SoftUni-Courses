package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Poke_Mon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int pokePower = Integer.parseInt(scanner.nextLine()); //N
        int distance = Integer.parseInt(scanner.nextLine()); //M
        int exhaustionFactor = Integer.parseInt(scanner.nextLine()); //Y
        int pokedTargets = 0;
        int pokePowerOriginalValue = pokePower;
        //Calculate
        while (true) {
            if (pokePower < distance) {
                break;
            }
            pokePower -= distance;
            pokedTargets++;
            if (pokePower == (pokePowerOriginalValue * 0.5) && exhaustionFactor != 0) {
                pokePower /= exhaustionFactor;
            }
        }
        //Output
        System.out.println(pokePower);
        System.out.println(pokedTargets);
    }
}
