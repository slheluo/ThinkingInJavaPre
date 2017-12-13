package io;

import java.io.File;

import book.net.mindview.util.Directory;
import book.net.mindview.util.Directory.TreeInfo;

/**
 * walk()、local()
 * @Author sl
 * @Date 2017年12月6日 上午11:39:39
 * @Version 1.0
 * 
 */

public class Practice4 {

	public static void main(String[] args) {
//		TreeInfo info = Directory.walk(".", ".*txt.*$");
		TreeInfo info = Directory.walk(".", args[0]);
		System.out.println(info);
		int sum = 0;
		for (File file : info.files) {
			sum += file.length();
		}
		System.out.println(sum);
	}

}
