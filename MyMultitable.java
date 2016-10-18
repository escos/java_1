package com.company;

public class MyMultitable {
    public static void main(String[] args) {
        if (args.length < 2) {
            if (args.length == 0)
                System.out.println("Аргументы не введены");
            else
                checkingFirst(args[0]);
        } else {
            checkingArgs(args[0], args[1]);
        }
    }

    public static void checkingFirst(String x) {
        int a;
        boolean noNumber = true;

        while (noNumber) {
            try {
                a = Integer.parseInt(x);
                System.out.println("Аргумент первый = " + a);
                if (a > 0) {
                    System.out.println("Введите второй аргумент!");
                } else {
                    System.out.println("Аргумент 1 введен не корректно, необходимо ввести значение больше нуля!");
                    System.out.println("Повторите ввод аргументов!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Аргумент первый введен некорректно!!");
                System.out.println("Повторите ввод аргументов!");
            }
            noNumber = false;
        }
    }

    public static void checkingArgs(String x, String y) {
        int a, b;
        boolean noNumber = true;

        while (noNumber) {
            try {
                a = Integer.parseInt(x);
                System.out.println("Аргумент первый = " + a);
                if (a > 0) {
                    while (noNumber) {
                        noNumber = false;
                        try {
                            b = Integer.parseInt(y);
                            System.out.println("Аргумент второй = " + b);
                            if (b > 0) {
                                multiTable(a, b);
                            }
                            System.out.println("Аргумент 2 введен не корректно, необходимо ввести значение больше нуля!");
                        } catch (NumberFormatException e) {
                            System.out.println("Аргумент второй введен некорректно!!");
                        }
                    }
                } else {
                    System.out.println("Аргумент 1 введен не корректно, необходимо ввести значение больше нуля!");
                    System.out.println("Повторите ввод аргументов!");
                    noNumber = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Аргумент первый введен некорректно!!");
                System.out.println("Повторите ввод аргументов!");
                noNumber = false;
            }
        }
    }

    public static void multiTable(int k, int m) {
        int i, j;
        int min, max;
        if (k != m) {
            if (k > m) {
                min = m;
                max = k;
            } else {
                min = k;
                max = m;
            }
            for (i = min; i < (max + 1); i++) {
                for (j = min; j < (max + 1); j++) {
                    System.out.printf("   %5d", (i * j));
                }
                System.out.println("\n");
            }
        } else
            System.out.println("Произведение равно: " + (k * m));
    }
}
