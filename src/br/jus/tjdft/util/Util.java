package br.jus.tjdft.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static String format(Date date){
		return simpleDateFormat.format(date);
	}
	
	public static Date parse(String date){
		try{
		return simpleDateFormat.parse(date);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
