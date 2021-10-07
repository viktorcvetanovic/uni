public class Zadatak4 {

    public static void main(String[] args) {
        System.out.println(sortString("bca"));
    }


    public static String sort(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j] && i!=j) {
                    char help = arr[j];
                    arr[j] = arr[i];
                    arr[i] = help;
                }
            }
        }
        return new String(arr);
    }

    public static String sortString(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <s.length(); j++) {
                if (s.charAt(i) < s.charAt(j)&& i!=j) {
                    char help = s.charAt(j);
                    char help2 = s.charAt(i);
                    String b=s.substring(i);
                }
            }
        }
        return s;
    }
}
