package entity;

public class Predmet {
   private int id;
   private int fk_profesor;
   private String sifraPredmeta;
   private String nazivPredmeta;

   public Predmet( int fk_profesor, String sifra_predmeta, String naziv_predmeta) {
      this.fk_profesor = fk_profesor;
      this.sifraPredmeta = sifra_predmeta;
      this.nazivPredmeta = naziv_predmeta;
   }

   public Predmet() {

   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getFk_profesor() {
      return fk_profesor;
   }

   public void setFk_profesor(int fk_profesor) {
      this.fk_profesor = fk_profesor;
   }

   public String getSifraPredmeta() {
      return sifraPredmeta;
   }

   public void setSifraPredmeta(String sifraPredmeta) {
      this.sifraPredmeta = sifraPredmeta;
   }

   public String getNazivPredmeta() {
      return nazivPredmeta;
   }

   public void setNazivPredmeta(String nazivPredmeta) {
      this.nazivPredmeta = nazivPredmeta;
   }

   @Override
   public String toString() {
      return "Predmet{" +
              "id=" + id +
              ", fk_profesor=" + fk_profesor +
              ", sifra_predmeta='" + sifraPredmeta + '\'' +
              ", naziv_predmeta='" + nazivPredmeta + '\'' +
              '}';
   }
}
