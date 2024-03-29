package org.smx.captcha.impl;

import java.util.Random;

import org.smx.captcha.IWordFactory;

public class FactoryRandomImpl extends IWordFactory {
	//Can't create directly
	private FactoryRandomImpl(){
		
	}
	private int size=8;
	private boolean useDigits;
	public static IWordFactory getInstance() {
		if(instance==null ){
			instance=new FactoryRandomImpl();
		}
		return instance;
	}
	
	public void setSize(final int size){		
		this.size=size;
	}
	
	public void setUseDigits(final boolean useDigits){		
		this.useDigits=useDigits;
	}
	
	public String getWord() {
		String az="ABCDEFGHIJKLMNOPQRIJKLMNOPQRSTUVWXYZ";
		if(useDigits){
			az+="0123456789";
		}
		int len=az.length();
		word="";
		Random rand=new Random();
		while(word.length()<size){
			String s=""+az.charAt(rand.nextInt( len ));
			if(word.indexOf(s)==-1){
				word+=s;
			}
		}
			return word;
	}	

}
