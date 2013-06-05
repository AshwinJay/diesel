package com.javaforu.dsl.stocks.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javaforu.dsl.stocks.bean.Stocks;
import com.javaforu.dsl.stocks.yaml.BeansAndYaml;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class BeansAndJson {
    public static void main(String[] args) {
        InputStream is = BeansAndYaml.class.getResourceAsStream("/stocks_java_bean.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        //Load the JSON file as Stocks
        Stocks stocks = gson.fromJson(new InputStreamReader(is), Stocks.class);
        System.out.println("JSON contents loaded as Stocks:\n" + stocks);
    }
}
