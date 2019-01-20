package com.sgcharts.collections.sort;

import java.util.ArrayList;
import java.util.Comparator;

public interface Sort {
    static <T extends Comparable<? super T>> void sort(ArrayList<T> a) {}
    static <T> void sort(ArrayList<T> a, Comparator<? super T> c) {}
}
