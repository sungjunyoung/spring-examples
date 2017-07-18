package template;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by junyoung on 2017. 7. 18..
 */
public class CalcSumTest {
	Calculator calculator;
	String numFilePath;

	@Before
	public void setUp() throws UnsupportedEncodingException {
		this.calculator = new Calculator();
		this.numFilePath = URLDecoder.decode(getClass().getResource("/numbers.txt").getPath(), "UTF-8");
	}

	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(this.numFilePath), is(10));
	}

	@Test
	public void multiplyOfNumbers() throws IOException{
		assertThat(calculator.calcMultiply(this.numFilePath), is(24));
	}

	@Test
	public void concatStrings() throws IOException {
		assertThat(calculator.concatenate(this.numFilePath), is("1234"));
	}
}
