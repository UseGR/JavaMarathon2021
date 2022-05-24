package finalProject;


import java.util.*;

public class Test {
    private static String player1; //имя первого игрока
    private static String player2; //имя второго игрока
    private static final int BATTLEFIELD_LENGTH = 10; //длина поля для морского боя
    private static final int BATTLEFIELD_WIDTH = 10; //ширина поля для морского боя
    private static final int[][] BATTLEFIELD1 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; //поле морского боя первого игрока
    private static final int[][] BATTLEFIELD2 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; // поле морского боя для второго игрока
    private static final int[][] MONITOR1 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; //пустое поле (монитор) морского боя первого игрока. Используется первым игроком при выборе в какую точку поля второго игрока стрелять
    private static final int[][] MONITOR2 = new int[BATTLEFIELD_LENGTH][BATTLEFIELD_WIDTH]; //пустое поле (монитор) морского боя второго игрока. Используется вторым игроком при выборе в какую точку поля первого игрока стрелять
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
        int ran = random.nextInt(2) + 1; //случайный выбор кто первым начнет заполнять свое поле кораблями и первым начнет игру. Если выпадет 1, то первый игрок, если 2, то второй игрок
        System.out.println("Привет, игрок №1, как тебя зовут?");
        setPlayer1(scanner.nextLine());
        System.out.println("Привет, игрок №2, как тебя зовут?");
        setPlayer2(scanner.nextLine());
        if (ran == 1) {
            addShip(getPlayer1(), BATTLEFIELD1);
            addShip(getPlayer2(), BATTLEFIELD2);
            while (true) {
                playGame(getPlayer1(), MONITOR1, BATTLEFIELD2); //ход первого игрока, он смотрит в монитор и стреляет по полю второго
                if (isWinner()) { //проверяем не выиграл ли первый игрок, если выиграл, выходим из бесконечного цикла
                    break;
                }
                playGame(getPlayer2(), MONITOR2, BATTLEFIELD1); //ход второго игрока, он смотрит в монитор и стреляет по полю первого
                if (isWinner()) { //проверяем не выиграл ли второй игрок, если выиграл, выходим из бесконечного цикла
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
        Scanner scanner1 = new Scanner(System.in);     // если запрашивать информацию у пользователя только через один объект класса Scanner,
        Scanner scanner2 = new Scanner(System.in);     // то ввод координат корабля у первого трехпалубного корабля невозможен
        Scanner scanner3 = new Scanner(System.in);     // в консоль выводится сразу 2 сообщения: "getPlayer(), введи координаты первого трехпалубного корабля (формат х,у):"
        Scanner scanner4 = new Scanner(System.in);     // и "введи расположение корабля. 1. Вертикальное. 2. Горизонтальное"
        Scanner scanner5 = new Scanner(System.in);     // при вводе программа уходит в ошибку. Не понял, почему так происходит
        Scanner scanner6 = new Scanner(System.in);     // поэтому пришлось создать 20 объектов класса Scanner, по 2 на каждый корабль, т.к. первый раз запрашивается координата корабля,
        Scanner scanner7 = new Scanner(System.in);     // а второй раз запрашивается расположение
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
        while (true) { //далее идет код по вводу координат кораблей. Каждый корабль (блок кода) обернут бесконечным циклом while (true), чтобы при вводе некорректных координат
            int deck4 = 4;  // пользователю предлагалось заново вводить координаты
            System.out.println(player + ", введи координаты четырехпалубного корабля (формат: x,y):");
            String[] shipCoordinatesToXY1 = scanner1.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты первого трехпалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY2 = scanner3.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты второго трехпалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY3 = scanner5.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты первого двухпалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY4 = scanner7.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты второго двухпалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY5 = scanner9.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты третьего двухпалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY6 = scanner11.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты первого однопалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY7 = scanner13.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты второго однопалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY8 = scanner15.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты третьего однопалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY9 = scanner17.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
            System.out.println(player + ", введи координаты четвертого однопалубного корабля (формат x,y):");
            String[] shipCoordinatesToXY10 = scanner19.nextLine().split(",");
            System.out.println("Введи расположение корабля. 1. Вертикальное. 2. Горизонтальное");
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
    public static void drawField(int[][] battlefield) { //после добавления кораблей, выводим поле на экран. Клетки, в которые пользователь добавил корабль
        System.out.println("  0 1 2 3 4 5 6 7 8 9");    // помечается знаком "Х", пустая клетка без корабля - "_"
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
    private static void playGame(String player, int[][] monitor, int[][] battlefield) { //начинается игра
        while (true) {
            System.out.println("Твой ход, " + player);
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) { //отрисовываем монитор. Игрок начинает стрелять по вражескому полю, делая отметки на своем мониторе
                System.out.print(i + " ");
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("_ ");  //отметка "_", если игрок еще не стрелял в эту клетку
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". "); //отметка ".", если игрок выстрелил в эту клетку, но вражеского корабля в ней не было
                    } else {
                        System.out.print("X "); //отметка "Х", если игрок выстрелил в эту клетку и попал по вражескому кораблю
                    }
                }
                System.out.println();
            }
            System.out.println("Введи координату по оси ОХ");
            int x = scanner.nextInt();
            System.out.println("Введи координату по оси OY");
            int y = scanner.nextInt();
            if (battlefield[x][y] == 1) {
                System.out.println("Попадание!");
                monitor[x][y] = 2;
            } else {
                System.out.println("Промах!");
                monitor[x][y] = 1;
                break;
            }
        }
    }
    private static boolean isWinner() { //выявляем победителя игры
        int counter1 = 0;               //логика такая, что попав во всем кораблям(по всем 20 палубам), игрок считается победителем
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
            System.out.println(getPlayer1() + " победил");
            return true;
        }
        if (counter2 >= 20) {
            System.out.println(getPlayer2() + " победил");
            return true;
        }
        return false;
    }
    private static boolean isAvailable(int x, int y, int deck, int rotation, int[][] battlefield) { //проверка корректности введенных координат кораблей
        if (rotation == 1) {                            //проверка, что пользователь не пытается расположить корабль выше или ниже игрового поля
            if (y + deck > battlefield.length || y > battlefield.length || y < 0) {
                System.out.println("Ошибка! Попытка расположить корабль за пределами поля");
                return false;
            }
        }
        if (rotation == 2) {                            //проверка, что пользователь не пытается расположить корабль левее или правее игрового поля
            if (x + deck > battlefield[0].length || x > battlefield[0].length || x < 0) {
                System.out.println("Ошибка! Попытка расположить корабль за пределами поля");
                return false;
            }
        }
        while (deck != 0) {                             //проверка ореолов кораблей
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
                        System.out.println("Корабль не должен входить в ореол другого корабля");
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0) {
                    if (battlefield[x - 1 + xi][y + yi] != 0) {
                        System.out.println("Корабль не должен входить в ореол другого корабля");
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0) {
                    if (battlefield[x + xi][y + 1 + yi] != 0) {
                        System.out.println("Корабль не должен входить в ореол другого корабля");
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0) {
                    if (battlefield[x + xi][y - 1 + yi] != 0) {
                        System.out.println("Корабль не должен входить в ореол другого корабля");
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }

}
