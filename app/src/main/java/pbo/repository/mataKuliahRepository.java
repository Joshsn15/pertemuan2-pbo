package pbo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pbo.database.Database;
import pbo.models.MataKuliah;

public class mataKuliahRepository {
    private static Connection conn = Database.connect();

    public static void addMataKuliah(MataKuliah mk) {
        String sql = "INSERT INTO matakuliah(kode , namaMK , sks) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mk.kode);
            preparedStatement.setString(2, mk.nama);
            preparedStatement.setInt(3, mk.sks);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<MataKuliah> getAllMataKuliah(){
        List<MataKuliah> listMataKuliah = new ArrayList<>();
        String sql = "SELECT kode, namaMK, sks FROM matakuliah";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                listMataKuliah.add(new MataKuliah(resultSet.getString("kode"), resultSet.getString("namaMK"), resultSet.getInt("sks")));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return listMataKuliah;
    }
    public static void addMataKuliahToJurusan(String kodeMK, String kodeJurusan){
        String sql = "INSERT INTO jurusan_matakuliah (kodeMK, kodeJurusan) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kodeMK);
            preparedStatement.setString(2, kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteMataKuliah(String kode) throws SQLException {
        String sql = "DELETE FROM mataKuliah WHERE kode = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);
        ps.executeUpdate();
    }
}
