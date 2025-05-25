package projek_pbo;

public class Kubus extends Persegi{
    protected double volume;
    protected double luasPermukaan;

    public Kubus(double sisi) {
        super(sisi);
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume =  super.hitungLuas() * super.getSisi();
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = super.hitungLuas() * 6;
        return luasPermukaan;
    }
}
