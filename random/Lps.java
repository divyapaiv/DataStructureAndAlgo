class Lps {
  public String longestPalindrome(String s) {
    Boolean[][] lcs = new Boolean[s.length()][s.length()];
    // Arrays.fill(lcs,false);
    int maxlen = 1, start = 0;
    // Base case length i..i
    for (int i = 0; i < s.length(); i++) {
      lcs[i][i] = true;
    }
    /*for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1))
        lcs[i][i + 1] = true;
    }*/
    for (int i = 0; i < s.length() - 1; i++) {

      if (s.charAt(i) == s.charAt(i + 1)) {
        lcs[i][i + 1] = true;
        start = i;
        maxlen = 2;
      }

    }

    for (int k = 3; k <= s.length(); k++) {// Length
      for (int i = 0; i < s.length() - k + 1; i++) {// Start index
        int j = i + k - 1;// startposition+length-1
        // System.out.println("K: "+k+"\t i "+i+"\t J :"+j);
        // System.out.println(s.charAt(i)+" "+s.charAt(j));
        if (s.charAt(i) == s.charAt(j) && lcs[i + 1][j - 1] != null && lcs[i + 1][j - 1]) {
          lcs[i][j] = true;
          if (k > maxlen) {
            start = i;
            maxlen = k;
          }
        }
      }

    }
    return (s.substring(start, start + maxlen));

  }
}