/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import entity.Profesor;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProfesorCrud {

    @Transactional
    public static void addProfesor(Profesor profesor) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
//            Profesor.getBestscoresList().forEach(score -> score.setProfesorId(Profesor));
            session.save(profesor);
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
    public static void updateProfesor(Profesor profesor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(profesor);
        transaction.commit();
        session.close();
    }

    @Transactional
    public static void deleteProfesor(Profesor profesor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(profesor);
        transaction.commit();
        session.close();
    }

    @Transactional
    public static List<Profesor> getAllProfesors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Profesor> ProfesorList = session.createCriteria(Profesor.class).list();
        transaction.commit();
        session.close();
        return ProfesorList;
    }

    @Transactional
    public static Profesor getProfesor(Integer profesor_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Profesor Profesor = (Profesor) session.get(Profesor.class, profesor_id);
        transaction.commit();
        session.close();
        return Profesor;
    }

}
