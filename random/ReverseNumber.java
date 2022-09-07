class ReverseNumber {
  public static void main(String[] args) {
    int num = 11011, temp = 0, digit = 0, reverse = 0, rem = 0;
    temp = num;
    while (num != 0) {
      rem = num % 10;
      reverse = reverse * 10 + rem;
      num = (int) (num / 10);

      digit++;
    }
    System.out.println(reverse);
    System.out.println(temp);
    if (reverse == temp)
      System.out.println("Yes");
    else
      System.out.println("No");
  }
}