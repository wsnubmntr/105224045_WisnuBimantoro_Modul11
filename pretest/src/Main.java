import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = null;

        try {
            input = new Scanner(System.in);

            System.out.print("Masukkan angka pertama : ");
            int angka1 = input.nextInt();

            System.out.print("Masukkan angka kedua : ");
            int angka2 = input.nextInt();

            Kalkulator kalkulator = new Kalkulator();

            double hasil = kalkulator.pembagian(angka1, angka2);

            System.out.println("Hasil pembagian = " + hasil);

        } catch (ArithmeticException e) {

            System.out.println("Error: Penyebut tidak boleh bernilai 0.");

        } catch (InputMismatchException e) {

            System.out.println("Error: Input harus berupa angka.");

        } finally {

            if (input != null) {
                input.close();
            }

            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}