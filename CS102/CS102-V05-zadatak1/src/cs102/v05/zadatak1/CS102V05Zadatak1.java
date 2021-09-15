/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v05.zadatak1;

/**
 *
 * @author vikto
 */
public class CS102V05Zadatak1 {

    public static boolean isPalindrom(String word) {

        if (word.length() <= 1) {
            return true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalindrom(word.substring(1, word.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrom("ana"));
    }

}
