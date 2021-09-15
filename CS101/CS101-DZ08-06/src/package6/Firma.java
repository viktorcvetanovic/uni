/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package6;

/**
 *
 * @author vikto
 */
public class Firma {

    private String companyName;
    private String companyAdress;
    private String PIB;

    private Zaposleni niz[] = new Zaposleni[10];

    public Firma(String companyName, String companyAdress, String PIB, Zaposleni niz[]) {
        this.companyName = companyName;
        this.companyAdress = companyAdress;
        this.PIB = PIB;
        this.niz = niz;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public Zaposleni[] getNiz() {
        return this.niz;
    }

    public void setNiz(Zaposleni[] niz) {
        this.niz = niz;
    }

    @Override
    public String toString() {
        return "Firma{" + "companyName=" + companyName + ", companyAdress=" + companyAdress + ", PIB=" + PIB + ", niz=" + niz + '}';
    }

    public double prosecnaZarada(TipRadnika tip) {
        int count1 = 0;
        double plata = 0;

        for (Zaposleni z : this.niz) {
            if (z.getTip().ordinal() == tip.ordinal()) {
                count1++;
                plata += z.getPayment();
            }
        }

        return plata / count1;
    }

}
