/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Prodavnica {

    private String shopName;
    private String shopAdress;
    private String ownersName;
    private List<Proizvod> proizvodi = new ArrayList<>();

    public Prodavnica() {
    }

    public Prodavnica(String shopName, String shopAdress, String ownersName, List<Proizvod> proizvodi) {
        this.shopName = shopName;
        this.shopAdress = shopAdress;
        this.ownersName = ownersName;
        this.proizvodi = proizvodi;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAdress() {
        return shopAdress;
    }

    public void setShopAdress(String shopAdress) {
        this.shopAdress = shopAdress;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public List<Proizvod> proveraCene(double cena) {
        List<Proizvod> cenaManja = new ArrayList<>();
        for (Proizvod p : this.proizvodi) {
            if (p.getProductPrice() < cena) {
                cenaManja.add(p);
            }
        }
        return cenaManja;
    }

    public List<Proizvod> proveravaKategoriju(RacunarTip tip) {
        RacunarTip glavniTip;
        List<Proizvod> istiTip = new ArrayList<>();
        if (tip.ordinal() == RacunarTip.DESKTOP.ordinal()) {
            glavniTip = RacunarTip.DESKTOP;
        } else if (tip.ordinal() == RacunarTip.LAPTOP.ordinal()) {
            glavniTip = RacunarTip.LAPTOP;
        } else {
            glavniTip = RacunarTip.TABLET;
        }
        for (Proizvod p : this.proizvodi) {
            if (p instanceof Racunar) {
                RacunarTip tip1 = ((Racunar) p).getTip();
                if (tip1.ordinal() == glavniTip.ordinal()) {
                    istiTip.add(p);
                }
            }
        }
        return istiTip;
    }

    public List<Proizvod> proveravaKategoriju(TelevizorTip tip) {
        TelevizorTip glavniTip;
        List<Proizvod> istiTip = new ArrayList<>();
        if (tip.ordinal() == TelevizorTip.SMART.ordinal()) {
            glavniTip = TelevizorTip.SMART;
        } else {
            glavniTip = TelevizorTip.NOSMART;
        }
        for (Proizvod p : this.proizvodi) {
            if (p instanceof Televizor) {
                TelevizorTip tip1 = ((Televizor) p).getTip();
                if (tip1.ordinal() == glavniTip.ordinal()) {
                    istiTip.add(p);
                }
            }
        }
        return istiTip;
    }

    @Override
    public String toString() {
        return "Prodavnica{" + "shopName=" + shopName + ", shopAdress=" + shopAdress + ", ownersName=" + ownersName + ", proizvodi=" + proizvodi + '}';
    }

}
