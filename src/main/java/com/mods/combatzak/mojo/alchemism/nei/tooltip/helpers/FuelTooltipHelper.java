package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers;

public abstract class FuelTooltipHelper implements IItemTooltipHelper {
	protected static final int MAX_SUFFIX_LEVEL = 5;

	/**
	 * Gets a friendly string representation for large numbers
	 * 
	 * @param amount number to condense
	 * @return compressed string representation of amount
	 */
	public static String getMetric(Long amount) {
		//any numbers below 1.5k are left as-is
		if (amount < 1500)
			return amount.toString();
		
		Long placeholder = amount;
		int trailingZeros = 0;
		while (placeholder % 10l == 0) { //count trailing 0s
			placeholder /= 10l;
			trailingZeros++;
		}
		
		//give up if only able to remove one 0
		if (trailingZeros <= 1) return amount.toString();
		
		placeholder = amount;
		int suffixLevel = 0;
		while (trailingZeros >= 3 && suffixLevel < MAX_SUFFIX_LEVEL) { //figure out which suffix to use
			placeholder /= 1000l;
			trailingZeros -= 3;
			suffixLevel++;
		};
		
		String result = placeholder.toString(); //get the number portion to start
		if (trailingZeros <= 1 || suffixLevel == MAX_SUFFIX_LEVEL)
			return placeholder.toString() + getSuffix(suffixLevel); //stop here if no more work can be done
		
		placeholder /= 100l; //cut off the next two digits
		String numString = placeholder.toString(); //turn into a string
		if (numString.length() == 1) numString = "0." + numString; //prepend a 0. in front of a single digit
		else numString = numString.substring(0, numString.length() - 2) + "." + numString.charAt(numString.length() - 1); //insert the decimal before last digit
		
		return numString + getSuffix(suffixLevel + 1);
	}
	
	/**
	 * Gets a suffix value for a power of 1000
	 * 
	 * @param suffixLevel power of 1000
	 * @return suffix appropriate for specified level
	 */
	private static String getSuffix(int suffixLevel) throws IllegalArgumentException {
		String result = "";
		switch (suffixLevel) {
			case 0:
				result = "";
				break;
				
			case 1:
				result = "k";
				break;
				
			case 2:
				result = "M";
				break;
				
			case 3:
				result = "B";
				break;
				
			case 4:
				result = "T";
				break;
				
			case 5:
				result = "Q";
				break;
				
			default:
				throw new IllegalArgumentException("Unsupported suffix level");
		}
		
		return result;
	}
}
