import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Siswa> daftarSiswa = new ArrayList<>();
        ArrayList<Kandidat> daftarKandidat = new ArrayList<>();

        daftarKandidat.add(new Kandidat("Ahmad"));
        daftarKandidat.add(new Kandidat("Budi"));
        daftarKandidat.add(new Kandidat("Citra"));

        daftarSiswa.add(new Siswa("Andi", "001"));
        daftarSiswa.add(new Siswa("Rina", "002"));
        daftarSiswa.add(new Siswa("Doni", "003"));

        int pilihan;

        do {
            System.out.println("\n=== SISTEM VOTING OSIS ===");
            System.out.println("1. Voting");
            System.out.println("2. Lihat Hasil");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIS: ");
                    String nis = input.nextLine();

                    Siswa siswaDitemukan = null;
                    for (Siswa s : daftarSiswa) {
                        if (s.getNis().equals(nis)) {
                            siswaDitemukan = s;
                            break;
                        }
                    }

                    if (siswaDitemukan == null) {
                        System.out.println("Siswa tidak ditemukan!");
                    } else if (siswaDitemukan.isSudahVoting()) {
                        System.out.println("Anda sudah melakukan voting!");
                    } else {
                        System.out.println("Daftar Kandidat:");
                        for (int i = 0; i < daftarKandidat.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarKandidat.get(i).getNama());
                        }

                        System.out.print("Pilih kandidat: ");
                        int pilihKandidat = input.nextInt();

                        if (pilihKandidat > 0 && pilihKandidat <= daftarKandidat.size()) {
                            daftarKandidat.get(pilihKandidat - 1).tambahSuara();
                            siswaDitemukan.setSudahVoting(true);
                            System.out.println("Voting berhasil!");
                        } else {
                            System.out.println("Pilihan tidak valid!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n=== HASIL VOTING ===");
                    for (Kandidat k : daftarKandidat) {
                        System.out.println(k.getNama() + " : " + k.getJumlahSuara() + " suara");
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilihan != 3);

        input.close();
    }
}