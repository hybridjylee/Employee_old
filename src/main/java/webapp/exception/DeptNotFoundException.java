package webapp.exception;

public class DeptNotFoundException extends RuntimeException{
	
	public DeptNotFoundException() {
		super();
	}
	public DeptNotFoundException(String msg) {
		super(msg);
	}
	public DeptNotFoundException(String msg, Throwable e) {
		super(msg,e);
	}
}
