import java.time.LocalDateTime;

public class Zadatak1 {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < i * i; j++) {
                for (int c = 0; c < j; c++) {
                    for(int m=0;m<c;m++){
                        Math.random();
                    }
                }
            }
        }
        System.out.println(LocalDateTime.now());
    }
}
