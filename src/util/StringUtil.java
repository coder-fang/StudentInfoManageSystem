package util;

public class StringUtil {
	public static boolean isEmpty(String str) {//判断输入框内是否为null
		if("".equals(str)||str==null) {
			return true;
		}else 
			return false;
	}

}
