package org.example;


import Enitys.Book;

public class Main {

    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();

        authorHelper.updateAuthorInf(1);
        bookHelper.updateInf(1);
        bookHelper.getBookAndAuthor();

        authorHelper.createAdd200Authors();
    }
}