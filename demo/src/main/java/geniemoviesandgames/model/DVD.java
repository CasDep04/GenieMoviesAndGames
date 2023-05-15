package geniemoviesandgames.model;

public class DVD extends movies{
    
    public DVD(){
        super();
    }
    public DVD(String ID,String title,Boolean DayLoan,int copies,double fees,String genre){
        super(ID, title, DayLoan, copies, fees, genre);
    }
    
}
