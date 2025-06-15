import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import projek_pbo.*;

public class GeometriGUI extends JFrame {
    private JComboBox<String> shapeComboBox;
    private JTextArea outputArea;
    private JButton calculateButton;
    private JButton threadButton;
    private JPanel parameterPanel;
    private List<JTextField> parameterFields = new ArrayList<>();
    private List<BendaGeometri> shapes = new ArrayList<>();

    public GeometriGUI() {
        setTitle("Program Perhitungan Benda Geometri");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel titleLabel = new JLabel("Program Perhitungan Benda Geometri");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main content panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(240, 240, 240));

        // Control panels
        JPanel controlPanel = createControlPanel();
        parameterPanel = new JPanel();
        parameterPanel.setLayout(new BoxLayout(parameterPanel, BoxLayout.Y_AXIS));
        parameterPanel.setBorder(BorderFactory.createTitledBorder("Parameter Bentuk"));
        parameterPanel.setBackground(Color.WHITE);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setBackground(new Color(250, 250, 250));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Hasil Perhitungan"));
        scrollPane.setPreferredSize(new Dimension(200, 300));

        // Add components to main panel
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(controlPanel, BorderLayout.NORTH);
        topPanel.add(parameterPanel, BorderLayout.CENTER);
        topPanel.setBackground(new Color(240, 240, 240));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        // Initialize
        updateOutput("Selamat datang di Program Perhitungan Benda Geometri\n");
        updateParameterFields();
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
        panel.setBackground(new Color(240, 240, 240));

        // Shape selection panel
        JPanel shapePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        shapePanel.setBackground(new Color(240, 240, 240));
        shapePanel.add(new JLabel("Pilih Bentuk Geometri:"));

        String[] shapeOptions = {
            "Segitiga", "Jajar Genjang", "Belah Ketupat", "Persegi Panjang", 
            "Layang-Layang", "Persegi", "Trapesium", "Lingkaran", 
            "Juring Lingkaran", "Tembereng Lingkaran", "Kubus", 
            "Limas Persegi", "Prisma Persegi", "Limas Belah Ketupat", 
            "Prisma Belah Ketupat", "Limas Layang Layang", "Prisma Layang Layang", 
            "Limas Segitiga", "Prisma Segitiga", "Limas Jajar Genjang", 
            "Prisma Jajar Genjang", "Limas Trapesium", "Prisma Trapesium", 
            "Balok", "Limas Persegi Panjang", "Prisma Persegi Panjang", 
            "Bola", "Cincin Bola", "Juring Bola", "Tembereng Bola", 
            "Kerucut", "Kerucut Terpancung", "Tabung"
        };

        shapeComboBox = new JComboBox<>(shapeOptions);
        shapeComboBox.setPreferredSize(new Dimension(250, 30));
        shapeComboBox.addActionListener(e -> updateParameterFields());
        shapePanel.add(shapeComboBox);

        calculateButton = new JButton("Hitung");
        calculateButton.setPreferredSize(new Dimension(120, 30));
        calculateButton.setBackground(Color.WHITE);
        calculateButton.setForeground(Color.BLACK);
        calculateButton.addActionListener(this::hitungBentuk);
        shapePanel.add(calculateButton);

        threadButton = new JButton("Hitung dengan Thread Pool");
        threadButton.setPreferredSize(new Dimension(220, 30));
        threadButton.setBackground(Color.WHITE);
        threadButton.setForeground(Color.BLACK);
        threadButton.addActionListener(e -> prosesDenganThread());
        shapePanel.add(threadButton);

        panel.add(shapePanel);

