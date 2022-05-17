package day18;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[1 + random.nextInt(10)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = -500 + random.nextInt(1000) * 3;
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Сумма элементов массива: " + recursionSum(numbers,0));
    }

    public static int recursionSum(int[] array, int i) { //i - ндекс элемента в массиве
        if (i == array.length - 1)
            return array[i];
        return array[i] + recursionSum(array, i+1);

    }
}

