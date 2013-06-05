package com.javaforu.dsl.stocks.jruby;

import com.javaforu.dsl.stocks.bean.Stocks;
import org.jruby.embed.ScriptingContainer;

import java.io.InputStream;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class BetterJRubyScript {
    public static void main(String[] args) {
        ScriptingContainer container = new ScriptingContainer();

        InputStream is = BetterJRubyScript.class.getResourceAsStream("BaseStocksScript.jruby");
        container.runScriptlet(is, "BaseStocksScript");

        is = BetterJRubyScript.class.getResourceAsStream("/stocks_better.jruby");
        Stocks stocks = (Stocks) container.runScriptlet(is, "BetterStocksScript1");

        System.out.println("JRuby script execution produced:\n" + stocks);
    }
}
