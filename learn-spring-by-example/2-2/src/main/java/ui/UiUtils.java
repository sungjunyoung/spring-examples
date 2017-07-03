package ui;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by junyoung on 2017. 7. 3..
 */
public class UiUtils {
	public static boolean isSmallLength(String name, String fieldName, int length) {
		if(name == null){
			return true;
		}

		if(length < name.length()){
			System.out.printf("%s 는 %s 문자 이하로 입력해 주세요. %n", fieldName, length);
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str, String fieldName) {
		if(!StringUtils.isNumeric(str)){
			System.out.printf("%s 는 숫자로 입력해 주세요. %n", fieldName);
			return false;
		}
		return true;
	}
}
