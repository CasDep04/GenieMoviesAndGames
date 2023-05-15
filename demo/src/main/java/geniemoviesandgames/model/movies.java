package geniemoviesandgames.model;

public class movies extends item{
    protected String itemGenre;
    /**
     * @return String return the itemGenre
     */
    public String getItemGenre() {
        return itemGenre;
    }

    /**
     * @param itemGenre the itemGenre to set
     */
    public void setItemGenre(String itemGenre) {
        this.itemGenre = itemGenre;
    }

    
    public movies(){
        super();
        setItemGenre(null);
    }
    public movies(String ID,String title,Boolean DayLoan,int copies,double fees,String genre){
        super(ID, title, DayLoan, copies, fees);
        setItemGenre(genre);
    }
}
