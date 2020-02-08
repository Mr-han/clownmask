package cn.clownmask.exception;

public class CMSNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;
	private int code = 404;

	public CMSNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
