package com.javaforu.dsl.stocks.groovy;

import com.javaforu.dsl.stocks.bean.Stocks;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.Script;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class SimpleGroovyScript {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        GroovyClassLoader loader = new GroovyClassLoader(SimpleGroovyScript.class.getClassLoader());

        InputStream is = SimpleGroovyScript.class.getResourceAsStream("/stocks_simple.groovy");
        InputStreamReader isr = new InputStreamReader(is);
        GroovyCodeSource gcs = new GroovyCodeSource(isr, "SimpleStocksScript1", "/groovy/shell");
        Class groovyScriptClass = loader.parseClass(gcs);

        System.out.println(
                groovyScriptClass + " [Script class? " + (Script.class.isAssignableFrom(groovyScriptClass)) + "]");

        Script stocksScript1 = (Script) groovyScriptClass.newInstance();
        Stocks stocks = (Stocks) stocksScript1.run();

        System.out.println("Groovy script execution produced:\n" + stocks);
    }
}
