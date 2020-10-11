# 使用 ant实现Hello World的编译运行

下面是build.xml文件的代码

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<project name="HelloWorld" default="run" basedir=".">
 <property name="src" value="src"/>
 <property name="dest" value="bin/class"/>
 <property name="hello_jar" value="hello.jar"/>
 <target name="init">
  <mkdir dir="${dest}"/>
 </target>
 <target name="compile" depends="init">
  <javac srcdir="${src}" destdir="${dest}"/>
 </target>
 <target name="build" depends="compile">
  <jar jarfile="${hello_jar}" basedir="${dest}"/>
 </target>
 <target name="run" depends="build">
  <java classname="HelloWorld" classpath="${hello_jar}"/>
 </target>
 <target name="clean">
  <delete dir="${dest}" />
  <delete file="${hello_jar}" />
 </target>
</project>
~~~

这是java文件的代码

~~~java
public class HelloWorld{
	public static void main(String args[]){
        System.out.println("Hello World");
    }
}
~~~

