/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.firma;

import data.automobil.Automobil;
import data.automobil.garancija.Garancija;

import enums.TipAutomobila;
import java.util.ArrayList;
import java.util.List;

/**
 * metoda koja puni listu automobila i prosledjuje se klasi Firma
 *
 * return lista vraca listu automobila
 */
public class FirmaCars {

    public static List<Automobil> sviAutomobili() {
        List<Automobil> lista = new ArrayList<>();
        Garancija garancija = new Garancija(5, 5000);
        Automobil a1 = new Automobil(4, "a4", TipAutomobila.LIMUZINA, garancija);
        Automobil a2 = new Automobil(2, "tt", TipAutomobila.KUPE, garancija);
        Automobil a3 = new Automobil(4, "q7", TipAutomobila.DZIP, garancija);
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        return lista;
    }
}
