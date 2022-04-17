import java.util.Scanner;
 
public class Building_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countFloors = Integer.parseInt(scanner.nextLine());
        int countRooms = Integer.parseInt(scanner.nextLine());
 
        //обхождаме всички етажи от последния към първия
        for (int floor = countFloors; floor >= 1; floor--) {
            //обхождаме всички номера на стаи -> 0 до бр. стаите - 1
            for (int roomNumber = 0; roomNumber <=  countRooms - 1; roomNumber++) {
                //печатам името на стаята -> зависи от етажа
                //последен етаж -> L{floor}{roomNumber}
                //четен етаж -> О{floor}{roomNumber}
                //нечетен етаж -> A{floor}{roomNumber}
                if (floor == countFloors) {
                    System.out.print("L" + floor + roomNumber + " ");
                } else if (floor % 2 == 0) {
                    System.out.print("O" + floor + roomNumber + " ");
                } else {
                    System.out.print("A" + floor + roomNumber + " ");
                }
            }
            System.out.println();
 
        }
    }
}