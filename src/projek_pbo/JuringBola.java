package projek_pbo;

public class JuringBola extends Bola {
    private double sudutDerajat;
    protected double volume;
    protected double luasPermukaan;

    public JuringBola(double jariJari, double sudutDerajat) {
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
    }

    public double hitungVolume() {
        double Vbola = super.hitungVolume();
        volume = (sudutDerajat / 360.0) * Vbola;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double Lbola = super.hitungLuasPermukaan();
        luasPermukaan = (sudutDerajat / 360.0) * Lbola;
        return luasPermukaan;
    }

}
