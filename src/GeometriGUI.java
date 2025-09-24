import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import projek_pbo.*; // Import all your geometry classes

public class GeometriGUI {

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            // Create the main application window
            JFrame frame = new JFrame("Geometric Shapes Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // Center the window

            // Create the tabbed pane
            JTabbedPane tabbedPane = new JTabbedPane();

            // --- 1. Quadrilateral Shapes Tab ---
            JPanel quadPanel = new JPanel(new GridLayout(3, 2, 10, 10));
            quadPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            quadPanel.add(createPersegiPanel());
            quadPanel.add(createPersegiPanjangPanel());
            quadPanel.add(createJajarGenjangPanel());
            quadPanel.add(createBelahKetupatPanel());
            quadPanel.add(createLayangLayangPanel());
            quadPanel.add(createTrapesiumPanel());
            tabbedPane.addTab("Quadrilateral Shapes", quadPanel);

            // --- 2. Triangle & Derivatives Tab ---
            JPanel trianglePanel = new JPanel(new GridLayout(2, 2, 10, 10));
            trianglePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            trianglePanel.add(createSegitigaPanel());
            trianglePanel.add(createPrismaSegitigaPanel());
            trianglePanel.add(createLimasSegitigaPanel());
            tabbedPane.addTab("Triangle & Derivatives", trianglePanel);
            
            // --- 3. Circle & Derivatives Tab ---
            JPanel circlePanel = new JPanel(new GridLayout(3, 2, 10, 10));
            circlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            circlePanel.add(createLingkaranPanel());
            circlePanel.add(createJuringLingkaranPanel());
            circlePanel.add(createTemberengLingkaranPanel());
            circlePanel.add(createTabungPanel());
            circlePanel.add(createKerucutPanel());
            circlePanel.add(createBolaPanel());
            tabbedPane.addTab("Circle & Derivatives", circlePanel);
            
            // --- 4. Other 3D Shapes ---
            JPanel other3dPanel = new JPanel(new GridLayout(2,2,10,10));
            other3dPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            other3dPanel.add(createKubusPanel());
            other3dPanel.add(createBalokPanel());
            tabbedPane.addTab("Other 3D Shapes", other3dPanel);


            // Add the tabbed pane to the frame
            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
    
    // Method to create a standardized panel for each shape
    private static JPanel createShapePanel(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new GridBagLayout());
        return panel;
    }

    // --- Panel Creation Methods for Each Shape ---

