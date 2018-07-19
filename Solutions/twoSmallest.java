public class twoSmallest {
  public static void main(String[] args) {

    double listNum, small1 = 0, small2 = 0, temp = 0;
    boolean b = true;
    System.out.println("Type -999 to quit.");

    do {

      System.out.println("Enter value again: ");
      listNum = IO.readDouble();

      if (b) {
        small1 = listNum;
        small2 = listNum;
        b = false;
      }

      if (listNum <= small1 && listNum != -999) {
        temp = small1;
        small1 = listNum;
        if (temp < small2) {
          small2 = temp;
        }
      } else if (listNum < small2 && listNum != -999) {
        small2 = listNum;
      }

    } while (listNum != -999);

    System.out.println("1st Smallest number: " + small1);
    System.out.println("2nd Smallest number: " + small2);

  }
}
