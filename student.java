package lab2;

import java.util.Arrays;

class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public void setGrade(int index, int grade) {
        if (index >= 0 && index < grades.length) {
            grades[index] = grade;
        }
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

    // Глубокая копия массива оценок
    public static int[] deepCopyGrades(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }
}
