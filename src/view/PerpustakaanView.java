package view;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;

public class PerpustakaanView extends JFrame {
    public JTextArea area = new JTextArea();
    public JTextField txtCari = new JTextField();
    public JButton btnTampil = new JButton("Tampilkan");
    public JButton btnSort = new JButton("Sort");   
    public JButton btnSearch = new JButton("Search");   

    public PerpustakaanView() {
        setTitle("Sistem Perpustakaan GUI");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,1,5,5));

        panel.add(btnTampil);
        panel.add(btnSort);
        panel.add(btnSearch);

        add(panel, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
    }
}