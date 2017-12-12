package com.kosta.doorlock;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Enumeration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;

import com.kosta.dto.RsaKey;
import com.kosta.service.RsaKeyService;


@Controller
public class RsaKeyController {

	private RsaKeyService rsaKeyService;
	private static String ips;
	private static Key keySpec;

	@Autowired
	public void setRsaKeyService(RsaKeyService rsaKeyService) {
		this.rsaKeyService = rsaKeyService;
	}

	/**
	 * RSA
	 * @return public key 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 */
	@RequestMapping(value="getRsaPublicKey.do", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getRsaPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException {
		System.out.println("test");
		RsaKey result = rsaKeyService.selectRsaKey();
		System.out.println(result);
		return result.getPublicKeyModulus()+"/"+result.getPublicKeyPublicExponent();	//퍼블릭키호출 
	}

	//RSA 키생성
	@RequestMapping(value="setRsaKey.do", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String setRsaKey() {
		String publicModulus = null;
		String publicExponent = null;
		String privateModulus = null;
		String privateExponent = null;
		
		RsaKey result = rsaKeyService.selectRsaKey();
		
		if (result.getPrivateKeyModulus() == null) {
			try {
				//공개키 및 개인키 생성
				KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
				keyPairGenerator.initialize(2048);

				KeyPair keyPair = keyPairGenerator.genKeyPair();
				Key publicKey = keyPair.getPublic(); // 공개키
				Key privateKey = keyPair.getPrivate(); // 개인키

				KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
				RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

				publicModulus = publicKeySpec.getModulus().toString();
				publicExponent = publicKeySpec.getPublicExponent().toString();
				privateModulus = privateKeySpec.getModulus().toString();
				privateExponent = privateKeySpec.getPrivateExponent().toString();

				int success = rsaKeyService.insertRsaKey(new RsaKey(privateModulus,privateExponent,publicModulus,publicExponent));

				if(success != 0) {
					System.out.println("성공");
				}
				return "OK";
			} catch (Exception e) {}
		}else {
			try {
				//공개키 및 개인키 생성
				KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
				keyPairGenerator.initialize(2048);

				KeyPair keyPair = keyPairGenerator.genKeyPair();
				Key publicKey = keyPair.getPublic(); // 공개키
				Key privateKey = keyPair.getPrivate(); // 개인키

				KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
				RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

				publicModulus = publicKeySpec.getModulus().toString();
				publicExponent = publicKeySpec.getPublicExponent().toString();
				privateModulus = privateKeySpec.getModulus().toString();
				privateExponent = privateKeySpec.getPrivateExponent().toString();

				int success = rsaKeyService.updateRsaKey(result.getPrivateKeyModulus(),new RsaKey(privateModulus,privateExponent,publicModulus,publicExponent));

				if(success != 0) {
					System.out.println("성공");
				}
				return "OK";
			} catch (Exception e) {}
		}
		return "false";
	}
	//key -> 암호화된 aes키 
	//RSA 복호화
	   @RequestMapping(value="RsaAes.do", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	   @ResponseBody
	   public String decRsa(String aesKeyToRsa) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	      RsaKey result = rsaKeyService.selectRsaKey();

	      String strModulus = result.getPrivateKeyModulus();
	      String strPrivateExponent = result.getPrivateKeyPrivateExponent();
	      BigInteger modulus = new BigInteger(strModulus);
	      BigInteger PrivateExponent = new BigInteger(strPrivateExponent);

	      String[] keys = aesKeyToRsa.split("\\/");
	      byte[] c = new byte[keys.length];
	      for (int i = 0 ; i < keys.length; i++) {
	         c[i] = Byte.parseByte(keys[i].trim());
	      }

	      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	      RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, PrivateExponent); // key concat 
	      RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(rsaPrivateKeySpec); // => private key 객체 생성

	      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	      cipher.init(Cipher.DECRYPT_MODE, privateKey);
	      byte[] bPlain2 = cipher.doFinal(c);

	      String sPlain2 = new String(bPlain2);
	      System.out.println(sPlain2);
	      //sPlain2	-> aes 키
	      
	      return sPlain2;
	   }
	   
}