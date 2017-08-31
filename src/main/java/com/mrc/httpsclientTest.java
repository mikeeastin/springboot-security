/*
 * Copyright 2000-2020 YGSoft.Inc All Rights Reserved.
 *//*

package com.ygsoft.ecp.service.tool.test;

import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

import com.ygsoft.ecp.service.tool.EncodeUtil;
import com.ygsoft.ecp.service.tool.HttpsClientUtil;
import com.ygsoft.ecp.service.tool.JSONUtil;

*/
/**
 * 
 * TODO �ڴ�д��������˵��.<br>
 * 
 * @author mairongcong <br>
 * @version 1.0.0 2017-7-13<br>
 * @see
 * @since JDK 1.5.0
 *//*

public class HttpsClientUtilTest {

	private String url = "https://view.ygsoft.com/_Json/User/Login.ashx";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDoGet() throws InterruptedException, ExecutionException {
		HashMap<String, Object> createMap = new HashMap<String, Object>();
		createMap.put("aa", 111);
		createMap.put("bb", "������������");
		String result = "{\"result\":\"0\",\"errorMsg\":\"�����ͳ��ȱ������ø��ַ����ڵ�λ�á�";
		ExecutorService service = Executors.newFixedThreadPool(20);
		for (int i=0; i<20; i++) {
			Future<String> task = service.submit(new HttpsClientThread());
			System.out.println("task:" + task.get());
		}
		assertEquals(true, HttpsClientUtil.doGet(url, createMap).contains(result));
	}
	@Test
	public void testDoPost() throws InterruptedException, ExecutionException {
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put("111", "aaaaa");
		String result = "{\"result\":\"0\",\"errorMsg\":\"��������\",\"errorCode\":\"0\"}";
		assertEquals(true, HttpsClientUtil.doPost(url, createMap).contains(result));
	}
	
	class HttpsClientThread implements Callable<String>{

		public String call() throws Exception {
			HashMap<String, Object> createMap = new HashMap<String, Object>();
			createMap.put("aa", 111);
			createMap.put("bb", "������������");
			String result = HttpsClientUtil.doPost(url, createMap);
			System.out.println("result" + result);
			return result;
		}
		
	}

	*/
/**
	 * ��ȡ΢�����Ƶ���ַ.
	 *//*

	private static final String GET_WXTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

	*/
/**
	 * ��ȡ΢��С�����ά�����ַ.
	 *//*

	private static final String GET_WXACODE_URL = "https://api.weixin.qq.com/wxa/getwxacode?access_token={0}";

	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		//new HttpsClientUtilTest().testDoGet();
		
		final String token = getWXAppToken("wxf427d7647b93ff04", "3821db338c25f63e3229468ac9ab4c1c");
		final String base64 = getWXAppCode(token, "pages/index/index", 200);
	}
	
	
	
	public static String getWXAppToken(final String wxAppId, final String wxAppSecret) {
		// ��װ��ѯ������
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("grant_type", "client_credential");
		args.put("appid", wxAppId);
		args.put("secret", wxAppSecret);
		// ��ȡ���� Token ����
		final String tokenObj = HttpsClientUtil.doGet(GET_WXTOKEN_URL, args);
		// ��ȡ�� Token �ַ�����
		final Map<String, String> tokenMap = JSONUtil.fromJsonString(tokenObj, Map.class);
		return tokenMap.get("access_token");
	}

	public static String getWXAppCode(final String wxAppToken, final String wxAppPath, final int imageWidth) {
		// ��ȡ��ά��ԭʼ���ݡ�
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("path", wxAppPath);
		args.put("width", imageWidth);
		final String respContent = HttpsClientUtil.doPost(MessageFormat.format(GET_WXACODE_URL, wxAppToken), args);
		// ת��Ϊ Base64 ���롣
		return EncodeUtil.encodeString(respContent);
	}

}
*/
