package ui;

/**
 * Created by junyoung on 2017. 7. 3..
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi{

	public void show(){
		showMenu();
		String inputedString = getInputedString();
		if(isValidNumber(inputedString)){
			execute(NumberUtils.toInt(inputedString));
		}
	}

	protected boolean isValidNumber(String str){
		if (StringUtils.isBlank(str)) {
			return false;
		} else if (!StringUtils.isNumeric(str)){
			return false;
		}

		int number = NumberUtils.toInt(str);
		if(getMinMenuNumber() <= number && number <= getMaxMenuNumber()){
			return true;
		}

		return false;
	}

	protected abstract int getMaxMenuNumber();

	protected abstract int getMinMenuNumber();

	protected abstract void execute(int number);

	protected abstract void showMenu();
}
