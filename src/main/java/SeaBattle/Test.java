package SeaBattle;

import java.util.Random;
import java.util.Scanner;

public class Test {
    private static final int FIELD_LENGTH = 10;
    private static final int FIELD_WIDTH = 10;
    private static final int[][] BATTLEFIELD1 = new int[FIELD_LENGTH][FIELD_WIDTH];
    private static final int[][] BATTLEFIELD2 = new int[FIELD_LENGTH][FIELD_WIDTH];
    protected static final int[][] MONITOR1 = new int[FIELD_LENGTH][FIELD_WIDTH];
    protected static final int[][] MONITOR2 = new int[FIELD_LENGTH][FIELD_WIDTH];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int whoFirst = random.nextInt(2) + 1;

        System.out.println("Привет, игрок №1, как тебя зовут?");
        Player player1 = new Player(scanner.nextLine());

        System.out.println("Привет, игрок №2, как тебя зовут?");
        Player player2 = new Player(scanner.nextLine());

        if (whoFirst == 1) {
            player1.drawField(BATTLEFIELD1);
            player1.addShip(BATTLEFIELD1, 4);
            player1.drawField(BATTLEFIELD1);
            for (int i = 0; i < 2; i++) {
                player1.addShip(BATTLEFIELD1, 3);
                player1.drawField(BATTLEFIELD1);
                System.out.println();
            }
            for (int i = 0; i < 3; i++) {
                player1.addShip(BATTLEFIELD1, 2);
                player1.drawField(BATTLEFIELD1);
                System.out.println();
            }
            for (int i = 0; i < 4; i++) {
                player1.addShip(BATTLEFIELD2, 1);
                player1.drawField(BATTLEFIELD1);
                System.out.println();
            }

            player2.drawField(BATTLEFIELD2);
            player2.addShip(BATTLEFIELD2, 4);
            player2.drawField(BATTLEFIELD1);
            for (int i = 0; i < 2; i++) {
                player2.addShip(BATTLEFIELD2, 3);
                player2.drawField(BATTLEFIELD1);
                System.out.println();
            }
            for (int i = 0; i < 3; i++) {
                player2.addShip(BATTLEFIELD2, 2);
                player2.drawField(BATTLEFIELD1);
                System.out.println();
            }
            for (int i = 0; i < 4; i++) {
                player2.addShip(BATTLEFIELD2, 1);
                player2.drawField(BATTLEFIELD1);
                System.out.println();
            }
            while (true) {
                player1.playGame(MONITOR1, BATTLEFIELD2);
                if (player1.isWinner()) {
                    break;
                }
                player2.playGame(MONITOR2, BATTLEFIELD1);
                if (player2.isWinner()) {
                    break;
                }
            }
        } else {
            player2.addShip(BATTLEFIELD2, 4);
            player2.drawField(BATTLEFIELD2);
            System.out.println();
            for (int i = 0; i < 2; i++) {
                player2.addShip(BATTLEFIELD2, 3);
                player2.drawField(BATTLEFIELD2);
                System.out.println();
            }
            for (int i = 0; i < 3; i++) {
                player2.addShip(BATTLEFIELD2, 2);
                player2.drawField(BATTLEFIELD2);
                System.out.println();
            }
            for (int i = 0; i < 4; i++) {
                player2.addShip(BATTLEFIELD2, 1);
                player2.drawField(BATTLEFIELD2);
                System.out.println();
            }

            player1.addShip(BATTLEFIELD1, 4);
            player1.drawField(BATTLEFIELD1);
            System.out.println();
            for (int i = 0; i < 2; i++) {
                player1.addShip(BATTLEFIELD1, 3);
                player1.drawField(BATTLEFIELD1);
                System.out.println();
            }
            for (int i = 0; i < 3; i++) {
                player1.addShip(BATTLEFIELD1, 2);
                player1.drawField(BATTLEFIELD1);
                System.out.println();
            }
            for (int i = 0; i < 4; i++) {
                player1.addShip(BATTLEFIELD1, 1);
                player1.drawField(BATTLEFIELD1);
                System.out.println();
            }

            while (true) {
                player2.playGame(MONITOR2, BATTLEFIELD1);
                if (player2.isWinner()) {
                    break;
                }
                player1.playGame(MONITOR1, BATTLEFIELD2);
                if (player1.isWinner()) {
                    break;
                }
            }
        }
    }
}
