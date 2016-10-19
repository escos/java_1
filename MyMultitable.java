public class MyMultitable {
    public static void main(String[] args) {
        switch (args.length) {
            case 0:
                System.out.println("Аргументы не введены!");
                break;
            case 1:
                System.out.println("Введен один аргумент, необходимо ввести второй!");
                break;
            case 2:
                checkParseArgs(args[0], args[1]);
                break;
            default:
                System.out.println("Введено слишком много аргументов!");
        }
    }

    public static void checkParseArgs(String x, String y) {
        try {
            int a;
            a = Integer.parseInt(x);
            System.out.println("Аргумент первый = " + a);
            if (a > 0) {
                try {
                    int b;
                    b = Integer.parseInt(y);
                    System.out.println("Аргумент второй = " + b);
                    if (b > 0) {
                        showMultiplicateTable(a, b);
                    } else {
                        System.out.println("Аргумент второй введен не корректно, необходимо ввести значение больше нуля!");
                        System.out.println("Повторите ввод второго аргумента!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Аргумент второй введен некорректно, формат не соответствут int!");
                    System.out.println("Повторите ввод второго аргумента!");
                }
            } else {
                System.out.println("Аргумент первый введен не корректно, необходимо ввести значение больше нуля!");
                System.out.println("Повторите ввод первого аргумента!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Аргумент первый введен некорректно, формат введенного аргумента не соответствует int!");
            System.out.println("Повторите ввод первого аргумента!");
        }
    }

    public static void showMultiplicateTable(int k, int m) {
        int min = Math.min(k, m);
        int max = Math.max(k, m);
        if (k != m) {
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
