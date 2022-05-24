package finalProject;


import java.util.*;

public class Test {
    private static String player1; //��� ������� ������
    private static String player2; //��� ������� ������
    private static final int BATTLEFIELD_LENGTH = 10; //����� ���� ��� �������� ���
    private static final int BATTLEFIELD_WIDTH = 10; //������ ���� ��� �������� ���
    private static final int[][] BATTLEFIELD1 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; //���� �������� ��� ������� ������
    private static final int[][] BATTLEFIELD2 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; // ���� �������� ��� ��� ������� ������
    private static final int[][] MONITOR1 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; //������ ���� (�������) �������� ��� ������� ������. ������������ ������ ������� ��� ������ � ����� ����� ���� ������� ������ ��������
    private static final int[][] MONITOR2 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; //������ ���� (�������) �������� ��� ������� ������. ������������ ������ ������� ��� ������ � ����� ����� ���� ������� ������ ��������
    public static Scanner scanner = new Scanner(System.in);
    public static String getPlayer1() {
        return player1;
    }
    public static void setPlayer1(String player1) {
        Test.player1 = player1;
    }
    public static String getPlayer2() {
        return player2;
    }
    public static void setPlayer2(String player2) {
        Test.player2 = player2;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int ran = random.nextInt(2) + 1; //��������� ����� ��� ������ ������ ��������� ���� ���� ��������� � ������ ������ ����. ���� ������� 1, �� ������ �����, ���� 2, �� ������ �����
        System.out.println("������, ����� �1, ��� ���� �����?");
        setPlayer1(scanner.nextLine());
        System.out.println("������, ����� �2, ��� ���� �����?");
        setPlayer2(scanner.nextLine());
        if (ran == 1) {
            addShip(getPlayer1(), BATTLEFIELD1);
            addShip(getPlayer2(), BATTLEFIELD2);
            while (true) {
                playGame(getPlayer1(), MONITOR1, BATTLEFIELD2); //��� ������� ������, �� ������� � ������� � �������� �� ���� �������
                if (isWinner()) { //��������� �� ������� �� ������ �����, ���� �������, ������� �� ������������ �����
                    break;
                }
                playGame(getPlayer2(), MONITOR2, BATTLEFIELD1); //��� ������� ������, �� ������� � ������� � �������� �� ���� �������
                if (isWinner()) { //��������� �� ������� �� ������ �����, ���� �������, ������� �� ������������ �����
                    break;
                }
            }
        } else {
            addShip(getPlayer2(), BATTLEFIELD2);
            addShip(getPlayer1(), BATTLEFIELD1);
            while (true) {
                playGame(getPlayer2(), MONITOR2, BATTLEFIELD1);
                if (isWinner()) {
                    break;
                }
                playGame(getPlayer1(), MONITOR1, BATTLEFIELD2);
                if (isWinner()) {
                    break;
                }
            }
        }
    }
    public static void addShip(String player, int[][] battlefield) {
        Scanner scanner1 = new Scanner(System.in);     // ���� ����������� ���������� � ������������ ������ ����� ���� ������ ������ Scanner,
        Scanner scanner2 = new Scanner(System.in);     // �� ���� ��������� ������� � ������� ������������� ������� ����������
        Scanner scanner3 = new Scanner(System.in);     // � ������� ��������� ����� 2 ���������: "getPlayer(), ����� ���������� ������� ������������� ������� (������ �,�):"
        Scanner scanner4 = new Scanner(System.in);     // � "����� ������������ �������. 1. ������������. 2. ��������������"
        Scanner scanner5 = new Scanner(System.in);     // ��� ����� ��������� ������ � ������. �� �����, ������ ��� ����������
        Scanner scanner6 = new Scanner(System.in);     // ������� �������� ������� 20 �������� ������ Scanner, �� 2 �� ������ �������, �.�. ������ ��� ������������� ���������� �������,
        Scanner scanner7 = new Scanner(System.in);     // � ������ ��� ������������� ������������
        Scanner scanner8 = new Scanner(System.in);
        Scanner scanner9 = new Scanner(System.in);
        Scanner scanner10 = new Scanner(System.in);
        Scanner scanner11 = new Scanner(System.in);
        Scanner scanner12 = new Scanner(System.in);
        Scanner scanner13 = new Scanner(System.in);
        Scanner scanner14 = new Scanner(System.in);
        Scanner scanner15 = new Scanner(System.in);
        Scanner scanner16 = new Scanner(System.in);
        Scanner scanner17 = new Scanner(System.in);
        Scanner scanner18 = new Scanner(System.in);
        Scanner scanner19 = new Scanner(System.in);
        Scanner scanner20 = new Scanner(System.in);
        while (true) { //����� ���� ��� �� ����� ��������� ��������. ������ ������� (���� ����) ������� ����������� ������ while (true), ����� ��� ����� ������������ ���������
            int deck4 = 4;  // ������������ ������������ ������ ������� ����������
            System.out.println(player + ", ����� ���������� ���������������� ������� (������: x,y):");
            String[] shipCoordinatesToXY1 = scanner1.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner2.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY1[0]), Integer.parseInt(shipCoordinatesToXY1[1]), deck4, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck4; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY1[0])][Integer.parseInt(shipCoordinatesToXY1[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY1[0]) + i][Integer.parseInt(shipCoordinatesToXY1[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck3 = 3;
            System.out.println(player + ", ����� ���������� ������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY2 = scanner3.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner4.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY2[0]), Integer.parseInt(shipCoordinatesToXY2[1]), deck3, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck3; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY2[0])][Integer.parseInt(shipCoordinatesToXY2[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY2[0]) + i][Integer.parseInt(shipCoordinatesToXY2[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck3 = 3;
            System.out.println(player + ", ����� ���������� ������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY3 = scanner5.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner6.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY3[0]), Integer.parseInt(shipCoordinatesToXY3[1]), deck3, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck3; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY3[0])][Integer.parseInt(shipCoordinatesToXY3[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY3[0]) + i][Integer.parseInt(shipCoordinatesToXY3[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck2 = 2;
            System.out.println(player + ", ����� ���������� ������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY4 = scanner7.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner8.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY4[0]), Integer.parseInt(shipCoordinatesToXY4[1]), deck2, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck2; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY4[0])][Integer.parseInt(shipCoordinatesToXY4[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY4[0]) + i][Integer.parseInt(shipCoordinatesToXY4[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck2 = 2;
            System.out.println(player + ", ����� ���������� ������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY5 = scanner9.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner10.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY5[0]), Integer.parseInt(shipCoordinatesToXY5[1]), deck2, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck2; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY5[0])][Integer.parseInt(shipCoordinatesToXY5[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY5[0]) + i][Integer.parseInt(shipCoordinatesToXY5[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck2 = 2;
            System.out.println(player + ", ����� ���������� �������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY6 = scanner11.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner12.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY6[0]), Integer.parseInt(shipCoordinatesToXY6[1]), deck2, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck2; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY6[0])][Integer.parseInt(shipCoordinatesToXY6[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY6[0]) + i][Integer.parseInt(shipCoordinatesToXY6[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck1 = 1;
            System.out.println(player + ", ����� ���������� ������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY7 = scanner13.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner14.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY7[0]), Integer.parseInt(shipCoordinatesToXY7[1]), deck1, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck1; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY7[0])][Integer.parseInt(shipCoordinatesToXY7[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY7[0]) + i][Integer.parseInt(shipCoordinatesToXY7[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck1 = 1;
            System.out.println(player + ", ����� ���������� ������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY8 = scanner15.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner16.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY8[0]), Integer.parseInt(shipCoordinatesToXY8[1]), deck1, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck1; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY8[0])][Integer.parseInt(shipCoordinatesToXY8[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY8[0]) + i][Integer.parseInt(shipCoordinatesToXY8[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck1 = 1;
            System.out.println(player + ", ����� ���������� �������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY9 = scanner17.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner18.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY9[0]), Integer.parseInt(shipCoordinatesToXY9[1]), deck1, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck1; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY9[0])][Integer.parseInt(shipCoordinatesToXY9[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY9[0]) + i][Integer.parseInt(shipCoordinatesToXY9[1])] = 1;
                    }
                }
                break;
            }
        }
        while (true) {
            int deck1 = 1;
            System.out.println(player + ", ����� ���������� ���������� ������������� ������� (������ x,y):");
            String[] shipCoordinatesToXY10 = scanner19.nextLine().split(",");
            System.out.println("����� ������������ �������. 1. ������������. 2. ��������������");
            int direction = scanner20.nextInt();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY10[0]), Integer.parseInt(shipCoordinatesToXY10[1]), deck1, direction, battlefield)) {
                System.out.println();
            } else {
                for (int i = 0; i < deck1; i++) {
                    if (direction == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY10[0])][Integer.parseInt(shipCoordinatesToXY10[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY10[0]) + i][Integer.parseInt(shipCoordinatesToXY10[1])] = 1;
                    }
                }
                break;
            }
        }
        drawField(battlefield);
    }
    public static void drawField(int[][] battlefield) { //����� ���������� ��������, ������� ���� �� �����. ������, � ������� ������������ ������� �������
        System.out.println("  0 1 2 3 4 5 6 7 8 9");    // ���������� ������ "�", ������ ������ ��� ������� - "_"
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < battlefield[1].length; j++) {
                if (battlefield[j][i] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    private static void playGame(String player, int[][] monitor, int[][] battlefield) { //���������� ����
        while (true) {
            System.out.println("���� ���, " + player);
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) { //������������ �������. ����� �������� �������� �� ���������� ����, ����� ������� �� ����� ��������
                System.out.print(i + " ");
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("_ ");  //������� "_", ���� ����� ��� �� ������� � ��� ������
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". "); //������� ".", ���� ����� ��������� � ��� ������, �� ���������� ������� � ��� �� ����
                    } else {
                        System.out.print("X "); //������� "�", ���� ����� ��������� � ��� ������ � ����� �� ���������� �������
                    }
                }
                System.out.println();
            }
            System.out.println("����� ���������� �� ��� ��");
            int x = scanner.nextInt();
            System.out.println("����� ���������� �� ��� OY");
            int y = scanner.nextInt();
            if (battlefield[x][y] == 1) {
                System.out.println("���������!");
                monitor[x][y] = 2;
            } else {
                System.out.println("������!");
                monitor[x][y] = 1;
                break;
            }
        }
    }
    private static boolean isWinner() { //�������� ���������� ����
        int counter1 = 0;               //������ �����, ��� ����� �� ���� ��������(�� ���� 20 �������), ����� ��������� �����������
        for (int[] ints : MONITOR1) {
            for (int anInt : ints) {
                if (anInt == 2) {
                    counter1++;
                }
            }
        }
        int counter2 = 0;
        for (int[] ints : MONITOR2) {
            for (int anInt : ints) {
                if (anInt == 2) {
                    counter2++;
                }
            }
        }
        if (counter1 >= 20) {
            System.out.println(getPlayer1() + " �������");
            return true;
        }
        if (counter2 >= 20) {
            System.out.println(getPlayer2() + " �������");
            return true;
        }
        return false;
    }
    private static boolean isAvailable(int x, int y, int deck, int rotation, int[][] battlefield) { //�������� ������������ ��������� ��������� ��������
        if (rotation == 1) {                            //��������, ��� ������������ �� �������� ����������� ������� ���� ��� ���� �������� ����
            if (y + deck > battlefield.length || y > battlefield.length || y < 0) {
                System.out.println("������! ������� ����������� ������� �� ��������� ����");
                return false;
            }
        }
        if (rotation == 2) {                            //��������, ��� ������������ �� �������� ����������� ������� ����� ��� ������ �������� ����
            if (x + deck > battlefield[0].length || x > battlefield[0].length || x < 0) {
                System.out.println("������! ������� ����������� ������� �� ��������� ����");
                return false;
            }
        }
        while (deck != 0) {                             //�������� ������� ��������
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;
                if (rotation == 1) {
                    yi = i;
                } else {
                    xi = i;
                }
                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0) {
                    if (battlefield[x + 1 + xi][y + yi] != 0) {
                        System.out.println("������� �� ������ ������� � ����� ������� �������");
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0) {
                    if (battlefield[x - 1 + xi][y + yi] != 0) {
                        System.out.println("������� �� ������ ������� � ����� ������� �������");
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0) {
                    if (battlefield[x + xi][y + 1 + yi] != 0) {
                        System.out.println("������� �� ������ ������� � ����� ������� �������");
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0) {
                    if (battlefield[x + xi][y - 1 + yi] != 0) {
                        System.out.println("������� �� ������ ������� � ����� ������� �������");
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }

}
