package util;

import java.util.List;

/**
 * 此类，封装了相关的分页信息
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public class PagerUtil<T> {
	// 1)当前页(currentPage) -> cp=3
	private int currentPage;

	// 2)总页数(totalPageCount) -> 需要计算
	private int totalPageCount;

	// 3)每页显示记录数(pageCount) -> 8
	private int pageCount;

	// 4)总记录数(totalRecords) -> 总记录数？
	private int totalRecords;

	// 5)当前页显示的数据集合(data) -> SQL语句
	private List<T> data;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {

		if (currentPage <= 0) {
			this.currentPage = 1;
		} else if (currentPage > getTotalPageCount()) {
			this.currentPage = getTotalPageCount();
		} else {
			this.currentPage = currentPage;
		}

	}

	// 返回总页数
	public int getTotalPageCount() {

		// 整除：总记录数 / 每页显示记录数
		// 不整除 : 总记录数 / 每页显示记录数 + 1

		// 30 / 5 = 6
		// 30 / 7 = 4 + 1

		if (totalRecords % pageCount == 0) {
			totalPageCount = totalRecords / pageCount;
		} else {
			totalPageCount = totalRecords / pageCount + 1;
		}

		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
