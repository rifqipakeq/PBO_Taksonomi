package GUI;

import javax.swing.JOptionPane;
import projek_pbo.Lingkaran;
import projek_pbo.Persegi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class BangunDatar extends javax.swing.JPanel {

    private Lingkaran lingkaran;
    private Persegi persegi;

    public BangunDatar() {
        initComponents();
        tambahkanListener();
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

        if ("Persegi".equals(pilihan)) {
            if (this.persegi == null) {
                this.persegi = new Persegi(5.0); // Nilai default
            }
            double luas = persegi.hitungLuas();
            double keliling = persegi.hitungKeliling();
            jTextField1.setText(String.format("Luas: %.2f\nKeliling: %.2f", luas, keliling));
        } else if ("Lingkaran".equals(pilihan)) {
            // Buat lingkaran dengan jari-jari default, misalnya 5
            lingkaran = new Lingkaran(7.0);

            // Hitung dan tampilkan hasil
            double luas = lingkaran.hitungLuas();
            double keliling = lingkaran.hitungKeliling();

            jTextField1.setText(String.format("Luas: %.2f\nKeliling: %.2f", luas, keliling));
        }
        // Tambahkan else if untuk bangun datar lainnya
    }

    private void tampilkanFormUbahNilai() {
        String pilihan = (String) jComboBox1.getSelectedItem();

        if ("Persegi".equals(pilihan)) {
            if (persegi == null) {
                JOptionPane.showMessageDialog(this, "Hitung terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PilihPersegi panelPersegi = new PilihPersegi();
            panelPersegi.setPersegi(persegi);
            panelPersegi.SisiBaru.setText(String.valueOf(persegi.getSisi()));

            javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();
            tabbedPane.addTab("Ubah Persegi", panelPersegi);
            tabbedPane.setSelectedComponent(panelPersegi);
        } else if ("Lingkaran".equals(pilihan)) {
            if (lingkaran == null) {
                JOptionPane.showMessageDialog(this, "Hitung terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PilihLingkaran panelLingkaran = new PilihLingkaran();
            panelLingkaran.setLingkaran(lingkaran);

            // Set nilai awal
            panelLingkaran.Jari2_Baru.setText(String.valueOf(lingkaran.getJariJari()));

            javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();
            tabbedPane.addTab("Ubah Lingkaran", panelLingkaran);
            tabbedPane.setSelectedComponent(panelLingkaran);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnHitung = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persegi", "Persegi Panjang", "Segitiga", "Lingkaran", "Jajar Genjang", "Trapesium", " " }));

        btnHitung.setText("Hitung");

        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel45.setText("Hasil Perhitungan");

        jButton2.setText("Ya");

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
                    .addComponent(jTextField1)
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
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
