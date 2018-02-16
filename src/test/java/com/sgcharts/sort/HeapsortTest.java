package com.sgcharts.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.sgcharts.sort.Heapsort.sort;

public class HeapsortTest {
	private static final Logger log = LoggerFactory.getLogger(HeapsortTest.class);

	@Test(groups = {"Heapsort.sort"})
	public void sort_should_return_empty_list_when_list_is_empty() {
		ArrayList e = new ArrayList<>();
		ArrayList<Integer> is = new ArrayList<>();
		sort(is);
		Assert.assertEquals(is, e);
		ArrayList<String> ss = new ArrayList<>();
		sort(ss);
		Assert.assertEquals(ss, e);
	}

}
