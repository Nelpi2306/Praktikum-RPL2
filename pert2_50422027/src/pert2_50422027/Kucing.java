/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pert2_50422027;

/**
 *
 * @author nelpi
 */
public class Kucing extends Hewan {
    
    public Kucing(String nama, int umur) {
        super(nama, umur, "Kucing");
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " melompat-lompat.");
    }
}
