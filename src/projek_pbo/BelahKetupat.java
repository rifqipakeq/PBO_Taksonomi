package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BelahKetupat extends BangunDatar {
    protected double sisi;
    protected double diagonal1;
    protected double diagonal2;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.sisi = sisi;
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.hitungKeliling();
        this.hitungLuas();
    }

    @Override
    public double hitungKeliling() {
        this.keliling = (2 * diagonal1) + (2 * diagonal2);
        return keliling;
    }

    @Override
    public double hitungLuas() {
        this.luas = (diagonal1 * diagonal2) / 2;
        return luas;
    }

    public double hitungLuas(double diagonal1Baru, double diagonal2Baru) {
        luas = (diagonal1Baru * diagonal2Baru) / 2;
        return luas;
    }

    public double hitungKeliling(double diagonal1Baru, double diagonal2Baru) {
        keliling = (2 * diagonal1Baru) + (2 * diagonal2Baru);
        return keliling;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal? (Y/N): ");
            String jawab = inp.nextLine();
            
            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukan diagonal 1 baru: ");
                        double newDiagonal1 = inp.nextDouble();
                        System.out.print("Masukan diagonal 2 baru: ");
                        double newDiagonal2 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal1 <= 0 || newDiagonal2 <= 0) {
                            System.out.println("Diagonal harus lebih dari nol.\n");
                            continue;
                        }
                        diagonal1 = newDiagonal1;
                        diagonal2 = newDiagonal2;
                        luas = hitungLuas(newDiagonal1, newDiagonal2);
                        keliling = hitungKeliling(newDiagonal1, newDiagonal2);
                        System.out.printf("\nLuas Belah Ketupat: %.2f\n", luas);
                        System.out.printf("Keliling Belah Ketupat: %.2f\n", keliling);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    public double getSisi() {
        return sisi;
    }
    
    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }
}