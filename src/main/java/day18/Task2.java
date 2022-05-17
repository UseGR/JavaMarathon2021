package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(717771237));
    }

    public static int count7(int n) {
        if (n == 0) {
            return 0;
        } else if (n % 10 != 7) {
            return count7(n / 10);
        } else {
            return count7(n / 10) + 1;
        }
    }

}
