package com.javaforu.dsl.stocks.bean;

import java.util.List;

/**
 * Author: Ashwin Jayaprakash
 * Email: ashwin.jayaprakash@gmail.com
 * Web: http://www.ashwinjayaprakash.com
 */

/**
 * JavaBean with property names that are legal Java identifiers - {@link #sellOrders}, {@link Order#getStopLimit()} etc
 * in CamelCase.
 * <p/>
 * Also, all combinations of properties like {@link Order#getLimit()}, {@link Order#getStopLimit()}, {@link
 * Order#getMarket()} have been specified. Null is the default.
 * <p/>
 * So, primitives are not used as they cannot be set to null (Double instead of double - {@link
 * Order#setLimit(Double)}).
 */
public class Stocks {
    List<Buy> buyOrders;

    List<Sell> sellOrders;

    List<String> watch;

    String notes;

    public Stocks() {
    }

    public List<Buy> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<Buy> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<Sell> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<Sell> sellOrders) {
        this.sellOrders = sellOrders;
    }

    public List<String> getWatch() {
        return watch;
    }

    public void setWatch(List<String> watch) {
        this.watch = watch;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Watches:\n");
        if (watch != null) {
            for (String w : watch) {
                sb.append("\t").append(w).append("\n");
            }
        }

        sb.append("Notes:\n").append(notes).append('\n');

        sb.append("Buy orders:\n");
        if (buyOrders != null) {
            for (Buy buy : buyOrders) {
                sb.append("\t").append(buy).append("\n");
            }
        }

        sb.append("Sell orders\n");
        if (sellOrders != null) {
            for (Sell sell : sellOrders) {
                sb.append("\t").append(sell).append("\n");
            }
        }

        sb.append('\n');

        return sb.toString();
    }

    //-----------

    public static class Order {
        String symbol;

        Double qty;

        Double limit;

        String stopLimit;

        Double market;

        String goodFor;

        public Order() {
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Double getQty() {
            return qty;
        }

        public void setQty(Double qty) {
            this.qty = qty;
        }

        public Double getLimit() {
            return limit;
        }

        public void setLimit(Double limit) {
            this.limit = limit;
        }

        public String getStopLimit() {
            return stopLimit;
        }

        public void setStopLimit(String stopLimit) {
            this.stopLimit = stopLimit;
        }

        public Double getMarket() {
            return market;
        }

        public void setMarket(Double market) {
            this.market = market;
        }

        public String getGoodFor() {
            return goodFor;
        }

        public void setGoodFor(String goodFor) {
            this.goodFor = goodFor;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
            sb.append("{");
            sb.append("symbol=").append(symbol);
            sb.append(", qty=").append(qty);
            sb.append(", goodFor=").append(goodFor);
            sb.append(", limit=").append(limit);
            sb.append(", stopLimit=").append(stopLimit);
            sb.append(", market=").append(market);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Buy extends Order {

    }

    public static class Sell extends Order {

    }
}
