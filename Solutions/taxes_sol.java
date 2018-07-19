public class taxes_sol {
    public static void main(String[] args) {
      
      int money, sub;
      double taxDue, sub2;
      
      money = IO.readInt();
      
      if ( money < 0 ){
        IO.reportBadInput();
        return;
      }
      
      if ( money >= 0 && money <= 7800 ){
        taxDue = (money*.10);
        IO.outputDoubleAnswer(taxDue);
      }else if (money > 7800 && money <= 31800){
        sub = (money - 7800);
        sub2 = (sub*.15);
        taxDue = (sub2+780);
        IO.outputDoubleAnswer(taxDue);
      }else if (money > 31800 && money <= 69000){
        sub = (money - 31800);
        sub2 = (sub*.25);
        taxDue = (sub2+4380);
        IO.outputDoubleAnswer(taxDue);
      }else{
        sub = (money - 76800);
        sub2 = (sub*.35);
        taxDue = (sub2+15630);
        IO.outputDoubleAnswer(taxDue);
      }
          
    }
}
