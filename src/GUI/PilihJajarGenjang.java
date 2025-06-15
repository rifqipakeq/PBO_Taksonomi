package GUI;

import javax.swing.*;
import projek_pbo.JajarGenjang;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PilihJajarGenjang extends javax.swing.JPanel {

    private JajarGenjang jajargenjang;

    public PilihJajarGenjang() {
        initComponents();
        this.jajargenjang = new JajarGenjang(10, 12, 8, 6);
        tambahkanListener();
        btnHitung.setEnabled(false);
    }

    public void setJajarGenjang(JajarGenjang jajargenjang) {
        this.jajargenjang = jajargenjang;
    }

    private void tambahkanListener() {
        alasBaru.addActionListener(e -> updateButtonState());
        alasBaru.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }
        });

        btnHitung.addActionListener(e -> updatePerhitungan());
        btnBatal.addActionListener(e -> tutupTab());
    }

    private void updateButtonState() {
        // Aktifkan tombol hanya jika text field tidak kosong
        btnHitung.setEnabled(!alasBaru.getText().trim().isEmpty());
    }

    private void updatePerhitungan() {
        System.out.println("[DEBUG] Status jajargenjang: " + (jajargenjang != null ? "Ada" : "Null"));
        try {
            double alas = Double.parseDouble(alasBaru.getText());
            double tinggi = Double.parseDouble(tinggiBaru.getText());
            double sisiA = Double.parseDouble(sisiABaru.getText());
            double sisiB = Double.parseDouble(sisiBBaru.getText());
            if (alas <= 0 || tinggi <= 0 || sisiA <= 0 || sisiB <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Setiap nilai harus lebih dari nol",
                        "Input Tidak Valid",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            double luas = jajargenjang.hitungLuas(alas, tinggi);
            double keliling = jajargenjang.hitungKeliling(sisiA, sisiB);
            HasilBaru.setText(String.format("Luas: %.2f\nKeliling: %.2f", luas, keliling));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Input harus:\n- Berupa angka\n- Lebih besar dari 0",
                    "Format Salah",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void tutupTab() {
        javax.swing.JTabbedPane tabbedPane = (javax.swing.JTabbedPane) this.getParent();
        if (tabbedPane != null) {
            tabbedPane.remove(this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        alasBaru = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HasilBaru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tinggiBaru = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sisiABaru = new javax.swing.JTextField();
        sisiBBaru = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Masukkan Alas Baru :");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Hasil :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Ubah Nilai Jajar Genjang");

        btnHitung.setText("Hitung Nilai Baru");

        btnBatal.setText("Batal");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Masukkan Tinggi Baru :");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Masukkan Sisi A Baru :");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Masukkan Sisi B Baru :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tinggiBaru, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(alasBaru)
                                    .addComponent(sisiABaru)
                                    .addComponent(sisiBBaru)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBatal)
                                .addGap(18, 18, 18)
                                .addComponent(btnHitung))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(alasBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinggiBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sisiABaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sisiBBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HasilBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnBatal))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HasilBaru;
    public javax.swing.JTextField alasBaru;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField sisiABaru;
    public javax.swing.JTextField sisiBBaru;
    public javax.swing.JTextField tinggiBaru;
    // End of variables declaration//GEN-END:variables
}
