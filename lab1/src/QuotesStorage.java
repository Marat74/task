import java.util.*;

public class QuotesStorage implements  IQuotesStorage{
    QuotesStorage(){
        quotesList=new ArrayList<IQuote>();
    }
    public void addStock(IQuote stock){
        quotesList.add(stock);
    }
    public Map<String, List<IQuote>> getStocks(Date begin, Date end){
        Map<String,List<IQuote>> map = new HashMap<String, List<IQuote>>();
        for (int i=0; i<quotesList.size(); i++){
            if ((quotesList.get(i).getDate().after(begin))&&(quotesList.get(i).getDate().before(end))){
                map.put(quotesList.get(i).getSymbol(),getStocks(quotesList.get(i).getSymbol(),begin,end));
            }
        }
        return map;
    }
    public List<IQuote> getStocks(String symbol, Date begin, Date end){
        List<IQuote> returnQuotesList=new ArrayList<IQuote>();
        for (int i=0; i<quotesList.size(); i++){
            if (quotesList.get(i).getSymbol().equals(symbol)){
                if ((quotesList.get(i).getDate().after(begin))&&(quotesList.get(i).getDate().before(end))){
                    returnQuotesList.add(quotesList.get(i));
                }
            }
        }
        return returnQuotesList;
    }
    public void clear(){
        quotesList.clear();
    }
    public void remove(IQuote stock){
        quotesList.remove(stock);
    }
    //@return string with exact symbol
    private String toStringWithExactSymbol(String symbol){
        int quoteAmount=0;
        Date startDate=quotesList.get(0).getDate();// начальное значение startDate
        Date finishDate=quotesList.get(0).getDate();
        Double maxPrice = 0.0;
        Double lowPrice = 10000.0;
        for (int i=0;i<quotesList.size();i++){
        if (quotesList.get(i).getSymbol().equals(symbol)){
            quoteAmount++;//количество quote
            if (quotesList.get(i).getDate().before(startDate)){
                startDate=quotesList.get(i).getDate();
            }
            if (quotesList.get(i).getDate().after(finishDate)){
                finishDate=quotesList.get(i).getDate();
            }
            if (quotesList.get(i).getHighPrice()>maxPrice){
                maxPrice=quotesList.get(i).getHighPrice();
            }
            if (quotesList.get(i).getLowPrice()<lowPrice){
                lowPrice=quotesList.get(i).getLowPrice();
            }
        }
        }
        String returnString="\""+symbol+"\""+","+quoteAmount+" stocks"+", Start date="+startDate.toString()+", End date="
                +finishDate+", Max price="+maxPrice+", Low Price ="+lowPrice;
        return returnString;
    }
    //@return array of quotesList symbols
    private ArrayList<String> getSymbolArray(){
       ArrayList<String> symbolArray= new ArrayList<String>();
       for (int i=0;i<quotesList.size();i++){
           String symbol=quotesList.get(i).getSymbol();
           if (symbolArray.size()==0){
               symbolArray.add(symbol);
           }
           boolean isNotUnique=false;
           for (int j=0;j<symbolArray.size();j++){
                if (symbolArray.get(j).equals(symbol)){
                    isNotUnique=true;
                }
           }
           if (!(isNotUnique)){
                symbolArray.add(symbol);
           }
       }
       return symbolArray;
    }
    public String toString(){
        String returnString="";
        for (int i=0;i<getSymbolArray().size();i++){
            returnString+=toStringWithExactSymbol(getSymbolArray().get(i));
        }
        return returnString;
    }
    public List<IQuote> quotesList= new ArrayList<IQuote>();
}
