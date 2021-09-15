import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


    }

    //relacija je da je zbir svaka dva deljiv sa 2, ne znam matematiku
    public static boolean isItRefleksiv(Integer[][] niz) throws NullPointerException {
        if (niz == null) {
            throw new NullPointerException();
        }
        if(niz.length!= niz[0].length){
            throw new IllegalArgumentException();
        }
        if((niz[0][niz.length-1]+niz[niz.length-1][0])%2!=0){
        return false;
        }else{
            niz=deleteFromArrayFirstAndLastElements(niz);
            isItRefleksiv(niz);
        }

        return true;
    }


    public static Integer[][] deleteFromArrayFirstAndLastElements(Integer[][] niz){
        Integer [][] newArray=new Integer[niz.length-1][niz.length-1];
        int el1=0;
        int el2=0;
        for(int i=1;i<niz.length;i++){
            el1++;
            for(int j=0;j<niz.length-1;j++){
                newArray[el1][el2]=niz[i][j];
                el2++;
            }
        }
        return newArray;
    }
}
