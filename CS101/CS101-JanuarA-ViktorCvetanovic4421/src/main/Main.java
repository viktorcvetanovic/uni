/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.pesma.BesplatnaPesma;
import data.pesma.Pesma;
import data.pesma.PlacenaPesma;
import data.servis.Servis;
import enums.TipPlacanja;
import enums.TipZanra;
import enums.TipZvuka;
import exceptions.InvalidVrednostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.FileWrite.upisiUFajl;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Servis servis = null;
        try {
            Pesma s = new BesplatnaPesma(false, TipZvuka.LOS, "prvo", "danica", 2000, 70, TipZanra.TECHNO);
            Pesma s1 = new BesplatnaPesma(true, TipZvuka.SREDNJI, "nis", "vikttor", 1967, 50, TipZanra.TECHNO);
            Pesma s2 = new BesplatnaPesma(false, TipZvuka.DOBAR, "noc", "milena", 1999, 90, TipZanra.RAP);
            Pesma s3 = new BesplatnaPesma(true, TipZvuka.LOS, "dan", "dragan", 2000, 100, TipZanra.ROCK);
            Pesma s4 = new BesplatnaPesma(true, TipZvuka.LOS, "kralj", "petar", 2001, 120, TipZanra.POP);

            Pesma s5 = new PlacenaPesma(200, TipPlacanja.KRIPTOVALUTA, "ne znam", "nikola", 1940, 60, TipZanra.POP);
            Pesma s6 = new PlacenaPesma(240, TipPlacanja.PAYPAL, "ne znam", "nikola", 1940, 60, TipZanra.ROCK);
            Pesma s7 = new PlacenaPesma(270, TipPlacanja.KARTICA, "ne znam", "nikola", 1940, 60, TipZanra.TECHNO);
            Pesma s8 = new PlacenaPesma(300, TipPlacanja.PAYPAL, "ne znam", "nikola", 1940, 60, TipZanra.RAP);
            Pesma s9 = new PlacenaPesma(400, TipPlacanja.KARTICA, "ne znam", "nikola", 1940, 60, TipZanra.TECHNO);
            servis = new Servis(Arrays.asList(s, s1, s2, s3, s4, s5, s6, s7, s8, s9));
        } catch (InvalidVrednostException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(servis.vratiBesplatnePesme());
        System.out.println(servis.vratiPoZanru(TipZanra.POP));
        upisiUFajl(servis.getLista());
    }

}
