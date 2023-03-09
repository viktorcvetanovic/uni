/***********************************************************************
 * Module:  Zaposleni.java
 * Author:  BiG
 * Purpose: Defines the Class Zaposleni
 ***********************************************************************/

import java.util.*;

/** @pdOid 08adce93-d6ca-447c-a557-f79cd30a2d1b */
public class Zaposleni {
   /** @pdOid f21599fd-c9c9-4099-9165-93e6362734d9 */
   private String ime;
   /** @pdOid 453323f4-1801-465e-a210-198ce54bd1cf */
   private String prezime;
   /** @pdOid e334dbce-104b-4228-80e6-183dd466b168 */
   private String jmbg;
   /** @pdOid 73845cf1-3d29-48e0-bea4-c0b64e3cb2f5 */
   private String licnaKarta;
   /** @pdOid e83aadd7-278a-4376-bc82-94417d64a0af */
   private Integer starost;
   
   /** @pdRoleInfo migr=no name=Role assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Role> role;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Role> getRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRole */
   public void setRole(java.util.Collection<Role> newRole) {
      removeAllRole();
      for (java.util.Iterator iter = newRole.iterator(); iter.hasNext();)
         addRole((Role)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRole */
   public void addRole(Role newRole) {
      if (newRole == null)
         return;
      if (this.role == null)
         this.role = new java.util.HashSet<Role>();
      if (!this.role.contains(newRole))
         this.role.add(newRole);
   }
   
   /** @pdGenerated default remove
     * @param oldRole */
   public void removeRole(Role oldRole) {
      if (oldRole == null)
         return;
      if (this.role != null)
         if (this.role.contains(oldRole))
            this.role.remove(oldRole);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRole() {
      if (role != null)
         role.clear();
   }

}