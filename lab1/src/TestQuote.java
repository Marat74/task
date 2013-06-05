import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class TestQuote {
    @Test
    public void testQuote() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        assertNotNull("Object is not null", quote);
        assertEquals("Symbol is ok",quote.getSymbol(),"a");
        assertEquals("Date is ok",quote.getDate(),date);
        assertEquals("Open price is ok",quote.getOpenPrice(),200.0,0.1);
        assertEquals("High price is ok",quote.getHighPrice(),300.0,0.1);
        assertEquals("Low price is ok",quote.getLowPrice(),100.0,0.1);
        assertEquals("Close price is ok",quote.getClosePrice(),107.0,0.1);
    }
    @Test
    public void testQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        assertNotNull("Object is not null", storage);
        assertEquals("Symbol is ok",storage.quotesList.get(0).getSymbol(),"a");
        assertEquals("Date is ok",storage.quotesList.get(0).getDate(),date);
        assertEquals("Open price is ok",storage.quotesList.get(0).getOpenPrice(),200.0,0.1);
        assertEquals("High price is ok",storage.quotesList.get(0).getHighPrice(),300.0,0.1);
        assertEquals("Low price is ok",storage.quotesList.get(0).getLowPrice(),100.0,0.1);
        assertEquals("Close price is ok",storage.quotesList.get(0).getClosePrice(),107.0,0.1);
        assertEquals("Volume is ok",storage.quotesList.get(0).getVolume(),1.0,0.1);
    }
    @Test
    public void testToStringQuote(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        assertEquals(quote.toString(),"\"a\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0");
    }
    @Test
    public void testToStringQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        assertEquals(storage.quotesList.get(0).toString(),"\"a\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0");
    }
    @Test
    public void testQuotesEquals(){
    	Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote1=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote2=new Quote("b",date,200.0,300.0,100.0,107.0,1.0);
        assertFalse(quote.equals(quote2));
        
    }
    @Test
    public void testMap(){
    	QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2010);
        cal1.set(Calendar.MONTH, 1);
        cal1.set(Calendar.DAY_OF_MONTH, 2);
        Date begin = cal1.getTime();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.YEAR, 2012);
        cal2.set(Calendar.MONTH, 1);
        cal2.set(Calendar.DAY_OF_MONTH, 2);
        Date end = cal2.getTime();
    	Map<String, List<IQuote>> map=storage.getStocks(begin,end);
    }
    @Test 
    public void testClear(){
    	QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        storage.remove(quote);
        storage.clear();
    }
    @Test
    public void testToStringWithExactSymbol(){
    	QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        assertEquals(storage.toString(),"\"a\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0");
    }
}