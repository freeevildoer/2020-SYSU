# studyreport

## vi/vim编辑器自学报告

在linux系统中，vi编辑器是标准编辑器，vim编辑器是vi的升级版，vi所有的命令vim编辑器都兼容。

首先我们来模拟下vi编辑器的用法，假设我们现在要访问一个名称为a.txt的文件，那么我们需要用的命令操作就是 vi a.txt。

使用这个命令后，终端会显示出这个a.txt文件的内容，但是这时候我们无法写入新的字符，因为这时候是处于命令模式下。

因此，我们需要知道vi/vim编辑器有3种模式：命令模式，插入模式，底行模式。当你通过vi命令打开一个文件时，这时候文件就处于命令模式下。

命令模式下输入的字符会被当做命令来执行，比如在终端输入命令yy ，它就表示复制光标的一行，如果是nyy(n 为一个正整数)，则表示复制包括光标所在行及以下n行。输入命令p，就会粘贴所复制的内容。输入命令dd和ndd，它就会删除当前光标所在的行或者是包括光标在内的以下n行。

那么，如何转换到插入模式和底行模式呢？我们需要通过命令模式转换，当你需要进入插入模式的时候，就在命令模式下输入命令i，即可进入插入模式。如果需要进入底行模式，则在命令模式下输入命令: ，即可进入底行模式。

输入模式的操作方式与通常使用键盘输入的方式相同，但是不具有通常使用的快捷键操作。这意味着我们插入和删除新的字符后还没有保存，这时候我们需要通过ESC键返回命令模式，并通过命令:进入底行模式，在底行模式通过输入命令w才能保存修改后的文件。



## java学习报告

java的基本内容大体上与c/c++的基本内容相同。我们就忽略这一部分来说说java的特别之处。

Java的switch语句是可以支持字符串的，及输入字符串s。如果s = "Li", 则会执行switch("Li")之后的语句。

java的类是java最重要的部分。因为java是面向对象语言，它必须要通过一个类去实例化一个对象才能执行类的功能。所以类的变量和函数的权限就非常的重要。因为这关系到外部能否使用这个类的方法和变量。java的权限修饰符和其他编程语言一样，有private,protected,public三种类型 ，作用与c/c++中的private,protected,public相当。

首先，一个java文件只能有一个public类，这个public类实例化的对象是可以被外界访问的。这个类里面还具有变量和方法，它的变量和方法的权限由创造者决定如果一个变量或方法是private类型，则只有该类实例化的对象才可以访问，如果是protected类型，则该类以及子类实例化的对象可以访问。如果是public类型，则所有对象都可以访问。

java类有个特别的地方在于可以为变量或者方法加上static(静态)的修饰词，被static修饰的变量和方法可以被类名直接调用，被所有对象共享。

java类还有个关键词this，类似与objective-c中的self，就是指代自己本身。

java的抽象类需要加上关键词abstract修饰，抽象方法也需要加上abstract，抽象类和抽象方法想要被利用的话，需要通过子类重写所有的抽象方法，并实例化子类对象才可以实现。

接口和抽象类具有类似的功能，都需要通过子类重写所有的抽象方法和实例化子类对象才能实现。



## ant学习报告

ant是利用一个xml文件来编译Java文件的工具，类似于c/c++中的makefile文件。我们需要了解这个xml文件的结构和其使用方式。

ant有三个重要的元素，project元素，target元素，property元素，每个元素都有其属性。

每个ant文件至少包含一个project元素，及每个ant文件至少有一个可以编译的对象项目，project元素里面可以包含多个target元素，这些target元素可以理解为我们需要对这个project所做的操作和操作的对象。而property元素可以当作project元素的参数或者某些属性，

project元素一般如下表示：

~~~xml
<project name = "A", default = " b", basedir = "E:" >
</project>
~~~



name，default，basedir是project的属性，name说明了project的名称，default指定了project默认执行时所执行的target的名称，basedir用于指定根路径的位置，如果该属性没有指定时，就是用Ant的构件文件的附目录为基准目录。

target元素一般如下表示：

~~~xml
<target name = "A" if = "B">
    
</target>
<target name = "c" depend = "A" unless = "D">
    
