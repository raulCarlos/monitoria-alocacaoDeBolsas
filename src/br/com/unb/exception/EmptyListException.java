package br.com.unb.exception;

@SuppressWarnings("serial")
public class EmptyListException extends Exception{
	public EmptyListException(String msg){
		super(msg);
	}
}
