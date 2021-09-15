package crud;

import entity.Predmet;
import entity.Profesor;

import java.sql.*;
import java.util.List;

public class Baza {

    public static int addProfesor(Profesor k) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Profesor(ime,prezime,godina_izbora,naslov_doktorata) VALUES (? , ? , ? , ?)");
            preparedStatement.setString(1, k.getIme());
            preparedStatement.setString(2, k.getPrezime());
            preparedStatement.setInt(3, k.getGodinaIzbora());
            preparedStatement.setString(4, k.getNaslovDoktorata());
            int update = preparedStatement.executeUpdate();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int removeProfesor(Integer id) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Profesor WHERE id=?");
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void readAllProfesor() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Profesor");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profesor k = new Profesor();
                k.setId(resultSet.getInt(1));
                k.setIme(resultSet.getString(2));
                k.setPrezime(resultSet.getString(3));
                k.setGodinaIzbora(resultSet.getInt(4));
                k.setNaslovDoktorata(resultSet.getString(5));
                System.out.println(k.toString());
                System.out.println();
                System.out.println("--------------------------------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int updateProfesor(Profesor k) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Profesor SET ime=?, prezime=?, drzava=? WHERE id=?");

            preparedStatement.setString(1, k.getIme());
            preparedStatement.setString(2, k.getPrezime());
            preparedStatement.setInt(3, k.getGodinaIzbora());
            preparedStatement.setString(4, k.getNaslovDoktorata());
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int addPredmet(Predmet p) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Predmet(fk_profesor,sifra_predmeta,naziv_predmeta) VALUES ( ? , ? , ?)");
            preparedStatement.setInt(1, p.getFk_profesor());
            preparedStatement.setString(2, p.getSifraPredmeta());
            preparedStatement.setString(3, p.getNazivPredmeta());
            int update = preparedStatement.executeUpdate();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int removePredmet(Integer id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Predmet WHERE id=?");
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void readAllPredmet() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Predmet");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Predmet p = new Predmet();
                p.setId(resultSet.getInt(1));
                p.setFk_profesor(resultSet.getInt(2));
                p.setSifraPredmeta(resultSet.getString(3));
                p.setSifraPredmeta(resultSet.getString(4));
                System.out.println(p.toString());
                System.out.println();
                System.out.println("--------------------------------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int updatePredmet(Predmet p) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Predmet SET id=?, fk_profesor=?, sifra_predmeta=?, naziv_predmeta WHERE id=?");
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setInt(2, p.getFk_profesor());
            preparedStatement.setString(3, p.getSifraPredmeta());
            preparedStatement.setString(4, p.getNazivPredmeta());
            preparedStatement.setInt(5, p.getId());
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public static void filterByYear(int year) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/domaci_baza", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM predmet INNER JOIN profesor ON fk_profesor=id WHERE ime LIKE '%e%' AND godina_izbora > ?");
            preparedStatement.setInt(1, year);
            ResultSet set=preparedStatement.executeQuery();
            while(set.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}