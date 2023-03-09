/***********************************************************************
 * Module:  Korisnik.java
 * Author:  vikto
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.util.*;

/** @pdOid 4b30fa8d-165a-473b-827a-cd9ca02d3e24 */
public class Korisnik {
   /** @pdOid d5093725-c0b2-4fd9-83d8-1305940a7394 */
   private String ime;
   /** @pdOid 20e10ec6-9caf-4697-9c45-159fb7b12d70 */
   private String prezime;
   /** @pdOid 158f3d21-85f9-4c47-a0fb-eaa246ea59ee */
   private String username;
   /** @pdOid df138fc8-1822-4db9-9a27-37c944790078 */
   private String email;
   
   /** @pdRoleInfo migr=no name=Post assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Post> post;
   /** @pdRoleInfo migr=no name=Prijatelj assc=association2 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Prijatelj> prijatelj;
   /** @pdRoleInfo migr=no name=Podesavanje assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Podesavanje> podesavanje;
   /** @pdRoleInfo migr=no name=Poruka assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Poruka> poruka;
   /** @pdRoleInfo migr=no name=Grupa assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Grupa> grupa;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Post> getPost() {
      if (post == null)
         post = new java.util.HashSet<Post>();
      return post;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPost() {
      if (post == null)
         post = new java.util.HashSet<Post>();
      return post.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPost */
   public void setPost(java.util.Collection<Post> newPost) {
      removeAllPost();
      for (java.util.Iterator iter = newPost.iterator(); iter.hasNext();)
         addPost((Post)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPost */
   public void addPost(Post newPost) {
      if (newPost == null)
         return;
      if (this.post == null)
         this.post = new java.util.HashSet<Post>();
      if (!this.post.contains(newPost))
         this.post.add(newPost);
   }
   
   /** @pdGenerated default remove
     * @param oldPost */
   public void removePost(Post oldPost) {
      if (oldPost == null)
         return;
      if (this.post != null)
         if (this.post.contains(oldPost))
            this.post.remove(oldPost);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPost() {
      if (post != null)
         post.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Prijatelj> getPrijatelj() {
      if (prijatelj == null)
         prijatelj = new java.util.HashSet<Prijatelj>();
      return prijatelj;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPrijatelj() {
      if (prijatelj == null)
         prijatelj = new java.util.HashSet<Prijatelj>();
      return prijatelj.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPrijatelj */
   public void setPrijatelj(java.util.Collection<Prijatelj> newPrijatelj) {
      removeAllPrijatelj();
      for (java.util.Iterator iter = newPrijatelj.iterator(); iter.hasNext();)
         addPrijatelj((Prijatelj)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPrijatelj */
   public void addPrijatelj(Prijatelj newPrijatelj) {
      if (newPrijatelj == null)
         return;
      if (this.prijatelj == null)
         this.prijatelj = new java.util.HashSet<Prijatelj>();
      if (!this.prijatelj.contains(newPrijatelj))
         this.prijatelj.add(newPrijatelj);
   }
   
   /** @pdGenerated default remove
     * @param oldPrijatelj */
   public void removePrijatelj(Prijatelj oldPrijatelj) {
      if (oldPrijatelj == null)
         return;
      if (this.prijatelj != null)
         if (this.prijatelj.contains(oldPrijatelj))
            this.prijatelj.remove(oldPrijatelj);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPrijatelj() {
      if (prijatelj != null)
         prijatelj.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Podesavanje> getPodesavanje() {
      if (podesavanje == null)
         podesavanje = new java.util.HashSet<Podesavanje>();
      return podesavanje;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPodesavanje() {
      if (podesavanje == null)
         podesavanje = new java.util.HashSet<Podesavanje>();
      return podesavanje.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPodesavanje */
   public void setPodesavanje(java.util.Collection<Podesavanje> newPodesavanje) {
      removeAllPodesavanje();
      for (java.util.Iterator iter = newPodesavanje.iterator(); iter.hasNext();)
         addPodesavanje((Podesavanje)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPodesavanje */
   public void addPodesavanje(Podesavanje newPodesavanje) {
      if (newPodesavanje == null)
         return;
      if (this.podesavanje == null)
         this.podesavanje = new java.util.HashSet<Podesavanje>();
      if (!this.podesavanje.contains(newPodesavanje))
         this.podesavanje.add(newPodesavanje);
   }
   
   /** @pdGenerated default remove
     * @param oldPodesavanje */
   public void removePodesavanje(Podesavanje oldPodesavanje) {
      if (oldPodesavanje == null)
         return;
      if (this.podesavanje != null)
         if (this.podesavanje.contains(oldPodesavanje))
            this.podesavanje.remove(oldPodesavanje);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPodesavanje() {
      if (podesavanje != null)
         podesavanje.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Poruka> getPoruka() {
      if (poruka == null)
         poruka = new java.util.HashSet<Poruka>();
      return poruka;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPoruka() {
      if (poruka == null)
         poruka = new java.util.HashSet<Poruka>();
      return poruka.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPoruka */
   public void setPoruka(java.util.Collection<Poruka> newPoruka) {
      removeAllPoruka();
      for (java.util.Iterator iter = newPoruka.iterator(); iter.hasNext();)
         addPoruka((Poruka)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPoruka */
   public void addPoruka(Poruka newPoruka) {
      if (newPoruka == null)
         return;
      if (this.poruka == null)
         this.poruka = new java.util.HashSet<Poruka>();
      if (!this.poruka.contains(newPoruka))
         this.poruka.add(newPoruka);
   }
   
   /** @pdGenerated default remove
     * @param oldPoruka */
   public void removePoruka(Poruka oldPoruka) {
      if (oldPoruka == null)
         return;
      if (this.poruka != null)
         if (this.poruka.contains(oldPoruka))
            this.poruka.remove(oldPoruka);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPoruka() {
      if (poruka != null)
         poruka.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Grupa> getGrupa() {
      if (grupa == null)
         grupa = new java.util.HashSet<Grupa>();
      return grupa;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorGrupa() {
      if (grupa == null)
         grupa = new java.util.HashSet<Grupa>();
      return grupa.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newGrupa */
   public void setGrupa(java.util.Collection<Grupa> newGrupa) {
      removeAllGrupa();
      for (java.util.Iterator iter = newGrupa.iterator(); iter.hasNext();)
         addGrupa((Grupa)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGrupa */
   public void addGrupa(Grupa newGrupa) {
      if (newGrupa == null)
         return;
      if (this.grupa == null)
         this.grupa = new java.util.HashSet<Grupa>();
      if (!this.grupa.contains(newGrupa))
         this.grupa.add(newGrupa);
   }
   
   /** @pdGenerated default remove
     * @param oldGrupa */
   public void removeGrupa(Grupa oldGrupa) {
      if (oldGrupa == null)
         return;
      if (this.grupa != null)
         if (this.grupa.contains(oldGrupa))
            this.grupa.remove(oldGrupa);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllGrupa() {
      if (grupa != null)
         grupa.clear();
   }

}