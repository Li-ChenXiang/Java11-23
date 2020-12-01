package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		// 创建学生集合
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 1; i++) {
			Student stu = new Student();
			// 用Scanner类实现输入
			Scanner sc = new Scanner(System.in);
			System.out.println("学号：");
			int id = sc.nextInt();
			stu.setId(id);
			System.out.println("班级：");
			String bj = sc.next();
			stu.setBj(bj);
			System.out.println("姓名：");
			String name = sc.next();
			stu.setName(name);

			// 对象实例化
			/*
			 * Student stu = new Student(); stu.setId(id); stu.setBj(bj); stu.setName(name);
			 */

			students.add(stu);
		}
		System.out.println("学生信息已保存到文件中！");

		// 读取poem.txt中的信息
		FileInputStream poem = new FileInputStream("C:\\Users\\李晨香\\Desktop\\poem.txt");
		InputStreamReader p = new InputStreamReader(poem, "UTF-8");// 处理中文乱码
		BufferedReader br = new BufferedReader(p);
		// System.out.println("字符集："+isr.getEncoding());
		String line = br.readLine();
		// String line ="汉皇重色思倾国";
		// String line=null;
		StringBuffer sb = new StringBuffer();
		sb.append(line);
		int i;
		int j = 0;
		for (i = 7; i <= sb.length(); i += 8) {
			if (i == 7) {
				sb.insert(i, "，");
			} else if ((i - j) % 7 == 0 && (i - j) % 14 != 0) {
				sb.insert(i, "，");
			} else if ((i - j) % 14 == 0) {
				sb.insert(i, "。");
			}
			j = j + 1;
		}
		System.out.println(sb);

		// 目的地student.txt
		// 获取集合中的每一个Student对象
		FileOutputStream student = new FileOutputStream("C:\\Users\\李晨香\\Desktop\\student.txt");
		OutputStreamWriter s = new OutputStreamWriter(student, "UTF-8");
		BufferedWriter bw = new BufferedWriter(s);
		bw.write("学号\t\t");
		bw.write("班级\t\t");
		bw.write("姓名\t");
		bw.newLine();
		bw.flush();

		for (Student stu : students) {
			// 把student信息存到文本文件中
			// 数据源Student stu
			// 目的地Student.txt
			int id = stu.getId();
			String bj = stu.getBj();
			String name = stu.getName();

			bw.write(id + "\t");
			bw.write(bj + "\t\t");
			bw.write(name + "\t");
			bw.newLine();
			bw.flush();
		}
		bw.write("作业信息：");
		bw.newLine();
		bw.append(sb.toString());
		// 释放资源
		bw.close();

		/*
		 * File read = new File("C:\\Users\\李晨香\\Desktop\\poem.txt"); BufferedReader br
		 * = new BufferedReader(new FileReader(read));
		 * 
		 * String content =; StringBuilder sb = new StringBuilder(); while (content !=
		 * null) { content = br.readLine(); if (content == null) { break; }
		 * sb.append(content.trim()); }
		 * 
		 * br.close();
		 */

	}
}
