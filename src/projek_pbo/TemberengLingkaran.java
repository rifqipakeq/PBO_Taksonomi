package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengLingkaran extends Lingkaran {
    private double sudut; 

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.keliling = hitungKeliling();
        this.luas = hitungLuas();
    }

    @Override
    public double hitungLuas() {
        double sudutRadian = Math.toRadians(sudut);
        double luasJuring = (sudut / 360.0) * super.PI * super.jariJari * super.jariJari;
        double luasSegitiga = 0.5 * super.jariJari * super.jariJari * Math.sin(sudutRadian);
        this.luas = luasJuring - luasSegitiga;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        double sudutRadian = Math.toRadians(sudut);
        double panjangBusur = sudutRadian * super.jariJari;
        double taliBusur = 2 * super.jariJari * Math.sin(sudutRadian / 2);
        this.keliling = panjangBusur + taliBusur;
        return keliling;
    }

    public double hitungLuas(double jariJariBaru, double sudutBaru) {
        double sudutRadian = Math.toRadians(sudutBaru);
        double luasJuring = (sudutBaru / 360.0) * super.PI * jariJariBaru * jariJariBaru;
        double luasSegitiga = 0.5 * jariJariBaru * jariJariBaru * Math.sin(sudutRadian);
        this.luas = luasJuring - luasSegitiga;
        return luas;
    }

    public double hitungKeliling(double jariJariBaru, double sudutBaru) {
        double sudutRadian = Math.toRadians(sudutBaru);
        double panjangBusur = sudutRadian * jariJariBaru;
        double taliBusur = 2 * jariJariBaru * Math.sin(sudutRadian / 2);
        this.keliling = panjangBusur + taliBusur;
        return keliling;
    }
    
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari lingkaran dan sudut juring? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0) {
                            System.out.println("Jari-jari harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukkan sudut tembereng baru (dalam derajat): ");
                        double newSudutTembereng = inp.nextDouble();
                        inp.nextLine();

                        luas = hitungLuas(newJariJari, newSudutTembereng);
                        keliling = hitungKeliling(newJariJari, newSudutTembereng);
                        System.out.printf("\nLuas Tembereng Lingkaran Baru: %.2f\n", luas);
                        System.out.printf("Keliling Tembereng Lingkaran Baru: %.2f\n", keliling);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input jari-jari harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                luas = hitungLuas();
                keliling = hitungKeliling();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }
}
