package WorkingWithAbstractionLab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int xBottomLeft = coordinates[0];
        int yBottomLeft = coordinates[1];
        Point bottomLeft = new Point(xBottomLeft, yBottomLeft);

        int xTopRight = coordinates[2];
        int yTopRight = coordinates[3];
        Point topRight = new Point(xTopRight, yTopRight);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] coordinatesOfPoints = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point(coordinatesOfPoints[0], coordinatesOfPoints[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
