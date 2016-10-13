import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Выберите вид уравнения (1 - линейное, 2 - квадратное):\n ");
            int i = sc.nextInt();
            if ((i != 1) & (i != 2)) {
                System.out.println("Сделайте выбор заново");
                continue;
            } else if (i == 1) {
                System.out.println("Решаем линейное уравнение:\n");
                linear();
            } else {
                System.out.println("Решаем квадратное уравнение:\n");
                square();
            }
        }
    }

    public static void linear() {
        Scanner sc_lin = new Scanner(System.in);
        while(true) {
        System.out.println("Введите коэфициенты a,b:\n");
        float x;
        float a = sc_lin.nextInt();
        float b = sc_lin.nextInt();
        System.out.println(" a = " + a + "\tb = " + b);
        if (a == 0) {
            System.out.println("Коэффициенты введены не верно!");
            continue;}
               else {
                System.out.printf("Решение уравнения: х = %.1f\n",x=-b/a);
                break;
                    }
    }}

    public static void square() {
        Scanner sc_lin = new Scanner(System.in);
        while (true) {
            System.out.println("Введите коэфициенты a,b,c:\n");
            float a = sc_lin.nextInt();
            float b = sc_lin.nextInt();
            float c = sc_lin.nextInt();
            System.out.println(" a = " + a + "\tb = " + b + "\tc = " + c);
            if (a == 0) {
                System.out.println("Коэффициенты введены не верно!");
                continue;
            } else {
                double d = ((Math.pow(b, 2)) - 4 * a * c);
                System.out.println("Дискриминант: D = " + d);
                if (d < 0)
                    System.out.println("Уравнение не имеет решения");
                else {
                    double x1 = ((-b + Math.sqrt(d)) / 2 * a), x2 = ((-b - Math.sqrt(d)) / 2 * a);
                    System.out.println("Решение уравнения:\t");
                    System.out.printf("x1 = %.1f",x1);
                    System.out.printf("\tx2 = %.1f\n",x2);
                    break;
                }
            }

        }
    }
    }
