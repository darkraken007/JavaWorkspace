package test.main;

import main.LoadTester;


public class TestDriver
{

    public static void main( String[] args ) throws InterruptedException
    {
        String[] urls = { "abc", "efg", "hgt" };
        LoadTester loadTester = new LoadTester( urls, 100, 400 );
        loadTester.test();
    }

}
