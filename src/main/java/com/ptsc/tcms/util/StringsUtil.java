package com.ptsc.tcms.util;

public class StringsUtil {
	
	/**
	 * Replace null or empty string with spaces with ""
	 * @param String
	 * @return String
	 * @author Chris
	 */
	public static String nullEmptyToTrimString(String checkThis) {
		checkThis = checkThis == null ? "" : checkThis.trim();
		return checkThis; // Note: trim() removes leading AND trailing spaces
	}

	/**
	 * Check null or empty string with spaces
	 * @param String
	 * @return boolean
	 * @author Chris
	 */
	public static boolean isNullEmptyOrAllSpaces(String checkThis) {
		boolean checked = checkThis == null || "".equals(checkThis.trim());
		return checked;
	}
}
