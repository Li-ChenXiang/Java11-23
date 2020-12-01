# 计G202 2020322088 李晨香
# Java11-23
11.23 第五次实验：模拟学生作业处理

## 一、实验目的
1.掌握字符串String及其方法的使用；

2.掌握文件的读取/写入方法；

3.掌握异常处理结构；

## 二、实验要求
1.设计学生类；

2.采用交互式方式实例化某学生；

3.将学生的基本信息储存到文本文件A中；

4.设计程序完成对古诗《长恨歌》整理对齐工作，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。

## 三、实验过程
1.创建Java项目Homework;

2.创建学生类Student,包括学号，班级，姓名等属性，并对其添加get()、set()方法；

3.在测试类Main类中，实例化Student类，通过采用Scanner类实现运行时交互式输入；

4.对文本文件B中获取到的信息进行整理，再将其存到文件A中；

## 四、核心方法
1.创建学生集合
```
ArrayList<Student> students = new ArrayList<Student>();
		try {
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
			students.add(stu);
		}
		System.out.println("学生信息已保存到文件中！");
		}catch(Exception e){
			System.out.println("数据类型错误，请重新输入！");
		}
```

2.为古诗《长恨歌》添加标点符号
```
String line = br.readLine();
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
```

3.将学生的基本信息储存到文本中
```
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
```
4.读取poem.txt中的信息
```
FileInputStream poem = new FileInputStream("C:\\Users\\李晨香\\Desktop\\poem.txt");
		InputStreamReader p = new InputStreamReader(poem, "UTF-8");// 处理中文乱码
		BufferedReader br = new BufferedReader(p);
```

## 五、实验结果
1.在控制台正常运行的结果
```
学号：
2020322088
班级：
计G202
姓名：
李晨香
学生信息已保存到文件中！
```
2.将学生信息储存到文本文件的运行结果

![](https://github.com/Li-ChenXiang/Java11-23/blob/main/%E6%90%9C%E7%8B%97%E6%88%AA%E5%9B%BE20201201153648.jpg)

3.整理后的古诗存到学生文件中的运行结果

![](https://github.com/Li-ChenXiang/Java11-23/blob/main/%E6%90%9C%E7%8B%97%E6%88%AA%E5%9B%BE20201201155718.jpg)

## 六、实验感想
实验过程中遇到的问题：1.在读取poem文件中的信息时出现乱码； 解决方法：添加InputStreamReader方法，对； 2.捕获异常后，无法重新输入信息；解决方法：在catch方法体中输入年龄和薪水的调用语句。
