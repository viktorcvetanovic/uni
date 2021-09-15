/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import entity.Predmet;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PredmetCrud {

    @Transactional
    public static void addPredmet(Predmet predmet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
//            Predmet.getBestscoresList().forEach(score -> score.setPredmetId(Predmet));
            session.save(predmet);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Transactional
    public static void updatePredmet(Predmet predmet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(predmet);
        transaction.commit();
        session.close();
    }

    @Transactional
    public static void deletePredmet(Predmet predmet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(predmet);
        transaction.commit();
        session.close();
    }

    @Transactional
    public static List<Predmet> getAllPredmets() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Predmet> PredmetList = session.createCriteria(Predmet.class).list();
        transaction.commit();
        session.close();
        return PredmetList;
    }

    @Transactional
    public static Predmet getPredmet(Integer predmet_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Predmet Predmet = (Predmet) session.get(Predmet.class, predmet_id);
        transaction.commit();
        session.close();
        return Predmet;
    }

    public static List<Predmet> allpredmetByProfessor(Integer year) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Predmet> PredmetList = session.getNamedQuery("Predmet.findbyAcademicYear").list();
        transaction.commit();
        session.close();
        return PredmetList;
    }
}
