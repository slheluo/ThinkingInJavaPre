package io;

import java.io.File;
import java.io.IOException;

import book.net.mindview.util.Directory;

/**
 * 
 * @Author sl
 * @Date 2017年12月7日 上午10:56:32
 * @Version 1.0
 * 
 */
public class Practice5 {

	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy() {
		      public void process(File file) {
		        System.out.println(file);
		      }
		    }, ".*java.*$").start(args);
	}

}

class ProcessFiles {
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String regex;

	public ProcessFiles(Strategy strategy, String regex) {
		this.strategy = strategy;
		this.regex = regex;
	}

	public void start(String[] args) {
		try {
			if (args.length == 0)
				processDirectoryTree(new File("."));
			else
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsolutePath(), regex))
			strategy.process(file.getCanonicalFile());
	}
}