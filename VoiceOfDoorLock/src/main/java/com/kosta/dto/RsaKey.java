package com.kosta.dto;

import java.math.BigInteger;

public class RsaKey {
	private String privateKeyModulus;
	private String privateKeyPrivateExponent;
	private String publicKeyModulus;
	private String publicKeyPublicExponent;
	
	public RsaKey() {
		// TODO Auto-generated constructor stub
	}

	public RsaKey(String privateKeyModulus, String privateKeyPrivateExponent, String publicKeyModulus,
			String publicKeyPublicExponent) {
		super();
		this.privateKeyModulus = privateKeyModulus;
		this.privateKeyPrivateExponent = privateKeyPrivateExponent;
		this.publicKeyModulus = publicKeyModulus;
		this.publicKeyPublicExponent = publicKeyPublicExponent;
	}

	public String getPrivateKeyModulus() {
		return privateKeyModulus;
	}

	public void setPrivateKeyModulus(String privateKeyModulus) {
		this.privateKeyModulus = privateKeyModulus;
	}

	public String getPrivateKeyPrivateExponent() {
		return privateKeyPrivateExponent;
	}

	public void setPrivateKeyPrivateExponent(String privateKeyPrivateExponent) {
		this.privateKeyPrivateExponent = privateKeyPrivateExponent;
	}

	public String getPublicKeyModulus() {
		return publicKeyModulus;
	}

	public void setPublicKeyModulus(String publicKeyModulus) {
		this.publicKeyModulus = publicKeyModulus;
	}

	public String getPublicKeyPublicExponent() {
		return publicKeyPublicExponent;
	}

	public void setPublicKeyPublicExponent(String publicKeyPublicExponent) {
		this.publicKeyPublicExponent = publicKeyPublicExponent;
	}
	
	
}
