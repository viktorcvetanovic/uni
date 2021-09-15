package zadatak1;

import zadatak1.exception.InvalidWordException;

public class Zadatak1 {

    public static void main(String[] args) {
        try {
            System.out.println(isItEven("viktora"));
        } catch (InvalidWordException e) {
            e.printStackTrace();
        }
        System.out.println(isItEvenNumber(2000));
    }

    public static boolean isItEven(String word) throws InvalidWordException {
        if(word==null){
            throw new InvalidWordException("Pogresna rec");
        }
        if(word.length()==0){
            return true;
        }
        if(word.length()==1){
            return  false;
        }
        word=word.substring(1);
        word=word.substring(0,word.length()-1);
        return isItEven(word);
    }


    public static boolean isItEvenNumber(int number){

        return true;
    }
}
