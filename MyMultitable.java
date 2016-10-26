public class MyMultitable {
    public static void main(String[] args) {
        switch (args.length) {
            case 0:
                System.out.println("Необходимо ввести два целочисленных аргумента m и n, программа выведет таблицу умножения от m до n");
                break;
            case 1:
                System.out.println("Введен только один аргумент.Необходимо ввести второй целочисленный аргумерт!");
                System.out.println("Программа выведет таблицу умножения от m до n, если введены оба аргумента m и n.");
                break;
            case 2:
                int number1 = parseAndCheckArgument(args[0]);
                int number2 = parseAndCheckArgument(args[1]);
                showMultiplicateTable(number1, number2);
                break;
            default:
                System.out.println("Введено слишком много аргументов(требуется два целочисленных аргумента)");
        }
    }

    public static void showMultiplicateTable(int k, int m) {
        int min = Math.min(k, m);
        int max = Math.max(k, m);
        if (k != m) {
            System.out.println("Таблица умножения от " + min + " до " + max + " имеет вид:\n");
            for (int i = min; i < (max + 1); i++) {
                for (int j = min; j < (max + 1); j++) {
                    System.out.printf("   %5d", (i * j));
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("Произведение равно: " + (k * m));
        }
    }

    public static int parseAndCheckArgument(String number) {
        try {
            int arg = Integer.parseInt(number);
            if (arg <= 0) {
                System.out.println("Аргумент " + arg + " введен не корректно, необходимо ввести значение больше нуля!");
                System.out.println("Повторите ввод данного аргумента!");
                System.exit(0);
                return 1;
            } else {
                return arg;
            }
        } catch (NumberFormatException e) {
            System.out.println("Аргумент " + number + " введен некорректно, формат не соответствут целочисленному!");
            System.out.println("Повторите ввод данного аргумента!");
            System.exit(0);
            return 1;
        }
    }
}
