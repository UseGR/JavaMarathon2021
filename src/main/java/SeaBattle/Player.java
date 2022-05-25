package SeaBattle;

import java.util.Scanner;

import static SeaBattle.Test.MONITOR1;
import static SeaBattle.Test.MONITOR2;


public class Player {

    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addShip(int[][] battlefield, int deck) {
        while (true) {
            System.out.println(getName() + ", введи координаты " + deck + "-палубного корабля (формат (x,y)): ");
            String[] shipCoordinatesToXY = scanner.nextLine().split(",");
            System.out.println("Выбери расположение корабля. 1. Вертикальное. 2. Горизонтальное.");
            String direction = scanner.nextLine();
            if (!isAvailable(Integer.parseInt(shipCoordinatesToXY[0]), Integer.parseInt(shipCoordinatesToXY[1]), deck, direction, battlefield)) {
                System.out.println();
            } else {
                Ship ship = new Ship(deck, Integer.parseInt(direction));
                for (int i = 0; i < ship.getDeck(); i++) {
                    if (ship.getDirection() == 1) {
                        battlefield[Integer.parseInt(shipCoordinatesToXY[0])][Integer.parseInt(shipCoordinatesToXY[1]) + i] = 1;
                    } else {
                        battlefield[Integer.parseInt(shipCoordinatesToXY[0]) + i][Integer.parseInt(shipCoordinatesToXY[1])] = 1;
                    }
                }
                break;
            }
        }
    }

    public void drawField(int[][] battlefield) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
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

    private boolean isAvailable(int x, int y, int deck, String direction, int[][] battlefield) {
        if (!"1".equals(direction) && !"2".equals(direction)) {
            System.out.println("Введи 1 или 2 (вертикальное или горизонтальное расположение корабля, соответственно)");
            return false;
        }
        if (Integer.parseInt(direction) == 1) {
            if (y + deck > battlefield.length || y > battlefield.length || y < 0) {
                System.out.println("Недопустимо располагать корабль за пределами поля");
                return false;
            }
        }
        if (Integer.parseInt(direction) == 2) {
            if (x + deck > battlefield[0].length || x > battlefield[0].length || x < 0) {
                System.out.println("Недопустимо располагать корабль за пределами поля");
                return false;
            }
        }
        while (deck != 0) {
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;
                if (Integer.parseInt(direction) == 1) {
                    yi = i;
                } else {
                    xi = i;
                }
                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0) {
                    if (battlefield[x + 1 + xi][y + yi] != 0) {
                        System.out.println("Недопустимо располагать корабль вблизи окружения другого корабля");
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0) {
                    if (battlefield[x - 1 + xi][y + yi] != 0) {
                        System.out.println("Недопустимо располагать корабль вблизи окружения другого корабля");
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0) {
                    if (battlefield[x + xi][y + 1 + yi] != 0) {
                        System.out.println("Недопустимо располагать корабль вблизи окружения другого корабля");
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0) {
                    if (battlefield[x + xi][y - 1 + yi] != 0) {
                        System.out.println("Недопустимо располагать корабль вблизи окружения другого корабля");
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }

    public void playGame(int[][] monitor, int[][] battlefield) {
        while (true) {
            System.out.println("Твой ход, " + getName());
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("_ ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println("Выбери, куда хочешь выстрелить (формат х,у): ");
            String[] attackCoordinate = scanner.nextLine().split(",");
            if (battlefield[Integer.parseInt(attackCoordinate[0])][Integer.parseInt(attackCoordinate[1])] == 1) {
                System.out.println("Попадание!");
                monitor[Integer.parseInt(attackCoordinate[0])][Integer.parseInt(attackCoordinate[1])] = 2;
            } else {
                System.out.println("Промах!");
                monitor[Integer.parseInt(attackCoordinate[0])][Integer.parseInt(attackCoordinate[1])] = 1;
                break;
            }
        }
    }

    public boolean isWinner() {
        int counter1 = 0;
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
            System.out.println(getName() + " победил");
            return true;
        }
        if (counter2 >= 20) {
            System.out.println(getName() + " победил");
            return true;
        }
        return false;
    }
}

