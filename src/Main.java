import java.util.ArrayList;
import java.util.Scanner;

public class Main {

static <T extends Buku> void bubbleSort(ArrayList<T> data) {

    for (int i = 0; i < data.size() - 1; i++) {
        for (int j = 0; j < data.size() - 1 - i; j++) {

            if (data.get(j).getNoSeri() > data.get(j + 1).getNoSeri()) {

                T temp = data.get(j);
                data.set(j, data.get(j + 1));
                data.set(j + 1, temp);
            }
        }
    }
}

static <T extends Buku> int binarySearch(ArrayList<T> data, int target) {

    int left = 0;
    int right = data.size() - 1;

    while (left <= right) {

        int mid = (left + right) / 2;

        if (data.get(mid).getNoSeri() == target) {
            return mid;
        }

        else if (data.get(mid).getNoSeri() < target) {
            left = mid + 1;
        }

        else {
            right = mid - 1;
        }
    }

    return -1;
}

static boolean isNoSeriExist(int noSeri, ArrayList<Buku> semuaBuku) {
    for (Buku b : semuaBuku) {
        if (b.getNoSeri() == noSeri) return true;
    }
    return false;
}

    public static void main(String[] args) {

        ArrayList<Buku> semuaBuku = new ArrayList<>();

        semuaBuku.add(new Buku("Pemrograman Java Dasar", "Eko Kurniawan", 12345, 2019));
        semuaBuku.add(new Buku("Struktur Data dan Algoritma", "Rinaldi Munir", 23456, 2015));
        semuaBuku.add(new Buku("Basis Data Modern", "Abdul Kadir", 34567, 2021));

        semuaBuku.add(new Komik("Latna Saga", "Soon-Q", 987, 2012, "Isekai", 20, "Korea", "Khit Studio"));
        semuaBuku.add(new Komik("One Piece", "Eichiro Oda", 123, 2006, "Pirate", 2000, "Jepang", "Who know"));
        semuaBuku.add(new Komik("Isekai Smartphone", "Enda", 1, 2012, "Peak Isekai", 10, "Jepang", "Deen"));

        semuaBuku.add(new Novel("TBATE", "Yuki Tabata", 12123, 2012, "Fantasy", 450));
        semuaBuku.add(new Novel("Omniscien Reader View Point", "Sing Shong", 133, 2010, "Peak Fantasy", 100));

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Urutkan berdasarkan No Seri");
            System.out.println("3. Cari berdasarkan No Seri");
            System.out.println("4. Pinjam / Kembalikan Buku");
            System.out.println("5. Lihat Buku yang Dipinjam"); 
            System.out.println("6. Tambahkan buku");
            System.out.println("7. Keluar");
            System.out.print("Masukkan pilihan: ");

            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    System.out.println("\n-- Buku --");
                    for (Buku b : semuaBuku) {
                        if (b.getClass() == Buku.class) {
                            System.out.println("-------------");
                            b.tampilkanInfo();   
                        }
                    }
                    System.out.println("\n-- Novel --");
                    for (Buku n : semuaBuku) {
                        if (n instanceof Novel && !(n instanceof Komik)) {
                            System.out.println("-------------");
                            n.tampilkanInfo();   
                        }                        
                    }
                    System.out.println("\n-- Komik --");
                    for (Buku k : semuaBuku) {
                        if (k instanceof Komik) {
                            System.out.println("-------------");
                            k.tampilkanInfo();   
                        }                        
                    }

                    break;

                case 2:

                    bubbleSort(semuaBuku);

                            for (Buku b : semuaBuku) {
                                System.out.println("-------------");
                                b.tampilkanInfo();
                            }

                    break;

                case 3:

                    System.out.print("Masukkan No Seri: ");
                    int cari = input.nextInt();

                    bubbleSort(semuaBuku);
                    int hasil = binarySearch(semuaBuku, cari);

                    if (hasil != -1) {
                        semuaBuku.get(hasil).tampilkanInfo();
                    } else {
                        System.out.println("Buku tidak ditemukan");
                    }

                    break;

                    case 4:

                        System.out.println("1. Pinjam Buku");
                        System.out.println("2. Kembalikan Buku");
                        System.out.print("Pilih: ");
                        int aksi = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan No Seri: ");
                        int no = input.nextInt();
                        input.nextLine();

                        boolean ditemukan = false;

                        for (Buku b : semuaBuku) {
                            if (b.getNoSeri() == no) {

                                if (aksi == 1) {
                                    System.out.print("Masukkan catatan pustakawan: ");
                                    String ket = input.nextLine();

                                    b.pinjamBuku(ket);
                                }

                                else if (aksi == 2) {
                                    b.kembalikanBuku();
                                }

                                ditemukan = true;
                            }
                        }
                        if (!ditemukan) {
                            System.out.println("Buku tidak ditemukan!");
                        }
                        break;

                case 5: 

                    System.out.println("=== DAFTAR BUKU YANG DIPINJAM ===");

                    boolean adaDipinjam = false;

                    for (Buku b : semuaBuku) {
                            if (b.getIsDipinjam()) {
                            System.out.println("-------------");
                            b.tampilkanInfo();
                            adaDipinjam = true;
                            }
                    }

                    if (!adaDipinjam) {
                        System.out.println("Tidak ada buku yang sedang dipinjam.");
                    }

                    break;

                case 6:
                    System.out.println("Apa jenis buku yang akan ditambah? ");
                    System.out.println("1. Buku");
                    System.out.println("2. Novel");
                    System.out.println("3. Komik");
                    System.out.print("Pilih: ");
                    int tambahJenisBuku = input.nextInt();
                    input.nextLine(); 

                    System.out.println("judul :");
                    String judul = input.nextLine();

                    System.out.println("Penulis :");
                    String penulis = input.nextLine();

                    System.out.println("Nomor Seri :");
                    int noseri = input.nextInt();

                    System.out.println("Tahun Terbit : ");
                    int tahunterbit = input.nextInt();

                    switch (tambahJenisBuku) {

                        case 1:
                            Buku bukuBaru = new Buku(judul, penulis, 0, tahunterbit);

                            if (bukuBaru.setNoSeri(noseri, semuaBuku)) {
                                semuaBuku.add(bukuBaru);
                                System.out.println(" Buku berhasil ditambahkan!");
                            }
                            break;

                        case 2:
                            input.nextLine(); 

                            System.out.println("Genre :");
                            String genre = input.nextLine();

                            System.out.println("Volume :");
                            int volume = input.nextInt();

                            Novel novelBaru = new Novel(judul, penulis, 0, tahunterbit, genre, volume);

                            if (novelBaru.setNoSeri(noseri, semuaBuku)) {
                                semuaBuku.add(novelBaru);
                                System.out.println(" Novel berhasil ditambahkan!");
                            }
                            break;

                        case 3:
                            input.nextLine(); 

                            System.out.println("Genre :");
                            String genreK = input.nextLine();

                            System.out.println("Volume :");
                            int volumeK = input.nextInt();
                            input.nextLine();

                            System.out.println("Negara Asal :");
                            String negaraAsal = input.nextLine();

                            System.out.println("Ilustrator :");
                            String ilustrator = input.nextLine();

                            Komik komikBaru = new Komik(judul, penulis, 0, tahunterbit, genreK, volumeK, negaraAsal, ilustrator);

                            if (komikBaru.setNoSeri(noseri, semuaBuku)) {
                                semuaBuku.add(komikBaru);
                                System.out.println("Komik berhasil ditambahkan!");
                            }
                            break;

                        default:
                            System.out.println("Jenis tidak valid");
                            break;
                    }
                break;
                
                case 7:

                    System.out.println("Terima kasih!");
                    System.out.println("(c) Maksima Insan A / 438");

                    break;

                default:
                    System.out.println("Pilihan tidak tersedia");
            }

        } while (pilihan != 7);

        input.close();
    }
}