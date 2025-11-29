/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pert1_50422027;

import java.util.Scanner;

/**
 *
 * @author nelpi
 */
public class Pert1_50422027 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama Anda: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Umur Anda: ");
        int umur = input.nextInt();
        input.nextLine(); // Membersihkan buffer

        System.out.print("Masukkan Makanan Favorit Anda: ");
        String makanan = input.nextLine();

        System.out.println("Nama Anda adalah " + nama);
        System.out.println("Umur Anda adalah " + umur + " tahun");
        System.out.println("Makanan Favorit Anda adalah " + makanan);
    } 
}
