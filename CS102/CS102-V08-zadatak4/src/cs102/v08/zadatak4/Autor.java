/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v08.zadatak4;

/**
 *
 * @author vikto
 */
public class Autor implements Comparable<Autor> {

    private String name;
    private String surname;

    public Autor() {
    }

    public Autor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Autor{" + "name=" + name + ", surname=" + surname + '}';
    }

    @Override
    public int compareTo(Autor t) {
        if (this.name.compareTo(t.name) == 0) {
            return this.surname.compareTo(surname);
        }
        return this.name.compareTo(t.name);
    }

}
