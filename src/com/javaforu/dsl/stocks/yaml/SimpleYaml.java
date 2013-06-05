package com.javaforu.dsl.stocks.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */
public class SimpleYaml {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        InputStream is = SimpleYaml.class.getResourceAsStream("/stocks_simple.yaml");
        Yaml yaml = new Yaml();

        //Load the YAML file.
        Map<String, Object> yamlMap = (Map<String, Object>) yaml.load(is);

        walk(yamlMap);
    }

    @SuppressWarnings("unchecked")
    static void walk(Map<String, Object> yamlMap) {
        //Walk the nested maps and lists.
        //We expect orders and watches.

        //Watch is a simple map.
        List<Object> watches = (List<Object>) yamlMap.get("watch");
        System.out.println("\nWatch =");
        //Watch content is a list of simple strings.
        for (Object watch : watches) {
            System.out.println("\t" + watch);
        }

        //Notes is just a string.
        String notes = (String) yamlMap.get("notes");
        System.out.println("\nNotes = \n" + notes);

        //Orders is a simple map.
        List<Object> orders = (List<Object>) yamlMap.get("orders");
        System.out.println("Orders =");
        for (Object o : orders) {
            //Each item in orders is sell or buy.
            Map<String, Object> order = (Map<String, Object>) o;

            for (Entry<String, Object> entry : order.entrySet()) {
                String buyOrSell = entry.getKey();
                System.out.println("\tOrder type is buy? " + buyOrSell.equals("buy"));

                //If the item is buy or sell, then its contents are in turn another map.
                Map<String, Object> orderDetails = (Map<String, Object>) entry.getValue();

                for (Entry<String, Object> entry2 : orderDetails.entrySet()) {
                    switch (entry2.getKey()) {
                        case "symbol":
                            System.out.println("\t\tSymbol = " + ((String) entry2.getValue()).toUpperCase());
                            break;
                        case "qty":
                            System.out.println("\t\tQuantity = " + entry2.getValue());
                            break;
                        case "good for":
                            String[] days = ((String) entry2.getValue()).split(" ");
                            System.out.println("\t\tGood for (days) = " + days[0]);
                            break;

                        case "market":
                            System.out.println("\t\tMarket order");
                            break;

                        case "limit":
                            System.out.println("\t\tLimit order at " + entry2.getValue());
                            break;

                        case "stop limit":
                            String[] sl = ((String) entry2.getValue()).split(" ");
                            System.out.println("\t\tStop at " + sl[0] + " limit " + sl[1]);
                            break;

                        default:
                            throw new IllegalArgumentException("Unrecognized item: " + entry2.getValue());
                    }
                }
            }
        }
    }
}
