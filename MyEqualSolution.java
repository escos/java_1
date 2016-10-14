import java.util.Scanner;
public class MyEqualSolution {
   static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
        while (true) {
            System.out.printf("Выберите вид уравнения (1 - линейное, 2 - квадратное):\n ");
            int i = sc.nextInt();
            if ((i != 1) & (i != 2)) {
                System.out.println("Сделайте выбор заново");
                continue;
            } else
                if (i == 1) {
                    System.out.println("Решаем линейное уравнение:\n");
                    linearSolution();
                } else {
                    System.out.println("Решаем квадратное уравнение:\n");
                    squareSolution();
                }
        }
    }

    public static void linearSolution() {
        while(true) {
            System.out.println("Введите коэфициенты линейного уравнения:\n");
            System.out.println("Введите a:\n");
            double a = sc.nextDouble();
            if (a == 0) {
                System.out.println("Коэффициент введен не верно!");
                continue;
            } else {
                System.out.println("Введите b:\n");
                double b = sc.nextDouble();
                System.out.println("Коэффициенты: a = " + a + "\tb = " + b);
                double x=-b/a;
                System.out.printf("Решение уравнения: х = %.1f\n", x);
                break;
            }
        }
    }

    public static void squareSolution() {
        while (true) {
            System.out.println("Введите коэфициенты:\n");
            System.out.println("Введите a:\n");
            double a = sc.nextDouble();
            if (a == 0) {
                System.out.println("Решение линейного уравнения (частный случай квадратного):");
                linearSolution();
            } else {
                System.out.println("Введите b:\n");
                double b = sc.nextDouble();
                System.out.println("Введите с:\n");
                double c = sc.nextDouble();
                System.out.println(" a = " + a + "\tb = " + b + "\tc = " + c);
                double d = ((Math.pow(b, 2)) - 4 * a * c);
                System.out.println("Дискриминант: D = " + d);
                if (d < 0) {
                    System.out.println("Уравнение не имеет решения");
                    break;
                } else {
                    double x1 = ((-b + Math.sqrt(d)) / 2 * a);
                    double x2 = ((-b - Math.sqrt(d)) / 2 * a);
                    System.out.println("Решение уравнения:\t");
                    System.out.printf("x1 = %.1f",x1);
                    System.out.printf("\tx2 = %.1f\n",x2);
                    break;
                }
            }

        }
    }
    }
