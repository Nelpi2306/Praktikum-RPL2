/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MahasiswaDao;
import Model.MahasiswaModel;
import java.util.List;
/**
 *
 * @author nelpi
 */
public class MahasiswaController {
    private MahasiswaDao mahasiswaDao;

    public MahasiswaController (MahasiswaDao mahasiswaDAO) {
        this.mahasiswaDao = mahasiswaDAO;
    }

    public void displayMahasiswaList(List<MahasiswaModel> mahasiswaList) {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa");
        } else {
            System.out.println("----------------------------------------");
            for (MahasiswaModel m : mahasiswaList) {
                System.out.println("ID \t\t: " + m.getId());
                System.out.println("NPM \t\t: " + m.getNpm());
                System.out.println("NAMA \t\t: " + m.getNama());
                System.out.println("SEMESTER \t: " + m.getSemester());
                System.out.println("IPK \t\t: " + m.getIpk());
                System.out.println("----------------------------------------");
            }
        }
    }
    
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void checkDatabaseConnection() {
        boolean isConnected = mahasiswaDao.checkConnection();
        if (isConnected) {
            displayMessage("Koneksi ke db berhasil");
        } else {
            displayMessage("Koneksi DB Gagal");
        }
    }

    // READ ALL (Menampilkan semua mahasiswa)
    public void displayAllMahasiswa() {
        List<MahasiswaModel> mahasiswaList = mahasiswaDao.getAllMahasiswa();
        displayMahasiswaList(mahasiswaList);
    }

    public void addMahasiswa(String npm, String nama, int semester, float ipk) {
        MahasiswaModel mahasiswaBaru = new MahasiswaModel(0, npm, nama, semester, ipk);
        System.out.println("Controller Data: " + npm + nama + semester + ipk);
        System.out.println(mahasiswaBaru);
        mahasiswaDao.addMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil ditambahkan!");
    }
    
    public void updateMahasiswa(int id, String npm, String nama, int semester, float ipk) {
        MahasiswaModel mahasiswaBaru = new MahasiswaModel(id, npm, nama, semester, ipk);
        mahasiswaDao.updateMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil diperbarui!");
    }
    
    public void deleteMahasiswa(int id) {
        mahasiswaDao.deleteMahasiswa(id);
        displayMessage("Mahasiswa Berhasil Dihapus!");
    }

    public void closeConnection() {
        mahasiswaDao.closeConnection();
    }  
}

