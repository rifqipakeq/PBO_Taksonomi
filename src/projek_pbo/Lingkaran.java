package projek_pbo;

import java.util.InputMismatchException;
import java.util.*;

public class Lingkaran extends BangunDatar implements Runnable {
    protected double jariJari;
    protected final double PI = 3.14;
    protected double luas;
    protected double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.keliling = hitungKeliling();
        this.luas = hitungLuas();
    }

    @Override
    public double hitungLuas() {
        luas =  PI * jariJari * jariJari;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * PI * jariJari;
        return keliling;
    }
    
    public double hitungLuas(double jariJariBaru) {
        luas = PI * jariJariBaru * jariJariBaru;
        return luas;
    }

    public double hitungKeliling(double jariJariBaru) {
        keliling = 2 * PI * jariJariBaru;
        return keliling;
    }
    
     public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari lingkaran? (Y/N): ");
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
                        jariJari = newJariJari;
                        luas = hitungLuas(newJariJari);
                        keliling = hitungKeliling(newJariJari);
                        System.out.printf("\nLuas Lingkaran: %.2f\n", luas);
                        System.out.printf("Keliling Lingkaran: %.2f\n", keliling);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input jari-jari harus berupa angka.");
                        inp.nextLine();
                    }
                    break;
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

    public double getJariJari() {
        return jariJari;
    }

    public double getPI(){
        return PI; 
    }
    
    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.printf("--- Thread [%s] sedang memproses objek Lingkaran ini ---\n", threadName);
        
        try {
            // Simulasi kalkulasi
            System.out.printf("[%s] Menghitung properti Lingkaran (jari-jari: %.2f)...\n", threadName, this.jariJari);
            Thread.sleep(1500); // Jeda 1.5 detik
            
            // Objek ini memproses datanya sendiri
            double luasDihitung = this.hitungLuas();
            double kelilingDihitung = this.hitungKeliling();
            
            System.out.printf("[%s] Hasil Lingkaran -> Luas: %.2f, Keliling: %.2f\n", threadName, luasDihitung, kelilingDihitung);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Thread [%s] diinterupsi.\n", threadName);
        }
        System.out.printf("--- Thread [%s] selesai. ---\n", threadName);
    }


}
