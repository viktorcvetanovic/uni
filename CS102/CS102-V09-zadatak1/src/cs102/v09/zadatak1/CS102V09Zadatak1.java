/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v09.zadatak1;

/**
 *
 * @author vikto
 */
public class CS102V09Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int ponavljaj = 0;
                int glava = 0;
                int pismo = 1;
                for (int j = 0; j < 1000; j++) {
                    int rand = (int) (Math.random() * 1);
                    if (rand == glava) {
                        ponavljaj++;
                        if (ponavljaj == 3) {
                            System.out.println(Thread.currentThread().getName() + "IMA 3 PONAVLJAJA");
                        }
                    } else {
                        ponavljaj = 0;
                    }
                }
            }).start();
        }
    }

}
