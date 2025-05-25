package projek_pbo;

public class PrismaTrapesium extends Trapesium {
    private double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaTrapesium( double alasAtas,double alasBawah,double sisiMiring, double tinggi, double tinggiPrisma) {
        super(alasAtas, alasBawah, sisiMiring, tinggi);
        this.tinggiPrisma = tinggiPrisma;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasAlas = super.luas;
        double kelilingAlas = super.keliling;
        luasPermukaan = 2 * luasAlas + kelilingAlas * tinggiPrisma;
        return luasPermukaan;
    }
}
