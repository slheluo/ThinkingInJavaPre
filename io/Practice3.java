package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import book.net.mindview.util.TextFile;

/**
 *
 * @Author sl
 * @Date 2017年12月1日 下午10:38:58
 * @Version 1.0
 * 
 */

public class Practice3 {

	public static void main(String[] args) {
		File path = new File("./data/");
		File[] list;
		list = path.listFiles(new DirFilter(".*final.*$"));
		
		int sum = 0;
		for (File file : list) {
			System.out.println(file.getName());
			sum += file.length();
		}
		System.out.println(sum);
	}

}

class DirFilter2 implements FilenameFilter{

	private Pattern pattern;
	
	public DirFilter2(String regex) {
		pattern = Pattern.compile(regex);
	}
	
	@Override
	// 这里使用到策略模式，accept接受两个参数一个是当前File指定的目录，还有一个参数是当前文件名name，两个加起来才是文件名
	public boolean accept(File dir, String name) { 
		TextFile tf = new TextFile(dir.getAbsolutePath() + File.separator + name);
		for (String str : tf) {
			if (pattern.matcher(str).matches()) { // 当前字符串与pattern是否匹配
//			if (pattern.matcher(str).find()) { // 查看当前字符串中是否存在pattern
				return true;
			}
		}
		return false;
	}
	
}