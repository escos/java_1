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
                parseArgument(args[0]);
                parseArgument(args[1]);
                int number1 = parseArgument(args[0]);
                int number2 = parseArgument(args[1]);
                checkArguments(number1);
                checkArguments(number2);
                int argument1 = checkArguments(number1);
                int argument2 = checkArguments(number2);
                showMultiplicateTable(argument1,argument2);
                break;
            default:
                System.out.println("Введено слишком много аргументов!");
        }
    }

    public static void showMultiplicateTable(int k, int m) {
        int min = Math.min(k, m);
        int max = Math.max(k, m);
        if (k != m) {
            System.out.println("Таблица умножения от "+min+" до "+max+" имеет вид:\n");
            for (int i = min; i < (max + 1); i++) {
                for (int j = min; j < (max + 1); j++) {
                    System.out.printf("   %5d", (i * j));
                }
                System.out.println("\n");
            }
        } else
            System.out.println("Произведение равно: " + (k * m));
    }

    public static int parseArgument(String number) {

        try {
            int arg = Integer.parseInt(number);
            return arg;
        } catch (NumberFormatException e) {
            System.out.println("Аргумент(ы) введен(ы) некорректно, формат не соответствут int!");
            System.out.println("Повторите ввод аргумента!");
            System.exit(0);
            return 1;
        }
    }

    public static int checkArguments(int factor) {
        if (factor <= 0) {
            System.out.println("Аргумент "+factor+" введен не корректно, необходимо ввести значение больше нуля!");
            System.out.println("Повторите ввод аргумента!");
            System.exit(0);
            return 1;
        } else {
            return factor;
        }
    }
}
