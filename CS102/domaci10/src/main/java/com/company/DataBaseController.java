package com.company;

import entity.Kupac;
import entity.Porudzbina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseController {
    //u svakoj metodi gde je moguce vraca se int da bi se znalo da li je upit prosao
    public static int addKupac(Kupac k) {
        //stavljen je u try jer klasa Connection poseduje inteface AutoClosable sto znaci da ako se konekcija ne izvrsi uspesno ona ce se sama zatvoriti
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO kupac(ime,prezime,drzava) VALUES (? , ? , ?)");
            preparedStatement.setString(1, k.getIme());
            preparedStatement.setString(2, k.getPrezime());
            preparedStatement.setString(3, k.getDrzava());
            int update = preparedStatement.executeUpdate();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int removeKupac(Integer id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM kupac WHERE id=?");
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void readAllKupac() {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM kupac");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kupac k = new Kupac();
                k.setId(resultSet.getInt(1));
                k.setIme(resultSet.getString(2));
                k.setPrezime(resultSet.getString(3));
                k.setDrzava(resultSet.getString(4));
                System.out.println(k.toString());
                System.out.println();
                System.out.println("--------------------------------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int updateKupac(Kupac k) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE kupac SET ime=?, prezime=?, drzava=? WHERE id=?");
            preparedStatement.setString(1, k.getIme());
            preparedStatement.setString(2, k.getPrezime());
            preparedStatement.setString(3, k.getDrzava());
            preparedStatement.setInt(4, k.getId());
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int addPorudzbina(Porudzbina p) {
        //stavljen je u try jer klasa Connection poseduje inteface AutoClosable sto znaci da ako se konekcija ne izvrsi uspesno ona ce se sama zatvoriti
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO porudzbina(id_kupca,broj_dana_isporuke) VALUES (? , ? )");
            preparedStatement.setInt(1, p.getId_kupca());
            preparedStatement.setInt(2, p.getBrojDanaIsporuke());
            int update = preparedStatement.executeUpdate();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int removePorudzbina(Integer id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM porudzbina WHERE id=?");
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void readAllPorudzbina() {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM porudzbina");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Porudzbina p = new Porudzbina();
                p.setId(resultSet.getInt(1));
                p.setId_kupca(resultSet.getInt(2));
                p.setBrojDanaIsporuke(resultSet.getInt(3));
                System.out.println(p.toString());
                System.out.println();
                System.out.println("--------------------------------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int updatePorudzbina(Porudzbina p) {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci10", "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE porudzbina SET id=?, id_kupca=?, broj_dana_isporuke=? WHERE id=?");
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setInt(2,p.getId_kupca());
            preparedStatement.setInt(3, p.getBrojDanaIsporuke());
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
