package com.company;

public class MyMultitable {
    public static void main(String[] args) {
        switch (args.length) {
            case 0:
                System.out.println("Аргументы не введены!");
                break;
            case 1:
                checkingFirst(args[0]);
                break;
            case 2:
                checkingArgs(args[0], args[1]);
                break;
            default:
                System.out.println("Введено слишком много аргументов!");
        }
    }

    public static void checkingFirst(String x) {
        int a;
        try {
            a = Integer.parseInt(x);
            System.out.println("Аргумент первый = " + a);
            if (a > 0) {
                System.out.println("Необходимо ввести второй аргумент!");
            } else {
                System.out.println("Аргумент 1 введен не корректно, необходимо ввести значение больше нуля!");
                System.out.println("Повторите ввод аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Аргумент первый введен некорректно!!");
            System.out.println("Повторите ввод аргументов!");
        }
    }

    public static void checkingArgs(String x, String y) {
        int a, b;
        try {
            a = Integer.parseInt(x);
            System.out.println("Аргумент первый = " + a);
            if (a > 0) {
                try {
                    b = Integer.parseInt(y);
                    System.out.println("Аргумент второй = " + b);
                    if (b > 0)
                        multiTable(a, b);
                    else
                        System.out.println("Аргумент 2 введен не корректно, необходимо ввести значение больше нуля!");
                } catch (NumberFormatException e) {
                    System.out.println("Аргумент второй введен некорректно!!");
                }
            } else {
                System.out.println("Аргумент 1 введен не корректно, необходимо ввести значение больше нуля!");
                System.out.println("Повторите ввод аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Аргумент первый введен некорректно!!");
            System.out.println("Повторите ввод аргументов!");
        }
    }

    public static void multiTable(int k, int m) {
        if (k != m) {
            int min, max;
            if (Math.min(k, m) == k) {
                min = k;
                max = m;
            } else {
                min = m;
                max = k;
            }
            for (int i = min; i < (max + 1); i++) {
                for (int j = min; j < (max + 1); j++) {
                    System.out.printf("   %5d", (i * j));
                }
                System.out.println("\n");
            }
        } else
            System.out.println("Произведение равно: " + (k * m));
    }
}
