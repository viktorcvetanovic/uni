/***********************************************************************
 * Module:  Raspored.java
 * Author:  BiG
 * Purpose: Defines the Class Raspored
 ***********************************************************************/

import java.util.*;

/** @pdOid d09fec1b-8462-47f1-9894-58e6fa5446fe */
public class Raspored {
   /** @pdOid cf2e2737-112b-4f91-9c18-2289f8a6b896 */
   private Date datum;
   /** @pdOid 04d4818a-a40f-4880-85c2-5dd86fd84721 */
   private Date vremePocetka;
   /** @pdOid f5149e38-0a89-4b17-835d-3cd36b821f9f */
   private Date vremeKraja;
   
   /** @pdRoleInfo migr=no name=Zaposleni assc=association2 mult=1..* type=Aggregation */
   public Zaposleni[] zaposleni;
   /** @pdRoleInfo migr=no name=Nedelja assc=association1 mult=1..1 type=Aggregation side=A */
   public Nedelja nedelja;

}