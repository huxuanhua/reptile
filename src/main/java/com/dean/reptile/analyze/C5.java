package com.dean.reptile.analyze;

import com.dean.reptile.bean.Accessories;
import com.dean.reptile.bean.Jewelry;
import com.dean.reptile.bean.Purchase;
import com.dean.reptile.bean.Transaction;
import com.dean.reptile.util.TimeTool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class C5 {
    private int counter = 0;
    private Document doc = null;
    private C5() {
    }

    public C5(String html) {
        doc = Jsoup.parse(html);
    }

    public Jewelry getJewelry () {
        Jewelry jewelry = new Jewelry();
        try {
            Element name = doc.select("div.name").first();
            jewelry.setName(name.text());
            Elements heros = doc.select("div.ft-gray").select(".mt-5");

            String quality = heros.first().children().get(1).text();
            jewelry.setQuality(quality);

            String rarity = heros.first().children().get(2).text();
            jewelry.setRarity(rarity);

            String hero = heros.last().text();
            if (hero.equals("")) {
                // 配置信使
                Elements x1 = heros.first().children();
                hero = x1.get(3).text();
            } else {
                // 正常英雄
                hero = hero.split("：")[1];
            }
            jewelry.setHeroName(hero);

            Element priceNode = doc.select("div.hero").first();
            String priceText = priceNode.child(0).text();
            String price = priceText.substring(priceText.indexOf("￥") + 1, priceText.indexOf(" )"));
            jewelry.setIndicativePrice(Double.valueOf(price));

            Elements prices = doc.select("span.ft-gold");
            String lastPriceText = prices.first().text();
            String lastPrice = lastPriceText.substring(lastPriceText.indexOf("￥") + 1);

            jewelry.setLastPrice(Double.valueOf(lastPrice));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return jewelry;
    }

    public List<Transaction> getTransactionList() {

        return null;
    }

//    public Transaction getTransaction() {
//        Transaction transaction = new Transaction();
//
//        Elements priceNodes = doc.select("span.ft-gold");
//        int goldNum = 3 + counter;
//        if (goldNum >= priceNodes.size()) {
//            return null;
//        }
//        String price = priceNodes.get(goldNum).text();
//        //
//        transaction.setTransactionPrice(Double.valueOf(price.substring(1)));
//        Element timeNode = doc.select("td.item-name").get(counter).nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling();
//        String time = timeNode.text();
//        //
//        transaction.setTransactionTime(TimeTool.StringToUnixTime("20" + time, null));
//        Element nameNode = doc.select("span.name-ellipsis-130").get(counter);
//        //
//        transaction.setTransactionName(nameNode.text());
//        counter += 1;
//        return transaction;
//    }

    public Purchase getPurchase(String html) {
        Purchase purchase = new Purchase();

        try {
            Document doc = Jsoup.parse(html);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



        return purchase;
    }
}
