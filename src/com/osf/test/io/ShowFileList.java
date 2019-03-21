package com.osf.test.io;

import java.io.File;

public class ShowFileList {
	public static void main(String[] args) {
		File tFile = new File("D:\\test");
		File[] files = tFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				File[] subFiles = f.listFiles();
				for (int x = 0; x < subFiles.length; x++) {
					System.out.println(subFiles[x].getName());
				}
			} else {
				System.out.println(files[i].getName());
			}
		}
	}
}
