package template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by junyoung on 2017. 7. 18..
 */
public class Calculator {

	public <T> T lineReadTemplate(String filePath, LineCallback<T> callback,T initVal) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			T res = initVal;
			String line = null;
			while ((line = br.readLine()) != null) {
				res = callback.doSomethingWithLines(line, res);
			}
			return res;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public Integer calcSum(String filePath) throws IOException {
		LineCallback<Integer> sumCallback = new LineCallback<Integer>() {
			@Override
			public Integer doSomethingWithLines(String line, Integer value) throws IOException {
				return value + Integer.valueOf(line);
			}
		};

		return lineReadTemplate(filePath, sumCallback, 0);
	}

	public Integer calcMultiply(String filePath) throws IOException {
		LineCallback<Integer> mulCallback = new LineCallback<Integer>() {

			@Override
			public Integer doSomethingWithLines(String line, Integer value) throws IOException {
				return value * Integer.valueOf(line);
			}
		};

		return lineReadTemplate(filePath, mulCallback, 1);
	}

	public String concatenate(String filePath) throws IOException {
		LineCallback<String> concatCallback = new LineCallback<String>() {
			@Override
			public String doSomethingWithLines(String line, String value) throws IOException {
				return value + line;
			}
		};

		return lineReadTemplate(filePath, concatCallback, "");
	}
}
