package com.address.exception;

public class NoAddressException extends RuntimeException{
 private static final long serialVersionUID=1L;
	public NoAddressException() {
		super();
	}

	public NoAddressException(String message) {
		super(message);
	}

}
