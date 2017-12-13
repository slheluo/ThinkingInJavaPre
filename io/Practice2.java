package io;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @Author sl
 * @Date 2017年12月1日 下午2:52:22
 * @Version 1.0
 * 
 */

public class Practice2 {

	public static void main(String[] args) {
		SortedDirList sdList = new SortedDirList("./data/");
		sdList.list();
		sdList.list("2");
	}

}

class SortedDirList {
	
	private String[] list;
	
	public SortedDirList(String path) {
		File f = new File(path);
		list = f.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
	}
	
	public void list() {
		for (String dir : list) {
			System.out.println(dir);
		}
	}
	
	public void list(String regex) {
		Pattern pattern = Pattern.compile(regex);
		for (String dir : list) {
			if (pattern.matcher(dir).find()) {
				System.out.println(dir);
			}
		}
	}
	
}