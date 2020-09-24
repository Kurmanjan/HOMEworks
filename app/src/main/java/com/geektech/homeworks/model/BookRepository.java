package com.geektech.homeworks.model;

import java.util.ArrayList;
import java.util.List;

public class BookRepository  {
    public static List<BooksModels> booklist = new ArrayList<>();
    public static BooksModels getbook(int position){
        return booklist.get(position);
    }
    public static List<BooksModels> getBooklist(){
        booklist.add(new BooksModels("KJASJKADDKJASH","jcbajkbasjk"));
        booklist.add(new BooksModels("woewmmcckdnnn ","cbdfjbdjbsjdd"));
        booklist.add(new BooksModels("yoygbnvnvfbfgb","dcvvfvfnvffj"));
        booklist.add(new BooksModels("jdjrrfrfkjrvnkvn","nncvnffjfbjv"));
        booklist.add(new BooksModels("zakswkkwkwsn","zmmmjnsnwwnsnw"));
        return booklist;
    }
}
