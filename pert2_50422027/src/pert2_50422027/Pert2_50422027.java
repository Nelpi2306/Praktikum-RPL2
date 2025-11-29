/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pert2_50422027;

/**
 *
 * @author nelpi
 */
public class Pert2_50422027 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Membuat object Hewan
        Hewan kucing = new Hewan("Kitty", 2, "Kucing");
        Hewan anjing = new Hewan("Doggy", 3, "Anjing");

        // Memanggil method
        kucing.makan();
        kucing.bergerak();
        anjing.tidur();
        anjing.bergerak();
    }
}
