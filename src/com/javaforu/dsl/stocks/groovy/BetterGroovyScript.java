package com.javaforu.dsl.stocks.groovy;

import com.javaforu.dsl.stocks.bean.Stocks;
import com.javaforu.dsl.stocks.bean.Stocks.Buy;
import com.javaforu.dsl.stocks.bean.Stocks.Sell;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class BetterGroovyScript {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        CompilerConfiguration cc = new CompilerConfiguration();
        cc.setScriptBaseClass(AbstractStocksScript.class.getName());
        GroovyShell shell = new GroovyShell(cc);

        InputStream is = BetterGroovyScript.class.getResourceAsStream("/stocks_better.groovy");
        InputStreamReader isr = new InputStreamReader(is);
        GroovyCodeSource gcs = new GroovyCodeSource(isr, "BetterStocksScript1", "/groovy/shell");
        Stocks stocks = (Stocks) shell.evaluate(gcs);

        System.out.println("Groovy script execution produced:\n" + stocks);
    }

    public static abstract class AbstractStocksScript extends Script {
        public static Stocks start() {
            return new Stocks();
        }

        public static Buy buy() {
            return new Buy();
        }

        public static Sell sell() {
            return new Sell();
        }
    }
}
