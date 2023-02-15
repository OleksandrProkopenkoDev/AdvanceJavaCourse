package regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String regexString = ".*[a-z][0-9].";
		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher("123456asasd6A64A6S4D6AS4D461za32s1as5d6a16q");
		boolean matchFound = matcher.find();
		if(matchFound) {
			System.out.println("Match found");
			System.out.println(Arrays.toString( matcher.results().toArray()) );
		}else {
			System.out.println("Match not found");
		}
	}

}
