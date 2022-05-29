package com.example.giftlara;

import java.util.Comparator;

public class ModelClass {

    private int giftImage;
    private String giftName;
    private int giftPrice;
    private int giftRating;

    //new code
    ModelClass (int imageview ,String textview1,int textview2,int textview3)
    {
        this.giftImage =imageview;
        this.giftName =textview1;
        this.giftPrice =textview2;
        this.giftRating =textview3;
    }

    // Defining collections comparator
    // using collections comparator to sort the list. This collections comparator uses merge sort algorithm whose time complexity
    // is O(n*log(n)) which guarantee stable and efficient sorting.

    // sort in ascending order
    public static Comparator<ModelClass> modelClassNameAZComparator = new Comparator<ModelClass>() {
        @Override
        public int compare(ModelClass m1, ModelClass m2) {
            return m1.getGiftName().compareTo(m2.getGiftName());
        }
    };

    // sort in descending order
    public static Comparator<ModelClass> modelClassNameZAComparator = new Comparator<ModelClass>() {
        @Override
        public int compare(ModelClass m1, ModelClass m2) {
            return m2.getGiftName().compareTo(m1.getGiftName());
        }
    };

    public static Comparator<ModelClass> modelClassPriceAscendingComparator = new Comparator<ModelClass>() {
        @Override
        public int compare(ModelClass m1, ModelClass m2) {
            return m1.getGiftPrice() - m2.getGiftPrice();
        }
    };

    public static Comparator<ModelClass> modelClassPriceDescendingComparator = new Comparator<ModelClass>() {
        @Override
        public int compare(ModelClass m1, ModelClass m2) {
            return m2.getGiftPrice() - m1.getGiftPrice();
        }
    };

    public static Comparator<ModelClass> modelClassRatingAscendingComparator = new Comparator<ModelClass>() {
        @Override
        public int compare(ModelClass m1, ModelClass m2) {
            return m1.getGiftRating() - m2.getGiftRating();
        }
    };

    public static Comparator<ModelClass> modelClassRatingDescendingComparator = new Comparator<ModelClass>() {
        @Override
        public int compare(ModelClass m1, ModelClass m2) {
            return m2.getGiftRating() - m1.getGiftRating();
        }
    };

    public int getGiftImage() {
        return giftImage;
    }

    public String getGiftName() {
        return giftName;
    }

    public int getGiftPrice() {
        return giftPrice;
    }

    public int getGiftRating() {
        return giftRating;
    }
}
