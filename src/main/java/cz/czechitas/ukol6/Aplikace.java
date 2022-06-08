package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel kraliciLabel;
    private JLabel husyLabel;

    private JLabel pocetHlavLabel;
    private JLabel pocetNohLabel;
    private JTextField husyField;
    private JTextField kraliciField;

    private JTextField pocetNohField;
    private JTextField pocetHlavField;


    private JButton vypocitejButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        kraliciField = new JTextField();
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);

        husyField = new JTextField();
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel = new JLabel("Husy");
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        add(createButtonBar(),"span");

        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohField = new JTextField();
        pocetNohField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohField.setEditable(false);
        pocetHlavField.isEnabled();
        pocetNohLabel = new JLabel("Počet noh");
        pocetNohLabel.setLabelFor(pocetNohField);
        add(pocetNohLabel);
        add(pocetNohField);

        pack();

        vypocitejButton.addActionListener(this::handleVypocitej);

        }
    private JPanel createButtonBar(){
        vypocitejButton = new JButton("Vypočítej");
        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitejButton);
        return buttonBar;

}
    private void handleVypocitej (ActionEvent actionEvent){
        System.out.println("Počítám..");
        String kraliciHlavyText = kraliciField.getText();
        int kraliciHlavyCislo = Integer.parseInt(kraliciHlavyText);
        String husyHlavyText = husyField.getText();
        int husyHlavyCislo = Integer.parseInt(husyHlavyText);
        int pocetHlavCelkem = (kraliciHlavyCislo+husyHlavyCislo);
        String pocetHlavCelkemtext = Integer.toString(pocetHlavCelkem);
        System.out.println("Počet hlav:"+ pocetHlavCelkemtext);
        pocetHlavField.setText(pocetHlavCelkemtext);

        String kraliciNohytext = kraliciField.getText();
        int kraliciNohyCislo = Integer.parseInt(kraliciNohytext);
        String husyNohyText = husyField.getText();
        int husynohyCislo = Integer.parseInt(husyNohyText);
        int pocetNohCelkem = (kraliciNohyCislo*4) +(husynohyCislo*2);
        String pocetNohCelkemtext = Integer.toString(pocetNohCelkem);
        System.out.println("Počet noh:"+ pocetNohCelkemtext);
        pocetNohField.setText(pocetNohCelkemtext);

   }
}