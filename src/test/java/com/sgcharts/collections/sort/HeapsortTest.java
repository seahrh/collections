package com.sgcharts.collections.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.sgcharts.collections.sort.Heapsort.sort;

public class HeapsortTest {

	@Test(groups = {"Heapsort.sort"})
	public void sort_should_noop_when_list_is_empty() {
		ArrayList<Integer> is = new ArrayList<>();
		sort(is);
		Assert.assertEquals(is.isEmpty(), true);
		ArrayList<String> ss = new ArrayList<>();
		sort(ss);
		Assert.assertEquals(ss.isEmpty(), true);
		ArrayList<Double> ds = new ArrayList<>();
		sort(ds);
		Assert.assertEquals(ds.isEmpty(), true);
		ArrayList<LocalDate> dates = new ArrayList<>();
		sort(dates);
		Assert.assertEquals(dates.isEmpty(), true);
	}

	@Test(groups = {"Heapsort.sort"})
	public void sort_should_sort_list_when_list_has_only_one_element() {
		ArrayList<Integer> is = new ArrayList<>(Collections.singletonList(1));
		ArrayList<Integer> eis = new ArrayList<>(is);
		sort(is);
		Assert.assertEquals(is, eis);
		ArrayList<String> ss = new ArrayList<>(Collections.singletonList("head"));
		ArrayList<String> ess = new ArrayList<>(ss);
		sort(ss);
		Assert.assertEquals(ss, ess);
		ArrayList<Double> ds = new ArrayList<>(Collections.singletonList(1.1));
		ArrayList<Double> eds = new ArrayList<>(ds);
		sort(ds);
		Assert.assertEquals(ds, eds);
		ArrayList<LocalDate> dates = new ArrayList<>(Collections.singletonList(
				LocalDate.parse("2018-02-16", DateTimeFormatter.ISO_DATE)));
		ArrayList<LocalDate> edates = new ArrayList<>(dates);
		sort(dates);
		Assert.assertEquals(dates, edates);
	}

	@Test(groups = {"Heapsort.sort"})
	public void sort_should_sort_list_when_list_is_odd_length() {
		ArrayList<Integer> is = new ArrayList<>(Arrays.asList(7, 3, 1, 5, 2, 4, 6));
		ArrayList<Integer> eis = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		sort(is);
		Assert.assertEquals(is, eis);
		ArrayList<String> ss = new ArrayList<>(Arrays.asList("f", "c", "b", "a", "e", "g", "d"));
		ArrayList<String> ess = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		sort(ss);
		Assert.assertEquals(ss, ess);
		ArrayList<Double> ds = new ArrayList<>(Arrays.asList(7.7, 3.3, 1.1, 5.5, 2.2, 4.4, 6.6));
		ArrayList<Double> eds = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7));
		sort(ds);
		Assert.assertEquals(ds, eds);
		ArrayList<LocalDate> dates = new ArrayList<>(Arrays.asList(
				LocalDate.parse("2018-03-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-04-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-03-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-02", DateTimeFormatter.ISO_DATE)
		));
		ArrayList<LocalDate> edates = new ArrayList<>(Arrays.asList(
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-02", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-03-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-03-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-04-01", DateTimeFormatter.ISO_DATE)
		));
		sort(dates);
		Assert.assertEquals(dates, edates);
	}

	@Test(groups = {"Heapsort.sort"})
	public void sort_should_sort_list_when_list_is_even_length() {
		ArrayList<Integer> is = new ArrayList<>(Arrays.asList(7, 3, 1, 5, 2, 8, 4, 6));
		ArrayList<Integer> eis = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		sort(is);
		Assert.assertEquals(is, eis);
		ArrayList<String> ss = new ArrayList<>(Arrays.asList("f", "c", "b", "h", "a", "e", "g", "d"));
		ArrayList<String> ess = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
		sort(ss);
		Assert.assertEquals(ss, ess);
		ArrayList<Double> ds = new ArrayList<>(Arrays.asList(7.7, 3.3, 1.1, 5.5, 2.2, 4.4, 8.8, 6.6));
		ArrayList<Double> eds = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8));
		sort(ds);
		Assert.assertEquals(ds, eds);
		ArrayList<LocalDate> dates = new ArrayList<>(Arrays.asList(
				LocalDate.parse("2018-03-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-04-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-03-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-02", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE)
		));
		ArrayList<LocalDate> edates = new ArrayList<>(Arrays.asList(
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-02", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-03-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-03-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-04-01", DateTimeFormatter.ISO_DATE)
		));
		sort(dates);
		Assert.assertEquals(dates, edates);
	}

	@Test(groups = {"Heapsort.sort"})
	public void sort_should_sort_list_when_list_has_duplicates() {
		ArrayList<Integer> is = new ArrayList<>(Arrays.asList(4, 3, 1, 2, 4, 2, 1, 3));
		ArrayList<Integer> eis = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4));
		sort(is);
		Assert.assertEquals(is, eis);
		ArrayList<String> ss = new ArrayList<>(Arrays.asList("b", "c", "a", "c", "a", "d", "b", "d"));
		ArrayList<String> ess = new ArrayList<>(Arrays.asList("a", "a", "b", "b", "c", "c", "d", "d"));
		sort(ss);
		Assert.assertEquals(ss, ess);
		ArrayList<Double> ds = new ArrayList<>(Arrays.asList(3.3, 2.2, 1.1, 4.4, 4.4, 1.1, 2.2, 3.3));
		ArrayList<Double> eds = new ArrayList<>(Arrays.asList(1.1, 1.1, 2.2, 2.2, 3.3, 3.3, 4.4, 4.4));
		sort(ds);
		Assert.assertEquals(ds, eds);
		ArrayList<LocalDate> dates = new ArrayList<>(Arrays.asList(
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE)
		));
		ArrayList<LocalDate> edates = new ArrayList<>(Arrays.asList(
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2017-12-31", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE),
				LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE)
		));
		sort(dates);
		Assert.assertEquals(dates, edates);
	}

}
