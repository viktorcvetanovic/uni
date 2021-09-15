package Crud;

import entity.Kupac;
import entity.Porudzbina;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class KupacCrud {

    public static List<Kupac> getAllKupac() {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Kupac> kupacList = entityManager.createQuery("SELECT a FROM Kupac a ", Kupac.class).getResultList();
        entityTransaction.commit();
        return kupacList;
    }

    public static Kupac getKupacById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Kupac kupac = entityManager.find(Kupac.class, id);
        entityTransaction.commit();

        return kupac;
    }

    public static void updateKupac(Kupac kupac) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createQuery("update Kupac set ime =" +kupac.getIme() +" where id="+kupac.getId())
                .executeUpdate();
        entityTransaction.commit();

    }


    public static void removeKupac(Kupac kupac) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createQuery("delete from Kupac where Kupac.id="+kupac.getId());
        entityTransaction.commit();
    }
    public static List<Porudzbina> getAllPorudzbina() {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Porudzbina> porudzbinaList = entityManager.createQuery("SELECT a FROM Porudzbina a ", Porudzbina.class).getResultList();
        entityTransaction.commit();
        return porudzbinaList;
    }

    public static Porudzbina getPorudzbinaById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Porudzbina porudzbina = entityManager.find(Porudzbina.class, id);
        entityTransaction.commit();
        return porudzbina;
    }

    public static void updatePorudzbina(Porudzbina porudzbina) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createQuery("update Porudzbina set brojDanaIsporuke =" +porudzbina.getBrojDanaIsporuke() +" where id="+porudzbina.getId())
                .executeUpdate();
        entityTransaction.commit();

    }


    public static void removePorudzbina(Porudzbina porudzbina) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createQuery("delete from Kupac where Porudzbina.id="+porudzbina.getId());
        entityTransaction.commit();
    }

}
