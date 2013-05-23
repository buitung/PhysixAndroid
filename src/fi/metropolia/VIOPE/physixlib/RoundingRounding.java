package fi.metropolia.VIOPE.physixlib;

public class RoundingRounding {
	
	/*
	 * @params s: String s that take to round
	 * @return the string after rounding
	 */
	public static String RRR(String s){
		float value = Float.parseFloat(s);
		float ee=(float)0.00001;
		if (s.trim().length()>6){
			if (Math.abs(value)<=ee)
				return "0";
			else if (Math.abs(value)+ee>(float)Math.ceil(Math.abs(value))){
				if (value>=0) 
					return Float.toString((float)Math.ceil(value));
				else
					return Float.toString((float)Math.ceil(Math.abs(value))*(float)(-1.0));
			}
			else
				return s.trim().substring(0,6);
		}
		else
			return s.trim();
	}
}
