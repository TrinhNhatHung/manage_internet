package com.fa.utils;

public class PagingUtils {
	public final static int rowPerPage = 10;

	public static int getTotalPages(long rowCount) {
		int result = (int) (rowCount / rowPerPage);
		return result + (rowCount % rowPerPage > 0 ? 1 : 0);
	}
}
