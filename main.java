package lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ЗАДАНИЕ 1.1 и 4.1
        System.out.println("Создание точек:");
        Point point1 = new Point(3, 5);
        Point point2 = new Point(25, 6);
        Point point3 = new Point(7, 8);
        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);

        //ЗАДАНИЕ 2.1 и 4.2
        System.out.println("\nСоздание линий:");
        Line line1 = new Line(1, 3, 23, 8);
        Line line2 = new Line(5, 10, 25, 10);
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (зависимая): " + line3);

        // Изменяем координаты линии 1 и 2 через ввод
        System.out.println("\nВведите новые координаты для Линии 1:");
        updatePoint(scanner, line1.getStart(), "Начало Линии 1");
        updatePoint(scanner, line1.getEnd(), "Конец Линии 1");

        System.out.println("\nВведите новые координаты для Линии 2:");
        updatePoint(scanner, line2.getStart(), "Начало Линии 2");
        updatePoint(scanner, line2.getEnd(), "Конец Линии 2");

        System.out.println("\nПосле изменения координат:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (все еще зависит от Линии 1 и 2): " + line3);

        // Отвязываем Линию 3 от Линии 1
        Point newStart = new Point(line3.getStart().getX(), line3.getStart().getY());
        line3.setStart(newStart);

        System.out.println("\nИзменим координаты Линии 1 снова:");
        updatePoint(scanner, line1.getStart(), "Новое начало Линии 1");
        updatePoint(scanner, line1.getEnd(), "Новый конец Линии 1");

        System.out.println("\nФинальное состояние:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (теперь независимая от Линии 1): " + line3);

        //ЗАДАНИЕ 3.1
        System.out.println("\nРабота со студентами:");

        // 1. Вася
        int[] vasyaGrades = {3, 4, 5};
        Student vasya = new Student("Вася", vasyaGrades);

        // 2. Петя — копирует оценки (по ссылке)
        Student petya = new Student("Петя", vasya.getGrades());

        // 3. Изменяем первую оценку Пети
        petya.setGrade(0, 5);

        System.out.println("После изменения оценки Пети:");
        System.out.println(vasya); // Тоже изменится!
        System.out.println(petya);
        System.out.println("Объяснение: Вася и Петя используют один и тот же массив оценок.");

        // 4. Андрей — копия оценок Васи (глубокая копия)
        int[] andreyGrades = Student.deepCopyGrades(vasya.getGrades());
        Student andrey = new Student("Андрей", andreyGrades);

        // Меняем оценку у Васи
        vasya.setGrade(1, 2);

        System.out.println("\nПосле изменения оценки Васи:");
        System.out.println(vasya);
        System.out.println(andrey); // Не изменился

        //ЗАДАНИЕ 5.3
        System.out.println("\nЗадание 5.3 - Расчет длины линии:");

        Line line = new Line(1, 1, 10, 15);
        System.out.println("Линия: " + line);
        System.out.println("Длина линии (целое число): " + line.getLength());

        scanner.close();
    }

    private static void updatePoint(Scanner scanner, Point point, String label) {
        System.out.println(label + ":");
        point.setX(readDouble(scanner, "  X = "));
        point.setY(readDouble(scanner, "  Y = "));
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Ошибка: введите число.");
                scanner.next();
            }
        }
    }
}
