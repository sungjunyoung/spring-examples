package template;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by junyoung on 2017. 7. 18..
 */
public interface LineCallback<T> {
	T doSomethingWithLines(String line, T value) throws IOException;
}
