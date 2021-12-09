import java.util.*;

public class Hash {
    private List<LinkedList<Object>> list ;
    private static final int hash =52544521;
    private int size = 20;


    public Hash() {
       list = new ArrayList<>(size);
       for(int i=0;i<size;i++){
           list.add(null);
       }
    }

    public  void add(Object object) {
        int objectHash=doHash(object);
        if(list.get(objectHash)==null){
            LinkedList<Object> helpList=new LinkedList<>();
            helpList.add(object);
            list.set(objectHash,helpList);
        }else{
            list.get(objectHash).add(object);
        }
    }


    @Override
    public String toString() {
        return "Hash{" +
                "list=" + list +
                ", size=" + size +
                '}';
    }

    private int doHash(Object object) {
        return Math.abs((object.hashCode() * hash) % size);
    }

}
