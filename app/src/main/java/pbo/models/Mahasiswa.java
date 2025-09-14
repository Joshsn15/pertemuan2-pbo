package pbo.models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

// class Jurusan {
//     String kode;
//     String nama;
//     ArrayList<MataKuliah> mataKuliahList;

//     public Jurusan(String kode, String nama) {
//         this.kode = kode;
//         this.nama = nama;
//         this.mataKuliahList = new ArrayList<>();
//     }
// }

// class Mahasiswa {
// String nim;
// String nama;
// Jurusan jurusan;
// Map<MataKuliah, String> indeksNilai;

// }


public class Mahasiswa {
    public String nim;
    public String nama; // dibikin public biar bisa diakses di App.java
    public Jurusan jurusan;
    Map<MataKuliah, String> indeksNilai;

    public Mahasiswa(String nim, String nama, Jurusan jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jurusan> daftarJurusan = new ArrayList<>();
    static ArrayList<MataKuliah> daftarMK = new ArrayList<>();
    // static ArrayList<Mahasiswa> daftarMhs = new ArrayList<>();

    // public static void main(String[] args) {
    //     while (true) {
    //         System.out.println("\n=== Menu  ===");
    //         System.out.println("1. Jurusan");
    //         System.out.println("2. Mata Kuliah");
    //         System.out.println("3. Mahasiswa");
    //         System.out.println("4. Beri Nilai Mahasiswa");
    //         System.out.println("5. hitung nilai Mahasiswa");
    //         System.out.println("6. Keluar");
    //         System.out.print("Pilih menu: ");
    //         int pilih = sc.nextInt();
    //         sc.nextLine();
    //         switch (pilih) {
    //             case 1:
    //                 System.out.println("\n=== Menu Jurusan ===");
    //                 System.out.println("1. Tambah Jurusan");
    //                 System.out.println("2. Lihat Jurusan");
    //                 System.out.println("3. Hapus Jurusan");
    //                 int pilihJurusan = sc.nextInt();
    //                 sc.nextLine();
    //                 switch (pilihJurusan) {
    //                     case 1:
    //                         addJurusan();
    //                         break;

    //                     case 2:
    //                         lihatJurusan();
    //                         break;
    //                     case 3:
    //                         hapusJurusan();
    //                         break;
    //                 }
    //                 break;
    //             case 2:
    //                 System.out.println("\n=== Menu Mata Kuliah ===");
    //                 System.out.println("1. Tambah MK");
    //                 System.out.println("2. Masukin MK ke Jurusan");
    //                 System.out.println("3. Hapus MK");
    //                 int pilihMK = sc.nextInt();
    //                 sc.nextLine();
    //                 switch (pilihMK) {
    //                     case 1:
    //                         addMK();
    //                         break;
    //                     case 2:
    //                         masukMKkeJurusan();
    //                         break;
    //                     case 3:
    //                         hapusMK();
    //                         break;
    //                 }
    //                 break;
    //             case 3:
    //                 System.out.println("\n=== Menu Mahasiswa ===");
    //                 System.out.println("1. Tambah Mahasiswa");
    //                 System.out.println("2. Lihat List Mahasiswa");
    //                 System.out.println("3. Lihat detail Mahasiswa bedasarkan NIM");
    //                 int pilihMhs = sc.nextInt();
    //                 sc.nextLine();

    //                 switch (pilihMhs) {
    //                     case 1:
    //                         addMhs();
    //                         break;
    //                     case 2:
    //                         listMhs();
    //                         break;
    //                     case 3:
    //                         liatMhsperNim();
    //                         break;
    //                 }
    //                 break;
    //             case 4:
    //                 nilaiMhs();
    //                 break;
    //             case 5:
    //                 hitungIP();
    //                 break;
    //             case 6:
    //                 return;
    //         }
    //     }

    // }

    // static void addJurusan() {
    //     System.out.println("Tambah Jurusan");
    //     System.out.print("Kode: ");
    //     String kodeBaru = sc.nextLine();
    //     System.out.print("Nama jurusan: ");
    //     String namaBaru = sc.nextLine();

    //     Jurusan newJurusan = new Jurusan(kodeBaru, namaBaru);
    //     daftarJurusan.add(newJurusan);
    //     System.out.println("Jurusan " + newJurusan.nama + " telah ditambahkan");
    // }

    // static void lihatJurusan() {
    //     System.out.println("Kode      nama");
    //     for (Jurusan jurusan : daftarJurusan) {
    //         System.out.println(jurusan.kode + "      " + jurusan.nama);
    //     }
    // }

    // static void hapusJurusan() {
    //     System.out.println("Kode Jurusan yang dihapus");
    //     String hapusKode = sc.nextLine();
    //     boolean found = false;
    //     for (int i = 0; i < daftarJurusan.size(); i++) {
    //         if (daftarJurusan.get(i).kode.equals(hapusKode)) {
    //             daftarJurusan.remove(i);
    //             found = true;
    //         }
    //     }
    //     if (!found) {
    //         System.out.println("Jurusan tidak ditemukan");
    //     }
    // }

    // static int findJurusan(String kodeJurusan) {
    //     for (int i = 0; i < daftarJurusan.size(); i++) {
    //         if (daftarJurusan.get(i).kode.equals(kodeJurusan)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // static int findMK(String kodeMK) {
    //     for (int i = 0; i < daftarMK.size(); i++) {
    //         if (daftarMK.get(i).kode.equals(kodeMK)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // static int findMhs(String Mhs) {
    //     for (int i = 0; i < daftarMhs.size(); i++) {
    //         if (daftarMhs.get(i).nim.equals(Mhs)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // static void addMK() {
    //     System.out.println("Tambah MK");
    //     System.out.print("Kode: ");
    //     String kodeBaru = sc.nextLine();
    //     System.out.println("Nama MK: ");
    //     String namaMK = sc.nextLine();
    //     System.out.println("SKS: ");
    //     int sks = sc.nextInt();
    //     sc.nextLine();
    //     MataKuliah mk = new MataKuliah(kodeBaru, namaMK, sks);
    //     daftarMK.add(mk);
    //     System.out.println("Matkul " + mk.nama + " Ditambah");
    // }

    // static void hapusMK() {
    //     System.out.println("Kode MK yang akan dihapus");
    //     String kodeMK = sc.nextLine();
    //     for (int i = 0; i < daftarMK.size(); i++) {
    //         if (daftarMK.get(i).kode.equals(kodeMK)) {
    //             daftarMK.remove(i);
    //             break;
    //         } else {
    //             continue;
    //         }
    //     }
    // }

    // static void masukMKkeJurusan() {
    //     System.out.println("Masukkan kode Jurusan");
    //     String kodeJurusan = sc.nextLine();
    //     int idxJurusan = findJurusan(kodeJurusan);

    //     if (idxJurusan == -1) {
    //         System.out.println("Jurusan Tidak ditemukan!");
    //         return;
    //     }

    //     System.out.println("Masukkan kode MK");
    //     String kodeMK = sc.nextLine();
    //     int idxMK = findMK(kodeMK);

    //     if (idxMK == -1) {
    //         System.out.println("Matkul Tidak ditemukan!");
    //         return;

    //     }
    //     Jurusan jurusan = daftarJurusan.get(idxJurusan);
    //     MataKuliah mk = daftarMK.get(idxMK);
    //     jurusan.mataKuliahList.add(mk);
    //     return;
    // }

    // static void addMhs() {
    //     System.out.println("NIM mahasiswa: ");
    //     String nim = sc.nextLine();
    //     System.out.println("Nama mahasiswa: ");
    //     String namaMhs = sc.nextLine();
    //     System.out.println("Kode Jurusan:");
    //     String Kodejurusan = sc.nextLine();
    //     int idxJurusan = findJurusan(Kodejurusan);
    //     if (idxJurusan == -1) {
    //         System.out.println("Jurusan tidak ditemukan");
    //         return;
    //     }
    //     Jurusan jurusan = daftarJurusan.get(idxJurusan);
    //     Mahasiswa mhs = new Mahasiswa(nim,namaMhs);
    //     mhs.indeksNilai = new HashMap<>();
    //     mhs.nim = nim;
    //     mhs.nama = namaMhs;
    //     mhs.jurusan = jurusan;
    //     daftarMhs.add(mhs);
    //     System.out.println("Mahasiswa " + namaMhs + " Sudah ditambahkan");

    // }

    // static void liatMhsperNim() {
    //     System.out.println("NIM yang dicari:");
    //     String nimMhs = sc.nextLine();
    //     for (int i = 0; i < daftarMhs.size(); i++) {
    //         if (daftarMhs.get(i).nim.equals(nimMhs)) {
    //             System.out.println("nim    nama   jurusan");
    //             System.out.println(
    //                     daftarMhs.get(i).nim + "   " + daftarMhs.get(i).nama + "   " + daftarMhs.get(i).jurusan.nama);

    //         }
    //     }
    // }

    // static void listMhs() {
    //     for (int i = 0; i < daftarMhs.size(); i++) {
    //         System.out.println("nim   nama   jurusan");
    //         System.out.println(
    //                 daftarMhs.get(i).nim + "   " + daftarMhs.get(i).nama + "   " + daftarMhs.get(i).jurusan.nama);
    //     }
    // }

    // static void nilaiMhs() {
    //     System.out.println("NIM mahasiswa:");
    //     String nim = sc.nextLine();
    //     int idxMhs = findMhs(nim);
    //     if (idxMhs == -1) {
    //         System.out.println("Mhs tidak ditemukan");
    //         return;
    //     }
    //     Mahasiswa mhs = daftarMhs.get(idxMhs);

    //     System.out.println("Kode MK: ");
    //     String kodeMhs = sc.nextLine();
    //     int idxMK = findMK(kodeMhs);
    //     if (idxMK == -1) {
    //         System.out.println("MK tidak ditemukan");
    //         return;
    //     }
    //     MataKuliah mk = daftarMK.get(idxMK);
    //     System.out.println("Nilai (A/B/C/D/E):");
    //     String nilai = sc.nextLine();

    //     mhs.indeksNilai.put(mk, nilai);
    //     System.out.println("Nilai " + nilai + " MK " + mk.nama + "Berhasil diinput ke mahasiswa " + mhs.nama);
    // }

    // static void hitungIP() {
    //     System.out.println("NIM mahasiswa:");
    //     String nim = sc.nextLine();
    //     int idxMhs = findMhs(nim);
    //     if (idxMhs == -1) {
    //         System.out.println("Mhs tidak ditemukan");
    //         return;
    //     }
    //     Mahasiswa mhs = daftarMhs.get(idxMhs);

    //     double totalNilai = 0;
    //     int totalSKS = 0;

    //     // Loop semua mata kuliah yang sudah ada nilainya
    //     for (Map.Entry<MataKuliah, String> entry : mhs.indeksNilai.entrySet()) {
    //         MataKuliah mk = entry.getKey();
    //         String nilaiHuruf = entry.getValue();

    //         int bobot = 0;
    //         switch (nilaiHuruf) {
    //             case "A":
    //                 bobot = 4;
    //                 break;
    //             case "B":
    //                 bobot = 3;
    //                 break;
    //             case "C":
    //                 bobot = 2;
    //                 break;
    //             case "D":
    //                 bobot = 1;
    //                 break;
    //             case "E":
    //                 bobot = 0;
    //                 break;
    //             default:
    //                 System.out.println("Nilai " + nilaiHuruf + " untuk MK " + mk.nama + " tidak valid.");
    //                 continue;
    //         }

    //         totalNilai += bobot * mk.sks;
    //         totalSKS += mk.sks;
    //     }

    //     if (totalSKS == 0) {
    //         System.out.println("Tidak ada SKS yang dihitung.");
    //         return;
    //     }

    //     double ip = totalNilai / totalSKS;
    //     System.out.println("IP Mahasiswa " + mhs.nama + " (" + mhs.nim + ") = " + ip);
    // }

}
