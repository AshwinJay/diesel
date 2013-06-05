package com.javaforu.dsl.stocks;

import com.javaforu.dsl.stocks.groovy.BetterGroovyScript;
import com.javaforu.dsl.stocks.groovy.SimpleGroovyScript;
import com.javaforu.dsl.stocks.jruby.BetterJRubyScript;
import com.javaforu.dsl.stocks.jruby.SimpleJRubyScript;
import com.javaforu.dsl.stocks.json.BeansAndJson;
import com.javaforu.dsl.stocks.yaml.BeansAndYaml;
import com.javaforu.dsl.stocks.yaml.SimpleYaml;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class RunAll {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println("Running " + SimpleYaml.class.getName());
        SimpleYaml.main(args);
        System.out.println("======================================");

        System.out.println("\nRunning " + BeansAndYaml.class.getName());
        BeansAndYaml.main(args);
        System.out.println("======================================");

        System.out.println("\nRunning " + BeansAndJson.class.getName());
        BeansAndJson.main(args);
        System.out.println("======================================");

        System.out.println("\nRunning " + SimpleGroovyScript.class.getName());
        SimpleGroovyScript.main(args);
        System.out.println("======================================");

        System.out.println("\nRunning " + BetterGroovyScript.class.getName());
        BetterGroovyScript.main(args);
        System.out.println("======================================");

        System.out.println("\nRunning " + SimpleJRubyScript.class.getName());
        SimpleJRubyScript.main(args);
        System.out.println("======================================");

        System.out.println("\nRunning " + BetterJRubyScript.class.getName());
        BetterJRubyScript.main(args);
        System.out.println("======================================");
    }
}
