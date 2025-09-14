package pbo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import pbo.repository.MahasiswaRepository;
import pbo.repository.mataKuliahRepository;
import pbo.models.Mahasiswa;
import pbo.database.Database;
import pbo.models.Jurusan;
import pbo.models.MataKuliah;

public class App {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Boolean status = true;
            while (status) {
                System.out.println("Menu:");
                System.out.println("1. Mahasiswa");
                System.out.println("2. Mata Kuliah");
                System.out.println("3. Indeks nilai");
                System.out.println("4. Exit");
                System.out.print("Pilih menu (1-4): ");
                int mainChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (mainChoice) {
                    case 1:
                        System.out.println("1. Tambah Mahasiswa");
                        System.out.println("2. Cari Mahasiswa by NIM");
                        System.out.println("3. Tampilkan Semua Mahasiswa");
                        System.out.println("4. Update Mahasiswa");
                        System.out.println("5. Delete Mahasiswa");
                        System.out.println("6. Exit");
                        System.out.print("Pilih opsi (1-6): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (choice) {
                            case 1:
                                System.out.print("Masukkan NIM: ");
                                String nim = scanner.nextLine();

                                System.out.print("Masukkan Nama: ");
                                String nama = scanner.nextLine();

                                System.out.print("Masukkan Jurusan: ");
                                String jurusan = scanner.nextLine();

                                System.out.print("Masukkan Kode Jurusan: ");
                                String kodeJur = scanner.nextLine();
                                Jurusan jur = new Jurusan(kodeJur, jurusan);

                                Mahasiswa mhs = new Mahasiswa(nim, nama, jur);
                                MahasiswaRepository.addMahasiswa(mhs);
                                break;
                            case 2:
                                System.out.print("Masukkan NIM yang dicari: ");
                                String searchNim = scanner.nextLine();
                                MahasiswaRepository.getMahasiswaByNim(searchNim);
                                break;
                            case 3:
                                List<Mahasiswa> allMahasiswa = MahasiswaRepository.getAllMahasiswa();
                                System.out.println("\n Daftar Mahasiswa:");
                                for (Mahasiswa m : allMahasiswa) {
                                    System.out.println(m.nim + " - " + m.nama + " - " + " (" + m.jurusan.kode + ")");
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("NIM yang akan diupdate: ");
                                String nimSearch = scanner.nextLine();

                                System.out.println("Nama baru: ");
                                String updateNama = scanner.nextLine();
                                Mahasiswa updateMhs = new Mahasiswa(nimSearch, updateNama, null);
                                MahasiswaRepository.updateMahasiswa(updateMhs);
                                break;
                            case 5:
                                System.out.println("NIM yang akan dihapus: ");
                                String nimDelete = scanner.nextLine();
                                MahasiswaRepository.deleteMahasiswa(nimDelete);
                                break;
                            case 6:
                                System.out.println("exit");
                                status = false;
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1.Tambah Mata Kuliah");
                        System.out.println("2.Tambah Mata Kuliah ke Jurusan");
                        System.out.println("3.Hapus Mata Kuliah");
                        System.out.println("4.Tampilkan Semua Mata Kuliah");
                        System.out.println("5.Exit");
                        System.out.print("Pilih opsi (1-5): ");
                        int mkChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (mkChoice) {
                            case 1:
                                System.out.print("Masukkan Kode Mata Kuliah: ");
                                String kodeMK = scanner.nextLine();
                                System.out.print("Masukkan Nama Mata Kuliah: ");
                                String namaMK = scanner.nextLine();
                                System.out.print("Masukkan SKS: ");
                                int sks = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                MataKuliah mk = new MataKuliah(kodeMK, namaMK, sks);
                                mataKuliahRepository.addMataKuliah(mk);
                                break;
                            case 2:
                                System.out.print("Masukkan Kode Mata Kuliah: ");
                                String kodeMatkul = scanner.nextLine();
                                System.out.print("Masukkan Kode Jurusan: ");
                                String kodeJurusan = scanner.nextLine();
                                mataKuliahRepository.addMataKuliahToJurusan(kodeMatkul, kodeJurusan);
                                break;
                            case 3:
                                System.out.print("Masukkan Kode Mata Kuliah yang akan dihapus: ");
                                String kodeHapus = scanner.nextLine();
                                mataKuliahRepository deleteMK = new mataKuliahRepository();
                                try {
                                    deleteMK.deleteMataKuliah(kodeHapus);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                mataKuliahRepository getMK = new mataKuliahRepository();
                                List<MataKuliah> allMK = getMK.getAllMataKuliah();
                                System.out.println("\n Daftar Mata Kuliah:");
                                for (MataKuliah m : allMK) {
                                    System.out.println(m.kode + " - " + m.nama + " - " + m.sks + " SKS");
                                }
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("exit");
                                status = false;
                                System.exit(0);
                            default:
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Indeks Nilai");
                        System.out.println("1. Tambah Indeks Nilai");
                        System.out.println("2. Lihat Indeks Nilai Mahasiswa");
                        System.out.println("3. Exit");
                        System.out.print("Pilih opsi (1-3): ");
                        int indeksChoice = scanner.nextInt();
                        switch (indeksChoice) {
                            case 1:
                                System.out.println("Indeks nilai");
                                System.out.print("Masukkan Kode Mata Kuliah: ");
                                String kode = scanner.nextLine();
                                System.out.print("Masukkan NIM Mahasiswa: ");
                                String nimMhs = scanner.nextLine();
                                System.out.print("Masukkan Nilai (0-100): ");
                                int nilai = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                String sql = "INSERT INTO indeksnilai (kodeMK, nim, nilai) VALUES (?, ?, ?)";
                                try {
                                    PreparedStatement pstmt = Database.connect().prepareStatement(sql);
                                    pstmt.setString(1, kode);
                                    pstmt.setString(2, nimMhs);
                                    pstmt.setInt(3, nilai);
                                    pstmt.executeUpdate();
                                    System.out.println("Indeks nilai berhasil ditambahkan.");
                                } catch (SQLException e) {
                                    System.out.println("Gagal menambahkan indeks nilai: " + e.getMessage());
                                    e.printStackTrace();
                                }
                                break;
                            case 2:

                                System.out.print("Masukkan NIM Mahasiswa: ");
                                String nimCari = scanner.nextLine();
                                scanner.nextLine();
                                String query = "SELECT matakuliah.namaMK, indeksnilai.nilai FROM indeksnilai JOIN matakuliah ON indeksnilai.kodeMK = matakuliah.kode WHERE indeksnilai.nim = ?";
                                try {
                                    PreparedStatement pstmt = Database.connect().prepareStatement(query);
                                    pstmt.setString(1, nimCari);
                                    var rs = pstmt.executeQuery();
                                    System.out.println("Indeks Nilai Mahasiswa dengan NIM " + nimCari + ":");
                                    while (rs.next()) {
                                        String namaMatkul = rs.getString("namaMK");
                                        int nilaiMatkul = rs.getInt("nilai");
                                        System.out.println(namaMatkul + ": " + nilaiMatkul);
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Gagal mengambil indeks nilai: " + e.getMessage());
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("exit");
                                status = false;
                                System.exit(0);
                                break;
                            default:
                                break;
                        }

                        break;

                }

            }
        }
    }
}