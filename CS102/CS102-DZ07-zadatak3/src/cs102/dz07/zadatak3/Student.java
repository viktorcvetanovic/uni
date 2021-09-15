package cs102.dz07.zadatak3;

public class Student {

    private String ime;
    private String prezime;
    private Integer brojInd;

    public Student() {
    }

    public Student(String ime, String prezime, Integer brojInd) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojInd = brojInd;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getBrojInd() {
        return brojInd;
    }

    public void setBrojInd(Integer brojInd) {
        this.brojInd = brojInd;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", brojInd=" + brojInd + '}';
    }

}