</target>
~~~

target元素具有name，if，depend，unless等属性，一个project中的target的name属性的值是唯一的，它不允许有两个相同的target name。if和unless表示判断值是否存在，在上面的例子中，如果B存在，则可以执行target A。depend属性表示所在的target的执行依赖其他的target的执行。在上面的例子中，如果要执行target C，需要满足两个条件，一个是target A执行了，并且D不存在，是的,,unless与if的作用相反，if是判断若存在，则执行，Unless是判断若不存在，则执行。

property元素用于设置一些属性，如下所示

~~~xml
<property name = "A" value = "10"/>
~~~

这相当与设置了一个变量A，并将它的值赋值为10。

除了上述三种元素外，ant还有其他的操作

~~~xml
<copy file = "file.txt" tofile = "file2.txt"/>
<copy file = "file.txt" todir = "/new"/>
~~~

上述两行代码的作用分别是复制一个文件到另一个文件，复制一个文件到另一个文件夹。

ant还可以创建新的文件夹或者是删除文件或文件夹

~~~xml
<mkdir dir = "/new"/>
<delete file = "a.txt"/>
<delete dir = "src"/>
~~~

## junit自学报告

junit是java语言的单元测试框架，可以测试指定代码的正确性。Junit通过import org.junit.Test;   import static org.junit.Assert.*; 来使用其方法。上面的包中包含了类Assert，即断言，它具有多个方法来判断代码是否正确，如下表所示。

| 方法名                                                  | 作用和藐视                                               |
| ------------------------------------------------------- | -------------------------------------------------------- |
| **void assertEquals(boolean expected, boolean actual)** | 检查两个变量或者等式是否平衡                             |
| **void assertTrue(boolean expected, boolean actual)**   | 检查条件为真                                             |
| **void assertFalse(boolean condition)**                 | 检查条件为假                                             |
| **void assertNotNull(Object object)**                   | 检查对象不为空                                           |
| **void assertNull(Object object)**                      | 检查对象为空                                             |
| **void assertSame(boolean condition)**                  | assertSame() 方法检查两个相关对象是否指向同一个对象      |
| **void assertNotSame(boolean condition)**               | assertNotSame() 方法检查两个相关对象是否不指向同一个对象 |
| **void assertArrayEquals(expectedArray, resultArray)**  | assertArrayEquals() 方法检查两个数组是否相等             |



我是通过Eclipse来使用Junit的测试功能的，我就以Eclipse为例来说明如何使用Junit判断要测试的代码是否正确。

首先，我们先创立一个HelloWorld的项目，并创建一个Hello的包，在这个包下创建HelloWorld.java文件，代码如下：

~~~java
package Hello;

public class HelloWorld {
	String str;
	public void Hello(){
		str = "Hello world";
	}
	public String getStr() {
		return str;
	}
}	
~~~

然后点这个项目，选择properties，选择java build path，选择 Add Library，最后选择junit。因为Eclipse在创建项目时默认不加入JUNIT，所以你需要手动添加。

再添加之后，右键点击HelloWorld.java文件，选择new，在选择junit test。然后点击next，你对需要测试的函数确定，然后finish。此时它会给你生成一个测试类HelloWorldTest.java，而且会有需要测试的函数，如下所示，这时候你就需要调用上面所描述的Assert的方法，去实现代码测试。

~~~java
package Hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloWorldTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetStr() {
		fail("Not yet implemented");
	}

}



~~~

我们想要调用对应的方法，我们还需要继承TestCase类，这就需要我们插入新的包import junit.framework.TestCase; 插入后，我们需要将setup函数设置为protected类型，你可以在这个函数做点初始化的操作，也可以什么都不进行。我们所需要进行测试的地方在testGetStr()中，我们这里利用了 assertEquals方法去判断所函数所输出的字符串是否符合我们的需求。

~~~java
package Hello;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.TestCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloWorldTest extends TestCase {
	HelloWorld helloworld = new HelloWorld();
	@BeforeEach
	protected void setUp() throws Exception {
	}

	@Test
	void testGetStr() {
		helloworld.Hello();
		assertEquals("Hello world!",helloworld.getStr());
	}

}
~~~



