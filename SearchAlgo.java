
class SearchAlgo {
  Integer item[] = new Integer[100];

  public SearchAlgo(Integer... x) {
    item = x;
  }

  /* O(Log N) */
  boolean binarySearch(Integer key) {
    int high = this.item.length - 1;
    int low = 0;
    int mid;
    while (high >= 0 && low < this.item.length) {

      mid = (low + high) / 2;
      /*
       * System.out.println(low+" "+high+" "+mid+
       * " "+this.item[mid]);
       */

      if (this.item[mid].equals(key)) {
        return true;
      } else if (item[mid] > key)
        high = mid - 1;

      else if (item[mid] < key)
        low = mid + 1;
    }
    return false;
  }

  /* O(N) */
  boolean linearSearch(Integer key) {
    for (Integer i : this.item) {
      if (i == key)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    SearchAlgo obj = new SearchAlgo(new Integer[] { 1, 2, 4, 100, 123, 178, 200 });

    /* Linear Search Execution Block */
    long startTime = System.currentTimeMillis();
    System.out.println(obj.linearSearch(200));
    long endTime = System.currentTimeMillis();
    System.out.println(
        "Total execution time(Linear Search): " + (endTime - startTime));

    /* Binary Search Execution Block */
    startTime = System.currentTimeMillis();
    System.out.println(obj.binarySearch(200));
    endTime = System.currentTimeMillis();
    System.out.println(
        "Total execution time(Binary Search):" + (endTime - startTime));

  }
}