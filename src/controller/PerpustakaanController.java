package controller;

import model.Buku;
import view.PerpustakaanView;
import java.util.ArrayList;

public class PerpustakaanController {
    private ArrayList<Buku> daftarBuku;
    private PerpustakaanView view;

    public PerpustakaanController(ArrayList<Buku> daftarBuku, PerpustakaanView view) {
        this.daftarBuku = daftarBuku;
        this.view = view;

        this.view.btnTampil.addActionListener(e -> tampilkanBuku());
    }

    private void tampilkanBuku() {
        view.area.setText("");  
        for (Buku b : daftarBuku) {
            view.area.append(
                b.getNoSeri() + " - " +
                b.getJudul() + " - " +
                b.getPenulis() + " (" +
                b.getTahunTerbit() + ")\n"
            );
        }
    }
    
}