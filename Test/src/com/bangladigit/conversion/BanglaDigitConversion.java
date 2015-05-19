package com.bangladigit.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	public static String isNearby(String timeStampDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			Date parsedDate = dateFormat.parse(timeStampDate);
			java.sql.Timestamp time = new java.sql.Timestamp(
					parsedDate.getTime());
			Date date = new Date(time.getTime());

			SimpleDateFormat dateFormatt = new SimpleDateFormat(
					"dd-MMM-yy hh.mm.ss.S aa");
			String formattedDate = dateFormatt.format(date).toString();

			DateFormat dateFormatss = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal = Calendar.getInstance();

			Calendar calR = Calendar.getInstance();
			calR.add(Calendar.DATE, 1);

			SimpleDateFormat dateFormattt = new SimpleDateFormat("hh.mm aa");
			String formattedDatet = dateFormattt.format(date).toString();

			if (dateFormatss.format(date).compareTo(
					dateFormatss.format(cal.getTime())) == 0) {
				return "Today at " + formattedDatet;
			}

			else if (dateFormatss.format(calR.getTime()).compareTo(
					dateFormatss.format(date)) == 0) {

				return "Tomorrow at " + formattedDatet;

			} else {

				return formattedDate;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	

}
