/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.MahasiswaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nelpi
 */
public class MahasiswaDao {
    //membuat object koneksi
    private Connection connection;

    public MahasiswaDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db", "root", "");
        } catch (Exception c) {
            c.printStackTrace();
        }
    }
    
    //fungsi untuk cek koneksi
    public boolean checkConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return true; //koneksi berhasil
            }
        } catch (SQLException c) {
            c.printStackTrace();
        }
        return false;
    }

public void addMahasiswa(MahasiswaModel mahasiswa) {
        String sql = "INSERT INTO mahasiswa (npm, nama, semester, ipk) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setInt(3, mahasiswa.getSemester());
            pstmt.setFloat(4, mahasiswa.getIpk());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MahasiswaModel> getAllMahasiswa() {
        List<MahasiswaModel> mahasiswaList = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                mahasiswaList.add(new MahasiswaModel(
                    rs.getInt("id"),
                    rs.getString("npm"),
                    rs.getString("nama"),
                    rs.getInt("semester"),
                    rs.getFloat("ipk")
                ));
            }
        } catch (SQLException c) {
            c.printStackTrace();
        }
        return mahasiswaList;
    }
    public void updateMahasiswa(MahasiswaModel mahasiswa) {
        String sql = "UPDATE mahasiswa SET npm = ?, nama = ?, semester = ?, ipk = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setInt(3, mahasiswa.getSemester());
            pstmt.setFloat(4, mahasiswa.getIpk());
            pstmt.setInt(5, mahasiswa.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMahasiswa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void closeConnection() {
        try {
            // Hanya tutup koneksi jika objek 'connection' tidak null
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            // Tangani jika terjadi error saat mencoba menutup koneksi
            e.printStackTrace();
        }
    }
}

