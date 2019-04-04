/**
 * 
 */
package com.serenityrestassuredBDD.utils;

import java.util.Random;

/**
 * @author India
 *
 */
public class Common {
	
	public static int generateRamdom() {
		Random ran=new Random();
		int rand=ran.nextInt(10000);
		
		return rand;
	}

}
