package com.hotmail.nickcooke;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NaturalSortComparatorTest {

//    Comparator comparator = new NaturalSortComparator();
    Comparator comparator = new NaturalSortComparatorStringBuilder();
//    Comparator comparator = new NaturalSortComparatorCharArray();

    @Test
    public void testSingleAlphaChars(){
        List<String> sorted = Arrays.asList("a","b","c");
        List<String> unsorted = Arrays.asList("c","b","a");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testSingleNumbers(){
        List<String> sorted = Arrays.asList("2","3","5");
        List<String> unsorted = Arrays.asList("3","5","2");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testLongerNumbers(){
        List<String> sorted = Arrays.asList("2","3","22");
        List<String> unsorted = Arrays.asList("3","22","2");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testSimpleMixture(){
        List<String> sorted = Arrays.asList("a1","a2","a3");
        List<String> unsorted = Arrays.asList("a3","a1","a2");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testLessSimpleMixture(){
        List<String> sorted = Arrays.asList("9", "a","a1","a2","a2b","a2bb", "a11","ab");
        List<String> unsorted = Arrays.asList("a11","a2b","a1", "9","a2","ab","a", "a2bb");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testDebug(){
        List<String> sorted = Arrays.asList( "a","a1");
        List<String> unsorted = Arrays.asList("a","a1");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testExample(){
        List<String> sorted = Arrays.asList("9.1.1", "10.1.1","photo2.jpg","photo11.jpg");
        List<String> unsorted = Arrays.asList("10.1.1","photo11.jpg","9.1.1", "photo2.jpg");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testLeadingZeroes(){
        List<String> sorted = Arrays.asList("001","01","0001","1");
        List<String> unsorted = Arrays.asList("001","01","0001","1");
//        List<String> sorted = Arrays.asList("1","01");
//        List<String> unsorted = Arrays.asList("1","01");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

    @Test
    public void testLeadingZeroes2(){
        List<String> sorted = Arrays.asList("1A","01B","001C","0001D");
        List<String> unsorted = Arrays.asList("001C","01B","0001D","1A");
        Collections.sort(unsorted, comparator);
        Assert.assertEquals(sorted, unsorted);
    }

}