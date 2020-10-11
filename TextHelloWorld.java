package Cac;
import static org.junit.Assert.*;
import org.junit.Test;
public class TextHelloWorld {
	public HelloWorld helloworld = new HelloWorld();
	@Test
	public void TestHello() {
		helloworld.Hello();
		assertEquals("Hello world!",helloworld.getStr());
	}
}
