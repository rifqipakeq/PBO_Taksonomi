package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuringLingkaran extends Lingkaran {
    private double sudutJuring;
    protected double luas;
    protected double keliling; 

    public JuringLingkaran(double jariJari,double sudutJuring) {
        super(jariJari);
        this.sudutJuring = sudutJuring;
        this.keliling = hitungKeliling();
        this.luas = hitungLuas();
    }

    @Override
    public double hitungLuas() {
        luas = (sudutJuring / 360.0) * super.hitungLuas();
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = (sudutJuring / 360.0) * super.hitungKeliling() + 2 * super.jariJari;
        return keliling;
    }

    public double hitungLuas(double jariJariBaru, double sudutJuringBaru) {
        luas = (sudutJuringBaru / 360.0) * super.hitungLuas(jariJariBaru);
        return luas;
    }

    public double hitungKeliling(double jariJariBaru, double sudutJuringBaru) {
        keliling = (sudutJuringBaru / 360.0) * super.hitungKeliling(jariJariBaru) + 2 * jariJariBaru;
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
                        System.out.print("Masukkan sudut juring baru (dalam derajat): ");
                        double newSudutJuring = inp.nextDouble();
                        inp.nextLine();

                        luas = hitungLuas(newJariJari, newSudutJuring);
                        keliling = hitungKeliling(newJariJari, newSudutJuring);
                        System.out.printf("\nLuas Juring Lingkaran Baru: %.2f\n", luas);
                        System.out.printf("Keliling Jruing Lingkaran Baru: %.2f\n", keliling);
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
