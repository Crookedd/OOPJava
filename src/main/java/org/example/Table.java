package org.example;

import java.util.Scanner;


public class Table {
    private int[][] data;
    private int rows;
    private int cols;

    // Конструктор инициализации таблицы
    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new int[rows][cols]; // Инициализация ячеек нулями
    }

    // Получить значение из ячейки
    public int getValue(int row, int col) {
        return data[row][col];
    }

    // Установить значение в ячейку
    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    // Вернуть количество строк
    public int rows() {
        return rows;
    }

    // Вернуть количество столбцов
    public int cols() {
        return cols;
    }

    // Преобразовать таблицу в строку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]);
                if (j < cols - 1) {
                    sb.append(" "); // Пробел между значениями
                }
            }
            sb.append("\n"); // Перенос строки после каждой строки таблицы
        }
        return sb.toString();
    }

    // Вернуть среднее арифметическое всех значений таблицы
    public double average() {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j];
                count++;
            }
        }

        return count == 0 ? 0 : (double) sum / count; // Избегаем деления на ноль
    }

    public static int safeNextInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print("Ошибка! Пожалуйста, введите целое число: ");
                scanner.next();
            }
        }
    }

    // Пример использования
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос размеров таблицы у пользователя
        System.out.print("Введите количество строк: ");
        int rows = safeNextInt(scanner);
        System.out.print("Введите количество столбцов: ");
        int cols = safeNextInt(scanner);

        Table table = new Table(rows, cols);

        for (int i = 0; i < table.rows(); i++) {
            for (int j = 0; j < table.cols(); j++) {
                System.out.printf("Введите значение для ячейки [%d][%d]: ", i, j);
                int value = safeNextInt(scanner);
                table.setValue(i, j, value);
            }
        }

        // Вывод таблицы и среднего арифметического

        System.out.printf("Таблица [%d x %d]:\n", table.rows(), table.cols());
        System.out.println(table);
        System.out.println("Среднее: " + table.average());

        System.out.printf("Значение в ячейке [1][1]: %d\n", table.getValue(1, 1));

        scanner.close();
    }
}