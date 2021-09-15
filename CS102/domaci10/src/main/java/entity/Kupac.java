package entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kupac {
    private int id;
    private String ime;
    private String prezime;
    private String drzava;
    private List<Porudzbina> list= new ArrayList<>();

    public static Kupac ofWithId(int id,String ime,String prezime,String drzava){
        Kupac kupac= new Kupac();
        kupac.setId(id);
        kupac.setIme(ime);
        kupac.setPrezime(prezime);
        kupac.setDrzava(drzava);
        return  kupac;
    }

    public static Kupac of(String ime,String prezime,String drzava){
        Kupac kupac= new Kupac();
        kupac.setIme(ime);
        kupac.setPrezime(prezime);
        kupac.setDrzava(drzava);
        return  kupac;
    }
}
