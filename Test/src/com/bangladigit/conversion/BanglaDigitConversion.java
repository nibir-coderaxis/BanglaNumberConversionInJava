package com.bangladigit.conversion;

import java.util.ArrayList;

public class BanglaDigitConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 
		System.out.print(digits("09.30 AM"));

	}

	public static String digits(int i) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		StringBuffer buffer = new StringBuffer();
		while (i > 0) {
			digits.add(i % 10);
			i /= 10;

		}
		for (int k = digits.size() - 1; k >= 0; k--) {
			buffer.append(getBanglaDigit(digits.get(k)));
			System.out.print(digits.get(k));

		}
		return buffer.toString();
	}
	public static String digits(String i) {
		StringBuffer buffer = new StringBuffer();
		 
		char[] charData = i.toCharArray();
		for (int ik = 0; ik < charData.length; ik++) {
			if (charData[ik] == '.') {
				buffer.append(".");
			} else if(charData[ik]>=48 && charData[ik]<=57) {
				int position = charData[ik] - 48;
				buffer.append(getBanglaDigit(position));
			}
			else
			{
				buffer.append(charData[ik]);
			}
		}
		return buffer.toString();
	}
	public static String digits(double i) {
		StringBuffer buffer = new StringBuffer();
		String data = Double.toString(i);
		char[] charData = data.toCharArray();
		for (int ik = 0; ik < charData.length; ik++) {
			if (charData[ik] == '.') {
				buffer.append(".");
			} else {
				int position = charData[ik] - 48;
				buffer.append(getBanglaDigit(position));
			}
		}
		return buffer.toString();
	}

	public static char getBanglaDigit(int position) {
		switch (position) {
		case 0:
			return '০';

		case 1:

			return '১';
		case 2:

			return '২';
		case 3:

			return '৩';
		case 4:

			return '৪';
		case 5:

			return '৫';
		case 6:

			return '৬';
		case 7:

			return '৭';
		case 8:

			return '৮';
		case 9:

			return '৯';
		}
		return '0';
	}

	

	

}
