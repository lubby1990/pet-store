package com.lubby.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lubby
 * @date 2015年3月28日 下午7:01:26
 *
 */

public class Test {
	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
//		File file = new File("D:\\test");
		Test test = new Test();
//		test.readFile(file);
		System.out.println(test.fCount(5));
//		for(Integer n : list){
//			System.out.println(n);
//		}

	}

	public void readFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				System.out.println(f.getName());
				readFile(f);
			}
		} else {
			System.out.println(file.getName());
			return;
		}
	}

	public  int fCount(int a) {
		int result ;
		if(a == 1 || a==2){
			return 1;
		}else{
			return  fCount(a - 1) + fCount(a - 2);
		}
//		list.add(result);
//		return result;
	}
}
