/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pert2_50422027;

/**
 *
 * @author nelpi
 */
public class Hewan {
    // Attribute
    String nama;
    int umur;
    String jenis;

    // Constructor
    public Hewan(String nama, int umur, String jenis) {
        this.nama = nama;
        this.umur = umur;
        this.jenis = jenis;
    }

    // Method
    public void makan() {
        System.out.println(nama + " sedang makan.");
    }

    public void tidur() {
        System.out.println(nama + " sedang tidur.");
    }

    public void bergerak() {
        System.out.println(nama + " sedang bergerak.");
    }
}

