/***********************************************************************
 * Module:  Transport.java
 * Author:  BiG
 * Purpose: Defines the Class Transport
 ***********************************************************************/

import java.util.*;

/** @pdOid 0308a180-edd5-413f-b3f3-6316d0d87776 */
public class Transport {
   /** @pdOid 70347a0a-1651-47e6-bd7e-a3d118161006 */
   private Date datum;
   /** @pdOid e498e686-fc15-44c2-ba62-2ed8b1572dec */
   private int brojZatvorenika;
   
   /** @pdRoleInfo migr=no name=TransportSluzba assc=association4 mult=1..* type=Aggregation side=A */
   public TransportSluzba[] transportSluzba;

}