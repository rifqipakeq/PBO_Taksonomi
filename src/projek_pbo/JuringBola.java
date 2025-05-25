package projekpbo.BangunRuang;

public class JuringBola extends BangunRuang {
    private Bola bola;
    private double sudutDerajat;
    private double volume;
    private double luasPermukaan;

    public JuringBola(Bola bola, double sudutDerajat) {
        this.bola = bola;
        this.sudutDerajat = sudutDerajat;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        double Vbola = bola.hitungVolume();
        volume = (sudutDerajat / 360.0) * Vbola;
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        double Lbola = bola.hitungLuasPermukaan();
        luasPermukaan = (sudutDerajat / 360.0) * Lbola;
        return luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}
