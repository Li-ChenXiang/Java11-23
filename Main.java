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
		// ����ѧ������
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 1; i++) {
			Student stu = new Student();
			// ��Scanner��ʵ������
			Scanner sc = new Scanner(System.in);
			System.out.println("ѧ�ţ�");
			int id = sc.nextInt();
			stu.setId(id);
			System.out.println("�༶��");
			String bj = sc.next();
			stu.setBj(bj);
			System.out.println("������");
			String name = sc.next();
			stu.setName(name);

			// ����ʵ����
			/*
			 * Student stu = new Student(); stu.setId(id); stu.setBj(bj); stu.setName(name);
			 */

			students.add(stu);
		}
		System.out.println("ѧ����Ϣ�ѱ��浽�ļ��У�");

		// ��ȡpoem.txt�е���Ϣ
		FileInputStream poem = new FileInputStream("C:\\Users\\���\\Desktop\\poem.txt");
		InputStreamReader p = new InputStreamReader(poem, "UTF-8");// ������������
		BufferedReader br = new BufferedReader(p);
		// System.out.println("�ַ�����"+isr.getEncoding());
		String line = br.readLine();
		// String line ="������ɫ˼���";
		// String line=null;
		StringBuffer sb = new StringBuffer();
		sb.append(line);
		int i;
		int j = 0;
		for (i = 7; i <= sb.length(); i += 8) {
			if (i == 7) {
				sb.insert(i, "��");
			} else if ((i - j) % 7 == 0 && (i - j) % 14 != 0) {
				sb.insert(i, "��");
			} else if ((i - j) % 14 == 0) {
				sb.insert(i, "��");
			}
			j = j + 1;
		}
		System.out.println(sb);

		// Ŀ�ĵ�student.txt
		// ��ȡ�����е�ÿһ��Student����
		FileOutputStream student = new FileOutputStream("C:\\Users\\���\\Desktop\\student.txt");
		OutputStreamWriter s = new OutputStreamWriter(student, "UTF-8");
		BufferedWriter bw = new BufferedWriter(s);
		bw.write("ѧ��\t\t");
		bw.write("�༶\t\t");
		bw.write("����\t");
		bw.newLine();
		bw.flush();

		for (Student stu : students) {
			// ��student��Ϣ�浽�ı��ļ���
			// ����ԴStudent stu
			// Ŀ�ĵ�Student.txt
			int id = stu.getId();
			String bj = stu.getBj();
			String name = stu.getName();

			bw.write(id + "\t");
			bw.write(bj + "\t\t");
			bw.write(name + "\t");
			bw.newLine();
			bw.flush();
		}
		bw.write("��ҵ��Ϣ��");
		bw.newLine();
		bw.append(sb.toString());
		// �ͷ���Դ
		bw.close();

		/*
		 * File read = new File("C:\\Users\\���\\Desktop\\poem.txt"); BufferedReader br
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