        return panel;
    }

    private void updateParameterFields() {
        parameterPanel.removeAll();
        parameterFields = new ArrayList<>();

        String selectedShape = (String) shapeComboBox.getSelectedItem();
        List<String> labels = getParameterLabels(selectedShape);

        for (String label : labels) {
            JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            fieldPanel.setBackground(Color.WHITE);
            fieldPanel.add(new JLabel(label + ": "));
            JTextField field = new JTextField("1.0", 10);
            field.setPreferredSize(new Dimension(100, 30));
            parameterFields.add(field);
            fieldPanel.add(field);
            parameterPanel.add(fieldPanel);
        }

        parameterPanel.revalidate();
        parameterPanel.repaint();
    }

    private List<String> getParameterLabels(String shape) {
        switch (shape) {
            case "Segitiga": return List.of("Alas", "Tinggi");
            case "Jajar Genjang": return List.of("Alas", "Sisi Miring", "Tinggi Alas", "Tinggi Sisi");
            case "Belah Ketupat": return List.of("Sisi", "Diagonal 1", "Diagonal 2");
            case "Persegi Panjang": return List.of("Panjang", "Lebar");
            case "Layang-Layang": return List.of("Diagonal 1", "Diagonal 2", "Sisi Pendek", "Sisi Panjang");
            case "Persegi": return List.of("Sisi");
            case "Trapesium": return List.of("Sisi Sejajar 1", "Sisi Sejajar 2", "Sisi Miring 1", "Sisi Miring 2");
            case "Lingkaran": return List.of("Jari-jari");
            case "Juring Lingkaran": return List.of("Jari-jari", "Sudut (derajat)");
            case "Tembereng Lingkaran": return List.of("Jari-jari", "Sudut (derajat)");
            case "Kubus": return List.of("Sisi");
            case "Limas Persegi": return List.of("Sisi Alas", "Tinggi Limas");
            case "Prisma Persegi": return List.of("Sisi Alas", "Tinggi Prisma");
            case "Limas Belah Ketupat": return List.of("Diagonal 1", "Diagonal 2", "Sisi", "Tinggi Limas");
            case "Prisma Belah Ketupat": return List.of("Diagonal 1", "Diagonal 2", "Sisi", "Tinggi Prisma");
            case "Limas Layang Layang": return List.of("Diagonal 1", "Diagonal 2", "Sisi Pendek", "Sisi Panjang", "Tinggi Limas");
            case "Prisma Layang Layang": return List.of("Diagonal 1", "Diagonal 2", "Sisi Pendek", "Sisi Panjang", "Tinggi Prisma");
            case "Limas Segitiga": return List.of("Alas", "Tinggi Alas", "Tinggi Limas");
            case "Prisma Segitiga": return List.of("Alas", "Tinggi Alas", "Tinggi Prisma");
            case "Limas Jajar Genjang": return List.of("Alas", "Sisi Miring", "Tinggi Alas", "Tinggi Sisi", "Tinggi Limas");
            case "Prisma Jajar Genjang": return List.of("Alas", "Sisi Miring", "Tinggi Alas", "Tinggi Sisi", "Tinggi Prisma");
            case "Limas Trapesium": return List.of("Sisi Sejajar 1", "Sisi Sejajar 2", "Sisi Miring 1", "Sisi Miring 2", "Tinggi Limas");
            case "Prisma Trapesium": return List.of("Sisi Sejajar 1", "Sisi Sejajar 2", "Sisi Miring 1", "Sisi Miring 2", "Tinggi Prisma");
            case "Balok": return List.of("Panjang", "Lebar", "Tinggi");
            case "Limas Persegi Panjang": return List.of("Panjang Alas", "Lebar Alas", "Tinggi Limas");
            case "Prisma Persegi Panjang": return List.of("Panjang Alas", "Lebar Alas", "Tinggi Prisma");
            case "Bola": return List.of("Jari-jari");
            case "Cincin Bola": return List.of("Jari-jari Dalam", "Jari-jari Luar");
            case "Juring Bola": return List.of("Jari-jari", "Sudut (derajat)");
            case "Tembereng Bola": return List.of("Jari-jari", "Tinggi Tembereng");
            case "Kerucut": return List.of("Jari-jari Alas", "Tinggi Kerucut");
            case "Kerucut Terpancung": return List.of("Jari-jari Bawah", "Jari-jari Atas", "Tinggi Kerucut");
            case "Tabung": return List.of("Jari-jari", "Tinggi Tabung");
            default: return List.of();
        }
    }

    private void hitungBentuk(ActionEvent e) {
        bersihkanOutput();
        try {
            BendaGeometri shape = buatBentukDariInput();
            if (shape != null) {
                updateOutputDenganHasil(shape, (String) shapeComboBox.getSelectedItem());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private BendaGeometri buatBentukDariInput() {
        String selected = (String) shapeComboBox.getSelectedItem();
        List<Double> values = new ArrayList<>();
        for (JTextField field : parameterFields) {
            values.add(Double.parseDouble(field.getText()));
        }

        switch (selected) {
            case "Segitiga": return new Segitiga(values.get(0), values.get(1));
            case "Jajar Genjang": return new JajarGenjang(values.get(0), values.get(1), values.get(2), values.get(3));
            case "Belah Ketupat": return new BelahKetupat(values.get(0), values.get(1), values.get(2));
            case "Persegi Panjang": return new PersegiPanjang(values.get(0), values.get(1));
            case "Layang-Layang": return new LayangLayang(values.get(0), values.get(1), values.get(2), values.get(3));
            case "Persegi": return new Persegi(values.get(0));
            case "Trapesium": return new Trapesium(values.get(0), values.get(1), values.get(2), values.get(3));
            case "Lingkaran": return new Lingkaran(values.get(0));
            case "Juring Lingkaran": return new JuringLingkaran(values.get(0), values.get(1));
            case "Tembereng Lingkaran": return new TemberengLingkaran(values.get(0), values.get(1));
            case "Kubus": return new Kubus(values.get(0));
            case "Limas Persegi": return new LimasPersegi(values.get(0), values.get(1));
            case "Prisma Persegi": return new PrismaPersegi(values.get(0), values.get(1));
            case "Limas Belah Ketupat": return new LimasBelahKetupat(values.get(0), values.get(1), values.get(2), values.get(3));
            case "Prisma Belah Ketupat": return new PrismaBelahKetupat(values.get(0), values.get(1), values.get(2), values.get(3));
            case "Limas Layang Layang": return new LimasLayangLayang(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
            case "Prisma Layang Layang": return new PrismaLayangLayang(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
            case "Limas Segitiga": return new LimasSegitiga(values.get(0), values.get(1), values.get(2));
            case "Prisma Segitiga": return new PrismaSegitiga(values.get(0), values.get(1), values.get(2));
            case "Limas Jajar Genjang": return new LimasJajarGenjang(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
            case "Prisma Jajar Genjang": return new PrismaJajarGenjang(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
            case "Limas Trapesium": return new LimasTrapesium(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
            case "Prisma Trapesium": return new PrismaTrapesium(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
            case "Balok": return new Balok(values.get(0), values.get(1), values.get(2));
            case "Limas Persegi Panjang": return new LimasPersegiPanjang(values.get(0), values.get(1), values.get(2));
            case "Prisma Persegi Panjang": return new PrismaPersegiPanjang(values.get(0), values.get(1), values.get(2));
            case "Bola": return new Bola(values.get(0));
            case "Cincin Bola": return new CincinBola(values.get(0), values.get(1));
            case "Juring Bola": return new JuringBola(values.get(0), values.get(1));
            case "Tembereng Bola": return new TemberengBola(values.get(0), values.get(1));
            case "Kerucut": return new Kerucut(values.get(0), values.get(1));
            case "Kerucut Terpancung": return new KerucutTerpancung(values.get(0), values.get(1), values.get(2));
            case "Tabung": return new Tabung(values.get(0), values.get(1));
            default: return null;
        }
    }

    private void updateOutputDenganHasil(BendaGeometri shape, String nama) {
        StringBuilder result = new StringBuilder();
        result.append("\n==============================\n");
        result.append("Hasil Perhitungan: ").append(nama).append("\n");
        result.append("==============================\n");

        try {
            for (Field f : shape.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                result.append(String.format("%-15s = %10.2f\n", f.getName(), f.get(shape)));
            }
        } catch (Exception ignored) {}

        if (shape instanceof BangunDatar) {
            BangunDatar bd = (BangunDatar) shape;
            result.append(String.format("%-15s = %10.2f\n", "Luas", bd.hitungLuas()));
            result.append(String.format("%-15s = %10.2f\n", "Keliling", bd.hitungKeliling()));
        }

        try {
            var volumeMethod = shape.getClass().getMethod("hitungVolume");
            var luasPermukaanMethod = shape.getClass().getMethod("hitungLuasPermukaan");

            double volume = (double) volumeMethod.invoke(shape);
            double luasPermukaan = (double) luasPermukaanMethod.invoke(shape);

            result.append(String.format("%-15s = %10.2f\n", "Volume", volume));
            result.append(String.format("%-15s = %10.2f\n", "Luas Permukaan", luasPermukaan));
        } catch (Exception ignored) {}

        result.append("==============================\n\n");
        updateOutput(result.toString());
    }

    private void prosesDenganThread() {
        bersihkanOutput();
        
        // Generate 33 bentuk acak (1 dari setiap jenis)
        shapes.clear();
        for (int i = 0; i < 33; i++) {
            shapes.add(generateRandomBendaGeometri(i + 1));
        }
        
        updateOutput("Memulai pemrosesan 33 bentuk geometri dengan Thread Pool:\n");
        for (BendaGeometri shape : shapes) {
            updateOutput("- " + shape.getClass().getSimpleName() + "\n");
        }
        updateOutput("\n");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (BendaGeometri shape : shapes) {
            executor.submit(() -> {
                String hasil = prosesBentuk(shape);
                SwingUtilities.invokeLater(() -> {
                    updateOutput(hasil);
                });
            });
        }

        executor.shutdown();
    }

    private String prosesBentuk(BendaGeometri shape) {
        StringBuilder hasil = new StringBuilder();
        String namaThread = Thread.currentThread().getName();
        String namaBentuk = shape.getClass().getSimpleName();

        try {
            hasil.append("Thread: ").append(namaThread).append(" - ").append(namaBentuk).append("\n");

            // Proses bangun datar
            if (shape instanceof BangunDatar) {
                BangunDatar bd = (BangunDatar) shape;
                double keliling = bd.hitungKeliling();
                double luas = bd.hitungLuas();
                hasil.append(String.format("2D -> Keliling: %.2f, Luas: %.2f%n", keliling, luas));
            }

            // Proses bangun ruang
            try {
                var methodVolume = shape.getClass().getMethod("hitungVolume");
                var methodLuasPermukaan = shape.getClass().getMethod("hitungLuasPermukaan");

                double volume = (double) methodVolume.invoke(shape);
                double luasPermukaan = (double) methodLuasPermukaan.invoke(shape);

                hasil.append(String.format("3D -> Volume: %.2f, Luas Permukaan: %.2f%n", 
                    volume, luasPermukaan));
            } catch (NoSuchMethodException ignored) {
                // Lewati jika tidak ada method 3D
            }

            hasil.append("---------------------------\n");
        } catch (Exception e) {
            hasil.append("Error memproses ").append(namaBentuk).append(": ")
                 .append(e.getMessage()).append("\n");
        }

        return hasil.toString();
    }

    private BendaGeometri generateRandomBendaGeometri(int choice) {
        Random random = new Random();
        switch (choice) {
            case 1: return new Segitiga(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 2: return new JajarGenjang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                          random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 3: return new BelahKetupat(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                          random.nextDouble() * 10 + 1);
            case 4: return new PersegiPanjang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 5: return new LayangLayang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                          random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 6: return new Persegi(random.nextDouble() * 10 + 1);
            case 7: return new Trapesium(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                       random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 8: return new Lingkaran(random.nextDouble() * 10 + 1);
            case 9: return new JuringLingkaran(random.nextDouble() * 10 + 1, random.nextDouble() * 359 + 1);
            case 10: return new TemberengLingkaran(random.nextDouble() * 10 + 1, random.nextDouble() * 359 + 1);
            case 11: return new Kubus(random.nextDouble() * 10 + 1);
            case 12: return new LimasPersegi(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 13: return new PrismaPersegi(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 14: return new LimasBelahKetupat(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 15: return new PrismaBelahKetupat(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                 random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 16: return new LimasLayangLayang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                random.nextDouble() * 10 + 1);
            case 17: return new PrismaLayangLayang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                 random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                 random.nextDouble() * 10 + 1);
            case 18: return new LimasSegitiga(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                            random.nextDouble() * 10 + 1);
            case 19: return new PrismaSegitiga(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                             random.nextDouble() * 10 + 1);
            case 20: return new LimasJajarGenjang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                random.nextDouble() * 10 + 1);
            case 21: return new PrismaJajarGenjang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                 random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                 random.nextDouble() * 10 + 1);
            case 22: return new LimasTrapesium(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                             random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                             random.nextDouble() * 10 + 1);
            case 23: return new PrismaTrapesium(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                              random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                              random.nextDouble() * 10 + 1);
            case 24: return new Balok(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                     random.nextDouble() * 10 + 1);
            case 25: return new LimasPersegiPanjang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                  random.nextDouble() * 10 + 1);
            case 26: return new PrismaPersegiPanjang(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                   random.nextDouble() * 10 + 1);
            case 27: return new Bola(random.nextDouble() * 10 + 1);
            case 28: return new CincinBola(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 29: return new JuringBola(random.nextDouble() * 10 + 1, random.nextDouble() * 359 + 1);
            case 30: return new TemberengBola(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 31: return new Kerucut(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            case 32: return new KerucutTerpancung(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1, 
                                                random.nextDouble() * 10 + 1);
            case 33: return new Tabung(random.nextDouble() * 10 + 1, random.nextDouble() * 10 + 1);
            default: throw new IllegalArgumentException("Pilihan bentuk geometri tidak valid: " + choice);
        }
    }

    private void bersihkanOutput() {
        outputArea.setText("");
    }

    private void updateOutput(String text) {
        outputArea.append(text);
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            GeometriGUI app = new GeometriGUI();
            app.setVisible(true);
            app.setLocationRelativeTo(null);
        });
    }
}