package client;

import javax.xml.ws.BindingProvider;

import com.example.stockquote.StockQuote;
import com.example.stockquote.StockQuoteService;
import com.example.stockquote.TradePrice;
import com.example.stockquote.TradePriceRequest;

public class StockQuoteClient {
	public String evaluateStockQuotes() {
		StockQuoteService srv = new StockQuoteService();
		StockQuote port = srv.getStockQuotePort();
		setBindings((BindingProvider) port);
		TradePriceRequest req = new TradePriceRequest();
		req.setTickerSymbol("idf");
		TradePrice price = port.getLastTradePrice(req);
		return "" + price.getPrice();
	}

	private static void setBindings(BindingProvider bp) {
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:9987/stockquote/");
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
				"anonymous");
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
				"anonymous");
	}

	public static void main(String[] args) {
		System.out.println(new StockQuoteClient ().evaluateStockQuotes());
	}
}
