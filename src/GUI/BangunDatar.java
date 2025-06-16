package GUI;

import javax.swing.JOptionPane;

import projek_pbo.*;

public class BangunDatar extends javax.swing.JPanel {

    private Lingkaran lingkaran;
    private Persegi persegi;
    private PersegiPanjang persegiPanjang;
    private Segitiga segitiga;
    private JajarGenjang jajarGenjang;
    private Trapesium trapesium;
    private LayangLayang layangLayang;
    private BelahKetupat belahKetupat;
    private JuringLingkaran juringLingkaran;
    private TemberengLingkaran temberengLingkaran;

    public BangunDatar() {
        initComponents();
        inisialisasiBangunDatar();
        tambahkanListener();
    }

    private void inisialisasiBangunDatar() {
        // Inisialisasi semua bangun datar dengan nilai default
        this.persegi = new Persegi(5.0);
        this.lingkaran = new Lingkaran(7.0);
        this.persegiPanjang = new PersegiPanjang(4.0, 6.0);
        this.segitiga = new Segitiga(3.0, 4.0);
        this.jajarGenjang = new JajarGenjang(5.0, 7.0, 4.0, 5.0);
        this.trapesium = new Trapesium(5.0, 7.0, 4.0, 4.0);
        this.layangLayang = new LayangLayang(5.0, 7.0, 4.0, 4.0);
        this.belahKetupat = new BelahKetupat(5.0, 7.0, 4.0);
        this.juringLingkaran = new JuringLingkaran(7.0, 45.0);
        this.temberengLingkaran = new TemberengLingkaran(7.0, 45.0);
    }

