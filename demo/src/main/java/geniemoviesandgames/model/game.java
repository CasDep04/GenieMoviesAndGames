package geniemoviesandgames.model;

public class game extends item{

    public game(){
        super();
    }
    public game(String ID,String title,Boolean item2DayLoan,int copies,double fees){
        super(ID, title, item2DayLoan, copies, fees);
    }
   
}
