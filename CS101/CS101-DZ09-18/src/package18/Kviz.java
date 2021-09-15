/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package18;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Kviz {

    private Ucesnik pobednik;
    private List<Ucesnik> lista = new ArrayList<>();

    public Kviz() {
    }

    public Kviz(List<Ucesnik> lista) {

        this.lista = lista;
    }

    public Ucesnik getPobednik() {
        return pobednik;
    }

    public List<Ucesnik> getLista() {
        return lista;
    }

    public void setLista(List<Ucesnik> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Kviz{" + "pobednik=" + pobednik + ", lista=" + lista + '}';
    }

    public void nadjiPobednika() {
        double minPobednik = 0;
        for (Ucesnik u : lista) {
            if (u.ukupnoPoena() > minPobednik) {
                pobednik = u;
            }
        }
    }

}
