package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Point> map = new HashMap<>();
        File file = new File("E:\\java lessons\\JavaMarathon2021\\src\\main\\resources\\taxi_cars.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String carsString = scanner.nextLine();
            String[] carsLineArray = carsString.split(" ");
            int[] cars = new int[carsLineArray.length];
            for (int i = 0; i < carsLineArray.length; i++) {
                cars[i] = Integer.parseInt(carsLineArray[i]);
                map.put(cars[0], new Point(cars[1], cars[2]));
            }
        }
        searchCar(map);
    }

    public static void searchCar(Map<Integer, Point> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи координаты x1");
        int x1 = scanner.nextInt();
        System.out.println("Введи координаты y1");
        int y1 = scanner.nextInt();
        System.out.println("Введи координаты x2");
        int x2 = scanner.nextInt();
        System.out.println("Введи координаты y2");
        int y2 = scanner.nextInt();

        int carsInSquareCounter = 0;
        for (Map.Entry<Integer, Point> entry : map.entrySet()) {
            if (x1 < entry.getValue().getX() && y1 < entry.getValue().getY() && x2 > entry.getValue().getX() && y2 > entry.getValue().getY() ||
                    x1 > entry.getValue().getX() && y1 > entry.getValue().getY() && x2 < entry.getValue().getX() && y2 < entry.getValue().getY()) {
                System.out.println("В квадрате машина с идентификатором " + entry.getKey());
                carsInSquareCounter++;
            } else if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) {
                System.out.println("Введены отрицательные координаты");
                return;
            }
        }
        System.out.println("Найдено машин в квадрате: " + carsInSquareCounter);
    }
}

