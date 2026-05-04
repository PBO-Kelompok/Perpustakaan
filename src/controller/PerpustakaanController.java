package controller;
import model.Buku;
import model.Sorting;
import model.Searching;
import view.PerpustakaanView;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PerpustakaanController {
    private ArrayList<Buku> daftarBuku;
    private PerpustakaanView view;

    public PerpustakaanController(ArrayList<Buku> daftarBuku, PerpustakaanView view) {
        this.daftarBuku = daftarBuku;
        this.view = view;

        this.view.btnTampil.addActionListener(e -> tampilkanBuku(daftarBuku));
        this.view.btnSort.addActionListener(e -> sortingBuku());
        this.view.btnSearch.addActionListener(e -> searchBuku());

    }

    private void tampilkanBuku(ArrayList<Buku> data) {
        view.area.setText("");  
        for (Buku b : data) {
            view.area.append(
                b.getNoSeri() + " - " +
                b.getJudul() + " - " +
                b.getPenulis() + " (" +
                b.getTahunTerbit() + ")"+
                b.getStatus()+ "\n"
            );
        }
    }
    private void sortingBuku(){
        ArrayList<Buku> temp = new ArrayList<>(daftarBuku);
        Sorting.sort(temp);
            tampilkanBuku(temp);
        }

    private void searchBuku(){
        ArrayList<Buku> temp = new ArrayList<>(daftarBuku);
        Sorting.sort(temp);
        String input = JOptionPane.showInputDialog("Masukkan No Seri:");
        try {
            int key = Integer.parseInt(input); 
            int hasilSearch = Searching.search(temp,key);
                if (hasilSearch != -1) {
                    Buku b = temp.get(hasilSearch);
                        view.area.append(
                        b.getNoSeri() + " - " +
                        b.getJudul() + " - " +
                        b.getPenulis() + " (" +
                        b.getTahunTerbit() + ")"+
                        b.getStatus()+ "\n"
                    );
                } 
                else {
                    view.area.append("Buku tidak ditemukan");
                }
        } catch (NumberFormatException e) {
            view.area.setText("Input harus berupa angka!");
        }
        
    }
    
}