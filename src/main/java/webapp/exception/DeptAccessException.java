package webapp.exception;

public class DeptAccessException extends RuntimeException{
	
	public DeptAccessException() {
		super();
	}
	public DeptAccessException(String msg) {
		super(msg);
	}
	public DeptAccessException(Throwable e) {
		super(e);
	}
	public DeptAccessException(String msg, Throwable e) {
		super(msg,e);
	}
}