    private void tambahkanListener() {
        // Listener untuk tombol Hitung
        btnHitung.addActionListener(e -> hitungBangunDatar());

        // Listener untuk tombol Ya (ubah nilai)
        jButton2.addActionListener(e -> tampilkanFormUbahNilai());

        // Listener untuk tombol Tidak
        jButton3.addActionListener(e -> {
            // Kembali ke GUI utama atau tutup form
            JOptionPane.showMessageDialog(this, "Perhitungan selesai", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void hitungBangunDatar() {
        String pilihan = (String) jComboBox1.getSelectedItem();
        // Tambahkan validasi
        if (pilihan == null || pilihan.trim().isEmpty() || pilihan.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Pilih bangun datar yang valid", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String hasil = "";

        try {
            switch (pilihan) {
                case "Persegi":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            persegi.hitungLuas(), persegi.hitungKeliling());
                    break;
                case "Lingkaran":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            lingkaran.hitungLuas(), lingkaran.hitungKeliling());
                    break;
                case "Persegi Panjang":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            persegiPanjang.hitungLuas(), persegiPanjang.hitungKeliling());
                    break;
                case "Segitiga":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            segitiga.hitungLuas(), segitiga.hitungKeliling());
                    break;
                case "Jajar Genjang":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            jajarGenjang.hitungLuas(), jajarGenjang.hitungKeliling());
                    break;
                case "Trapesium":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            trapesium.hitungLuas(), trapesium.hitungKeliling());
                    break;
                case "Layang-Layang":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            layangLayang.hitungLuas(), layangLayang.hitungKeliling());
                    break;
                case "Belah Ketupat":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            belahKetupat.hitungLuas(), belahKetupat.hitungKeliling());
                    break;
                case "Juring Lingkaran":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            juringLingkaran.hitungLuas(),
                            juringLingkaran.hitungKeliling());
                    break;
                case "Tembereng Lingkaran":
                    hasil = String.format("Luas: %.2f\nKeliling: %.2f",
                            temberengLingkaran.hitungLuas(),
                            temberengLingkaran.hitungKeliling());
                    break;

                default:
                    hasil = "Pilih bangun datar yang valid";
            }

            HasilAwal.setText(hasil);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanFormUbahNilai() {
        String pilihan = (String) jComboBox1.getSelectedItem();
        javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();

        try {
            switch (pilihan) {
                case "Persegi":
                    PilihPersegi panelPersegi = new PilihPersegi();
                    panelPersegi.setPersegi(persegi);
                    panelPersegi.SisiBaru.setText(String.valueOf(persegi.getSisi()));
                    tabbedPane.addTab("Ubah Persegi", panelPersegi);
                    tabbedPane.setSelectedComponent(panelPersegi);
                    break;
                case "Lingkaran":
                    PilihLingkaran panelLingkaran = new PilihLingkaran();
                    panelLingkaran.setLingkaran(lingkaran);
                    panelLingkaran.Jari2_Baru.setText(String.valueOf(lingkaran.getJariJari()));
                    tabbedPane.addTab("Ubah Lingkaran", panelLingkaran);
                    tabbedPane.setSelectedComponent(panelLingkaran);
                    break;
                case "Persegi Panjang":
                    PilihPersegiPanjang panelPersegiPanjang = new PilihPersegiPanjang();
                    panelPersegiPanjang.setPersegiPanjang(persegiPanjang);
                    panelPersegiPanjang.panjangBaru.setText(String.valueOf(persegiPanjang.getPanjang()));
                    panelPersegiPanjang.lebarBaru.setText(String.valueOf(persegiPanjang.getLebar()));
                    tabbedPane.addTab("Ubah Persegi Panjang", panelPersegiPanjang);
                    tabbedPane.setSelectedComponent(panelPersegiPanjang);
                    break;
                case "Jajar Genjang":
                    PilihJajarGenjang panelJajarGenjang = new PilihJajarGenjang();
                    panelJajarGenjang.setJajarGenjang(jajarGenjang);
                    panelJajarGenjang.alasBaru.setText(String.valueOf(jajarGenjang.getAlas()));
                    panelJajarGenjang.tinggiBaru.setText(String.valueOf(jajarGenjang.getTinggi()));
                    panelJajarGenjang.sisiABaru.setText(String.valueOf(jajarGenjang.getSisiA()));
                    panelJajarGenjang.sisiBBaru.setText(String.valueOf(jajarGenjang.getSisiB()));
                    tabbedPane.addTab("Ubah Jajar Genjang", panelJajarGenjang);
                    tabbedPane.setSelectedComponent(panelJajarGenjang);
                    break;
                case "Segitiga":
                    PilihSegitiga panelSegitiga = new PilihSegitiga();
                    panelSegitiga.setSegitiga(segitiga);
                    panelSegitiga.alasBaru.setText(String.valueOf(segitiga.getAlas()));
                    panelSegitiga.tinggiBaru.setText(String.valueOf(segitiga.getTinggi()));
                    tabbedPane.addTab("Ubah Segitiga", panelSegitiga);
                    tabbedPane.setSelectedComponent(panelSegitiga);
                    break;
                case "Trapesium":
                    PilihTrapesium panelTrapesium = new PilihTrapesium();
                    panelTrapesium.setTrapesium(trapesium);
                    panelTrapesium.AlasAtasBaru.setText(String.valueOf(trapesium.getAlasAtas()));
                    panelTrapesium.AlasBawahBaru.setText(String.valueOf(trapesium.getAlasBawah()));
                    panelTrapesium.TinggiBaru.setText(String.valueOf(trapesium.getTinggi()));
                    panelTrapesium.SisiMiringBaru.setText(String.valueOf(trapesium.getSisiMiring()));
                    tabbedPane.addTab("Ubah Trapesium", panelTrapesium);
                    tabbedPane.setSelectedComponent(panelTrapesium);
                    break;
                case "Layang-Layang":
                    PilihLayangLayang panelLayangLayang = new PilihLayangLayang();
                    panelLayangLayang.setLayangLayang(layangLayang);
                    panelLayangLayang.diagonal1Baru.setText(String.valueOf(layangLayang.getDiagonal1()));
                    panelLayangLayang.diagonal2Baru.setText(String.valueOf(layangLayang.getDiagonal2()));
                    panelLayangLayang.SisiPendekBaru.setText(String.valueOf(layangLayang.getSisiPendek()));
                    panelLayangLayang.SisiPanjangBaru.setText(String.valueOf(layangLayang.getSisiPanjang()));
                    tabbedPane.addTab("Ubah Layang-Layang", panelLayangLayang);
                    tabbedPane.setSelectedComponent(panelLayangLayang);
                    break;
                case "Belah Ketupat":
                    PilihBelahKetupat panelBelahKetupat = new PilihBelahKetupat();
                    panelBelahKetupat.setBelahKetupat(belahKetupat);
                    panelBelahKetupat.diagonal1Baru.setText(String.valueOf(belahKetupat.getDiagonal1()));
                    panelBelahKetupat.diagonal2Baru.setText(String.valueOf(belahKetupat.getDiagonal2()));
                    tabbedPane.addTab("Ubah Belah Ketupat", panelBelahKetupat);
                    tabbedPane.setSelectedComponent(panelBelahKetupat);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Fitur ubah nilai belum tersedia untuk " + pilihan,
                            "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnHitung = new javax.swing.JButton();
        HasilAwal = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setText("Menghitung Bangun 2 Dimensi");

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel44.setText("Silahkan Pilih Bangun");

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persegi", "Persegi Panjang", "Segitiga", "Lingkaran", "Jajar Genjang", "Trapesium", "Layang-Layang", "Juring Lingkaran", "Tembereng Lingkaran", " " }));

        btnHitung.setText("Hitung");

        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel45.setText("Hasil Perhitungan");

        jButton2.setText("Ya");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel46.setText("Ingin Mengubah Nilai ?");

        jButton3.setText("Tidak");

        btnBack.setText("back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HasilAwal)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel43)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HasilAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Kembali ke Menu Utama?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();
            if (tabbedPane != null) {
                tabbedPane.remove(this);
            }
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HasilAwal;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    // End of variables declaration//GEN-END:variables
}
