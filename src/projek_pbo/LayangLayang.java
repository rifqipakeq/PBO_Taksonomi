package projek_pbo;

public class LayangLayang extends BangunDatar {

    private double diagonal1;
    private double diagonal2;
    private double sisiPendek;
    private double sisiPanjang;


    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
        this.hitungKeliling();
        this.hitungLuas();
    }

    @Override
    public double hitungLuas() {
        this.luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        this.keliling =  2 * (sisiPendek + sisiPanjang);
        return keliling;
    }
}

//   switch (pilihan) {
//                             case 1:
//                                 System.out.println("\n=== Bangun Ruang ===");
//                                 System.out.println("1. Kubus");
//                                 System.out.print("Masukkan pilihan bangun ruang : ");
//                                 int pilihanBangunRuang = input.nextInt();

//                                 switch (pilihanBangunRuang) {
//                                     case 1:
//                                         System.out.println("\n--- Menghitung Kubus ---");

//                                         System.out.print("Masukkan nilai sisi kubus : ");
//                                         double sisiKubus = input.nextDouble();

//                                         Kubus kubus = new Kubus(sisiKubus);
//                                         System.out.println("Luas Kubus = " + kubus.volume);
//                                         System.out.println("Keliling Kubus = " + kubus.luasPermukaan);
//                                         break;
//                                     default:
//                                         System.out.println("Pilihan bangun datar tidak valid.");
//                                 }
//                         }
