package WorkingWithAbstractionLab.PointInRectangle;

public class Rectangle {
    //Полета за най-долна лява точка
    //Полета за най-горна дясна точка
    Point bottomLeft;
    Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    //Метод за проверка дали дадена точка е в правоъгълника
    public boolean contains(Point point) {
        boolean containsOnX = point.getX() >= bottomLeft.getX()
                && point.getX() <= topRight.getX();

        boolean containsOnY = point.getY() >= bottomLeft.getY()
                && point.getY() <= topRight.getY();

        return containsOnX && containsOnY;
    }
}
