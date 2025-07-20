package applicationModel;


public class ExceptionRange extends Exception {
	private static final long serialVersionUID = 1L;
	private int range;
	String exceptionError;
	
	public ExceptionRange(int range,String exceptionError) {
		this.range = range;
		this.exceptionError=exceptionError;
	}
	public int getRange() {
		return range;
	}
	public String getExceptionError() {
		return exceptionError;
	}
	
	
	
}
