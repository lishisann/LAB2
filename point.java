package lab2;

// Класс Точка (Point)
class Point {
    private double x;
    private double y;

    // Конструктор, требует обязательно координаты X и Y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Сеттеры
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