    private static JPanel createPersegiPanel() {
        JPanel panel = createShapePanel("Square");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField sisiField = new JTextField(10);
        JLabel luasLabel = new JLabel("Area: -");
        JLabel kelilingLabel = new JLabel("Perimeter: -");
        JButton calcButton = new JButton("Calculate");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Side:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(sisiField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(calcButton, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(luasLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(kelilingLabel, gbc);
        
        calcButton.addActionListener(e -> {
            try {
                double sisi = Double.parseDouble(sisiField.getText());
                Persegi p = new Persegi(sisi);
                luasLabel.setText(String.format("Area: %.2f", p.hitungLuas()));
                kelilingLabel.setText(String.format("Perimeter: %.2f", p.hitungKeliling()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }
    
    private static JPanel createPersegiPanjangPanel() {
        JPanel panel = createShapePanel("Rectangle");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField panjangField = new JTextField(10);
        JTextField lebarField = new JTextField(10);
        JLabel luasLabel = new JLabel("Area: -");
        JLabel kelilingLabel = new JLabel("Perimeter: -");
        JButton calcButton = new JButton("Calculate");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Length:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(panjangField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Width:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(lebarField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(calcButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; panel.add(luasLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(kelilingLabel, gbc);

        calcButton.addActionListener(e -> {
            try {
                double panjang = Double.parseDouble(panjangField.getText());
                double lebar = Double.parseDouble(lebarField.getText());
                PersegiPanjang pp = new PersegiPanjang(panjang, lebar);
                luasLabel.setText(String.format("Area: %.2f", pp.hitungLuas()));
                kelilingLabel.setText(String.format("Perimeter: %.2f", pp.hitungKeliling()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }

    private static JPanel createSegitigaPanel() {
        JPanel panel = createShapePanel("Triangle");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField alasField = new JTextField(10);
        JTextField tinggiField = new JTextField(10);
        JLabel luasLabel = new JLabel("Area: -");
        JLabel kelilingLabel = new JLabel("Perimeter (assuming equilateral): -");
        JButton calcButton = new JButton("Calculate");
        
        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Base:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(alasField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Height:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(tinggiField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(calcButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(luasLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; panel.add(kelilingLabel, gbc);

        calcButton.addActionListener(e -> {
            try {
                double alas = Double.parseDouble(alasField.getText());
                double tinggi = Double.parseDouble(tinggiField.getText());
                Segitiga s = new Segitiga(alas, tinggi);
                luasLabel.setText(String.format("Area: %.2f", s.hitungLuas()));
                kelilingLabel.setText(String.format("Perimeter: %.2f", s.hitungKeliling()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }
    
    private static JPanel createLingkaranPanel() {
        JPanel panel = createShapePanel("Circle");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField jariField = new JTextField(10);
        JLabel luasLabel = new JLabel("Area: -");
        JLabel kelilingLabel = new JLabel("Circumference: -");
        JButton calcButton = new JButton("Calculate");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Radius:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(jariField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth=2; panel.add(calcButton, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth=1; panel.add(luasLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(kelilingLabel, gbc);
        
        calcButton.addActionListener(e -> {
            try {
                double jari = Double.parseDouble(jariField.getText());
                Lingkaran l = new Lingkaran(jari);
                luasLabel.setText(String.format("Area: %.2f", l.hitungLuas()));
                kelilingLabel.setText(String.format("Circumference: %.2f", l.hitungKeliling()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }
    
    private static JPanel createKubusPanel() {
        JPanel panel = createShapePanel("Cube");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField rusukField = new JTextField(10);
        JLabel volumeLabel = new JLabel("Volume: -");
        JLabel surfaceAreaLabel = new JLabel("Surface Area: -");
        JButton calcButton = new JButton("Calculate");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Side:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(rusukField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; panel.add(calcButton, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; panel.add(volumeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(surfaceAreaLabel, gbc);

        calcButton.addActionListener(e -> {
            try {
                double rusuk = Double.parseDouble(rusukField.getText());
                Kubus k = new Kubus(rusuk);
                volumeLabel.setText(String.format("Volume: %.2f", k.hitungVolume()));
                surfaceAreaLabel.setText(String.format("Surface Area: %.2f", k.hitungLuasPermukaan()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }

    private static JPanel createBalokPanel() {
        JPanel panel = createShapePanel("Cuboid (Balok)");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField panjangField = new JTextField(10);
        JTextField lebarField = new JTextField(10);
        JTextField tinggiField = new JTextField(10);
        JLabel volumeLabel = new JLabel("Volume: -");
        JLabel surfaceAreaLabel = new JLabel("Surface Area: -");
        JButton calcButton = new JButton("Calculate");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Length:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(panjangField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Width:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(lebarField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Height:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(tinggiField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(calcButton, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1; panel.add(volumeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(surfaceAreaLabel, gbc);

        calcButton.addActionListener(e -> {
            try {
                double panjang = Double.parseDouble(panjangField.getText());
                double lebar = Double.parseDouble(lebarField.getText());
                double tinggi = Double.parseDouble(tinggiField.getText());
                Balok b = new Balok(panjang, lebar, tinggi);
                volumeLabel.setText(String.format("Volume: %.2f", b.hitungVolume()));
                surfaceAreaLabel.setText(String.format("Surface Area: %.2f", b.hitungLuasPermukaan()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }
    
    // Add placeholders for other shape panels
    private static JPanel createJajarGenjangPanel() { return createShapePanel("Parallelogram (Jajar Genjang)"); }
    private static JPanel createBelahKetupatPanel() { return createShapePanel("Rhombus (Belah Ketupat)"); }
    private static JPanel createLayangLayangPanel() { return createShapePanel("Kite (Layang-Layang)"); }
    private static JPanel createTrapesiumPanel() { return createShapePanel("Trapezoid (Trapesium)"); }
    private static JPanel createPrismaSegitigaPanel() { return createShapePanel("Triangular Prism (Prisma Segitiga)"); }
    private static JPanel createLimasSegitigaPanel() { return createShapePanel("Triangular Pyramid (Limas Segitiga)"); }
    private static JPanel createJuringLingkaranPanel() { return createShapePanel("Circular Sector (Juring Lingkaran)"); }
    private static JPanel createTemberengLingkaranPanel() { return createShapePanel("Circular Segment (Tembereng Lingkaran)"); }
    private static JPanel createTabungPanel() { return createShapePanel("Cylinder (Tabung)"); }
    private static JPanel createKerucutPanel() { return createShapePanel("Cone (Kerucut)"); }
    private static JPanel createBolaPanel() { return createShapePanel("Sphere (Bola)"); }

}