package com.javaforu.dsl.stocks.yaml;

import com.javaforu.dsl.stocks.bean.Stocks;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class BeansAndYaml {
    public static void main(String[] args) {
        InputStream is = BeansAndYaml.class.getResourceAsStream("/stocks_java_bean.yaml");
        Yaml yaml = new Yaml();

        //Load the YAML file as Stocks
        Stocks stocks = yaml.loadAs(is, Stocks.class);
        System.out.println("YAML contents loaded as Stocks:\n" + stocks);
    }
}
