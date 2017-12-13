package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import book.net.mindview.util.TextFile;

/**
* 匿名内部类，回调，策略模式
* Pattern，Collections，Arrays
* @Author sl
* @Date 2017年12月1日 下午2:52:22
* @Version 1.0
* 
*/
public class Practice1 {

	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex); // Java 1.8之前匿名内部类传参数需要给参数添加final才不会报错
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}
	
	public static void main(String[] args) {
		File path = new File("./data/");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
//			list = path.list(new FilenameFilter() {
//				private Pattern pattern = Pattern.compile(args[0]);
//				@Override
//				public boolean accept(File dir, String name) {
					// 下面方法匹配的是整个字符串，而不是查找当前字符串是否存在该文件中
//					return pattern.matcher(name).find() && !Collections.disjoint(Arrays.asList(args)
//							.subList(1, args.length), new TextFile(dir.getPath() + File.separator + name));
//				}
//			});
			list = path.list(new DirFilter(args[0]));
		}
		
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dir : list) {
			System.out.println(dir);
		}
	}

}

class DirFilter implements FilenameFilter{

	private Pattern pattern;
	
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}
	
	@Override
	// 这里使用到策略模式，accept接受两个参数一个是当前File指定的目录，还有一个参数是当前文件名name，两个加起来才是文件名
	public boolean accept(File dir, String name) { 
		TextFile tf = new TextFile(dir.getAbsolutePath() + File.separator + name);
		for (String str : tf) {
//			if (pattern.matcher(str).matches()) { // 当前字符串与pattern是否匹配
			if (pattern.matcher(str).find()) { // 查看当前字符串中是否存在pattern
				return true;
			}
		}
		return false;
	}
	
}