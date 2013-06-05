package com.javaforu.dsl.stocks.jruby;

import com.javaforu.dsl.stocks.bean.Stocks;
import org.jruby.embed.ScriptingContainer;

import java.io.InputStream;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class SimpleJRubyScript {
    public static void main(String[] args) {
        ScriptingContainer container = new ScriptingContainer();

        InputStream is = SimpleJRubyScript.class.getResourceAsStream("/stocks_simple.jruby");

        Stocks stocks = (Stocks) container.runScriptlet(is, "SimpleStocksScript1");

        System.out.println("JRuby script execution produced:\n" + stocks);
    }
}
