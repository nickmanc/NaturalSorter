package com.hotmail.nickcooke;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NaturalSorterTest {

    @Test
    public void testSingleAlphaChars(){
        List<String> sorted = getList("a","b","c");
        List<String> unsorted = getList("c","b","a");
        Collections.sort(unsorted, new NaturalSorter());
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testSingleNumbers(){
        List<String> sorted = getList("2","3","5");
        List<String> unsorted = getList("3","5","2");
        Collections.sort(unsorted, new NaturalSorter());
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testLongerNumbers(){
        List<String> sorted = getList("2","3","22");
        List<String> unsorted = getList("3","22","2");
        Collections.sort(unsorted, new NaturalSorter());
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testSimpleMixture(){
        List<String> sorted = getList("a1","a2","a3");
        List<String> unsorted = getList("a3","a1","a2");
        Collections.sort(unsorted, new NaturalSorter());
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testLessSimpleMixture(){
//        List<String> sorted = getList("a1","a11","a2b");
//        List<String> unsorted = getList("a1","a2b","a11");
        List<String> sorted = getList("a","a1","a2","a11","a2b","ab");
        List<String> unsorted = getList("a11","a2b","a1","a2","ab","a");
        Collections.sort(unsorted, new NaturalSorter());
        Assert.assertEquals(sorted, unsorted);
    }


    private List getList(String ... strings){
        return Arrays.asList(strings);
    }
}