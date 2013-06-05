import java.util.Date;

public class Quote implements IQuote {
    Quote(String symbol, Date date, Double openPrice, Double highPrice, Double lowPrice, Double closePrice, Double volume){
        this.symbol=symbol;
        this.date=date;
        this.openPrice=openPrice;
        this.highPrice=highPrice;
        this.lowPrice=lowPrice;
        this.closePrice=closePrice;
        this.volume=volume;
    }
    public String getSymbol(){
        return symbol;
    }
    public Date getDate(){
        return date;
    }
    public double getOpenPrice(){
        return openPrice;
    }
    public double getHighPrice(){
        return highPrice;
    }
    public double getLowPrice()
    {
        return lowPrice;
    }
    public double getClosePrice(){
        return closePrice;
    }
    public double getVolume(){
        return volume;
    }
    public String toString(){
        String returnString;
        returnString="\""+symbol+"\","+date.toString()+",Open="+openPrice+",High="+highPrice
        +",Low="+lowPrice+",Close="+closePrice+",Volume="+volume;
        return returnString;
    }
    @Override
    public boolean equals(Object obj){
        IQuote quote= (IQuote) obj;
        if ((symbol.equals(quote.getSymbol()))&&(date.equals(quote.getDate()))&&(openPrice.equals(quote.getOpenPrice()))&&(highPrice.equals(quote.getHighPrice()))
                &&(lowPrice.equals(quote.getLowPrice()))&&(closePrice.equals(quote.getClosePrice()))){
         return true;
        }
        else
            return false;
    }
    private String symbol;
    private Date date;
    private Double openPrice;
    private Double highPrice;
    private Double lowPrice;
    private Double closePrice;
    private Double volume;
}


