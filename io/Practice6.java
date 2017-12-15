package io;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import book.net.mindview.util.ProcessFiles;

/**
 * lastModified()
 * @Author sl
 * @Date 2017年12月10日 下午9:24:40
 * @Version 1.0
 * 
 */
public class Practice6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date special = dateFormat.parse("2017-12-04 00:00:00");
			new ProcessFiles(new ProcessFiles.Strategy() {
				public void process(File file) {
					long time = file.lastModified();
					Date date = new Date(time);
					if (date.after(special)) {
						System.out.println(file);
					}
				}
			}, ".*java.*$").start(args);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
