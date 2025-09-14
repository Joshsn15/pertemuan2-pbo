package pbo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pbo.database.Database;
import pbo.models.Jurusan;
import pbo.models.Mahasiswa;

public class MahasiswaRepository {
    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    // CREATE
    public static void addMahasiswa(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nim, nama,id_jurusan) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mhs.nim);
            preparedStatement.setString(2, mhs.nama);
            preparedStatement.setString(3, mhs.jurusan.kode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get jurusan
    public static Jurusan getJurusanByKode(String kode) {
        String sql = "SELECT kode, nama FROM jurusan WHERE kode = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("kode");
            preparedStatement.setString(1, "kode");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Jurusan(resultSet.getString("kode"), resultSet.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ ALL
    public static List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> listMahasiswa = new ArrayList<>();
        String sql = "SELECT nim, nama, kode, namajurusan FROM mahasiswa JOIN jurusan ON mahasiswa.id_jurusan = jurusan.kode";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                listMahasiswa.add(new Mahasiswa(resultSet.getString("nim"), resultSet.getString("nama"), new Jurusan(resultSet.getString("kode"), resultSet.getString("namajurusan"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMahasiswa;
    }

    // READ BY NIM
    public static void getMahasiswaByNim(String nim) {
        String sql = "SELECT nim, nama, kode, namajurusan FROM mahasiswa JOIN jurusan ON mahasiswa.id_jurusan = jurusan.kode WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Nama: " + resultSet.getString("nama") + ", NIM: " + resultSet.getString("nim") + ", Jurusan: " + resultSet.getString("namajurusan") + " (" + resultSet.getString("kode") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateMahasiswa(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nama = ? WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mhs.nama);
            preparedStatement.setString(2, mhs.nim);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteMahasiswa(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
