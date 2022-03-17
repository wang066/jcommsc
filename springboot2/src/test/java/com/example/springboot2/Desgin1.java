package com.example.springboot2;

import java.util.Map;

/**
 * @author: jowang
 * @date: 2018-06-30 10:22
 * @description:
 */
public class Desgin1 {

    public static class Context {
        private int dateId;

        protected Map<String, String> map;
    }

    public static class PugcConetxt extends Context {
        private int score;

        public int getScore() {
            return Integer.valueOf(map.get("score"));
        }
    }

    public static class FeedItem {
        private int dna;
    }

    public static class PugcFeedItem extends FeedItem {
        private int articleId;
    }

    public static class Loader<R extends FeedItem, P extends Context> {
        public R loadOne(P context) {
            return null;
        }
    }

    public static class PugcFeedItemLoader extends Loader<PugcFeedItem, PugcConetxt> {
        @Override
        public PugcFeedItem loadOne(PugcConetxt context) {
            return super.loadOne(context);
        }
    }

    public static void main(String[] args) {
        Loader loader = new PugcFeedItemLoader();

        loader.loadOne(null);
    }

}