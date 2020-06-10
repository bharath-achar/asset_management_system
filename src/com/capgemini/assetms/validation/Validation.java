package com.capgemini.assetms.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public Integer numValidate(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if (mat.matches()) {
			return Integer.parseInt(id);
		} else {
			return null;
		}
	}

	public boolean dateValidate(String date) {
		Pattern pat = Pattern.compile("\\d{4}-\\d{2}-\\d{2}$");
		Matcher mat = pat.matcher(date);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}// end of dateValidate()

}// end of class
