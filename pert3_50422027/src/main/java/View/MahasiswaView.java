/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.MahasiswaController;
import Model.MahasiswaDao;
import java.util.Scanner;

/**
 *
 * @author nelpi
 */
public class MahasiswaView {
        public static void main(String[] args) {
        MahasiswaDao mahasiswaDao = new MahasiswaDao();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDao);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Semua Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Cek Koneksi Database");
            System.out.println("6. Keluar");
            System.out.print("PILIH OPSI: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    mahasiswaController.displayAllMahasiswa();
                    break;

                case 2:
                    // tambah mhs
                    System.out.print("Masukkan NPM: ");
                    String npm = scanner.nextLine(); // Ambil seluruh baris

                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine(); // Ambil seluruh baris

                    System.out.print("Masukkan Semester: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine(); // <<< PENTING: Membersihkan buffer setelah nextInt()

                    System.out.print("Masukkan IPK: ");
                    float ipk = scanner.nextFloat();
                    scanner.nextLine(); // <<< PENTING: Membersihkan buffer setelah nextFloat()

                    System.out.println("Input Data: " + npm + " " + nama + " " + semester + " " + ipk); // Tambahkan ini untuk debugging

                    mahasiswaController.addMahasiswa(npm, nama, semester, ipk);
                    break;

                case 3:
                    System.out.print("Masukkan ID mahasiswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // <<< PENTING: Membersihkan buffer setelah nextInt()

                    System.out.print("Masukkan NPM: ");
                    String npmBaru = scanner.nextLine(); // nextLine()

                    System.out.print("Masukkan Nama: ");
                    String namaBaru = scanner.nextLine(); // nextLine()

                    System.out.print("Masukkan Semester: ");
                    int semesterBaru = scanner.nextInt();
                    scanner.nextLine(); // <<< PENTING

                    System.out.print("Masukkan IPK: ");
                    float ipkBaru = scanner.nextFloat();
                    scanner.nextLine(); // <<< PENTING

                    mahasiswaController.updateMahasiswa(id, npmBaru, namaBaru, semesterBaru, ipkBaru);
                    break;

                case 4:
                    System.out.print("Masukkan ID Hapus: ");
                    int idHapus = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa(idHapus);
                    break;

                case 5:
                    mahasiswaController.checkDatabaseConnection();
                    break;

                case 6:
                    mahasiswaController.closeConnection(); 
                    System.out.println("Program selesai.");
                    return; 

                default:
                    System.out.println("Input Tidak valid");
            }
        }
    }
    
}

