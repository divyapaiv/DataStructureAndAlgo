package random;

public class CountDigits {
  public static void main(String args[]) {
    Integer num = 500, digit = 0;
    while (num > 0) {
      num = num / 10;
      digit++;
    }
    System.out.println(digit);
  }
}