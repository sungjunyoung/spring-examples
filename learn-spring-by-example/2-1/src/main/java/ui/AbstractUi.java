package ui;

import exception.IORuntimeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public abstract class AbstractUi {

	protected String getInputedString(){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{
			return input.readLine();
		} catch (IOException e){
			throw new IORuntimeException("콘솔에 입력을 받지 못했습니다.", e);
		}
	}

	abstract public void show();
}
