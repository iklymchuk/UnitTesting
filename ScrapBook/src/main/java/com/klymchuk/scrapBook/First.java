package com.klymchuk.scrapBook;

/**
 * Created by iklymchuk on 3/1/17.
 */
public class First {

    private Second second;

    public First(Second second) {
        this.second = second;
    }

    public int firstMethodImplementation() {

        try {
            second.secondMethodDeclaration();
        } catch (Exception e) {
           new RuntimeException(e);
        }
        return 1;
    }
}
