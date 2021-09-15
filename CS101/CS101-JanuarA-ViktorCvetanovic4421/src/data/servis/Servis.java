/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.servis;

import data.pesma.BesplatnaPesma;
import data.pesma.Pesma;
import enums.TipZanra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class Servis {

    private List<Pesma> lista = new ArrayList<>();

    public Servis() {
    }

    public Servis(List<Pesma> lista) {
        this.lista = lista;
    }

    public List<Pesma> getLista() {
        return lista;
    }

    public void setLista(List<Pesma> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Servis{" + "lista=" + lista + '}';
    }

    public List<Pesma> vratiPoZanru(TipZanra tip) {
        List<Pesma> zanrLista = new ArrayList<>();
        for (Pesma s : lista) {
            if (s.getTipZanra().ordinal() == tip.ordinal()) {
                zanrLista.add(s);
            }
        }
        return zanrLista;
    }

    public List<BesplatnaPesma> vratiBesplatnePesme() {
        List<BesplatnaPesma> listaBesplatna = new ArrayList<>();

        for (Pesma s : lista) {
            if (s instanceof BesplatnaPesma) {
                listaBesplatna.add((BesplatnaPesma) s);
            }

        }
        return listaBesplatna;
    }
}
