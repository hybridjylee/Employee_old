package webapp.exception;

public class ConnectionFailException extends RuntimeException{
	
	public ConnectionFailException() {
		super();
	}
	public ConnectionFailException(String msg) {
		super(msg);
	}
	public ConnectionFailException(String msg, Throwable e) {
		super(msg,e);
	}
}
