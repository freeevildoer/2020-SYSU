# 利用JDK实现HelloWorld的编译运行

本段代码在linux终端下使用

~~~
mkdir project
cd project
mkdir src bin
mkdir src/com/test
mkdir bin/project
vi src/com/test/HelloWorld.java
~~~

在vi命令下打开了一个HelloWorld.java文件后，我们开始编写java代码

~~~
package com.test;
	public class HelloWold{
		public static void main(String args[]){
			System.out.println("Hello World");
		}
}
~~~

保存后返回终端，开始编译新编写的Java文件，编译后执行即可。

~~~
javac ./src/com/test/HelloWorld.java -d ./bin/project
Java -cp ./bin/project/ com.test.HelloWorld
~~~

