package main;

import Crud.KupacCrud;

public class Main {
    public static void main(String[] args) {
        System.out.println(KupacCrud.getAllKupac());
        System.out.println(KupacCrud.getKupacById(5L));
    }
}
