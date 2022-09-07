import java.util.*;

class QuickRef {
  public static void main(String[] args) {
    Integer[] val = new Integer[1];
    val[0] = 199;
    System.out.println(val[0]);
    HashMap<String, Integer> hmp = new HashMap<String, Integer>();
    hmp.put("a", 100);
    hmp.putIfAbsent("b", 500);
    hmp.putIfAbsent("a", 401);
    for (String m : hmp.keySet()) {
      System.out.println(hmp.get(m));
    }

  }
}
