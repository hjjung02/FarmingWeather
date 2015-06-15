﻿package com.example.nongsaro;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.os.Handler;

//xml파싱 클래스
public class CallApiForGetXmlData extends DocumentBuilderFactory implements Runnable{
	public Document doc;
	private StringBuffer strbuf;
	private Handler mHandler;
	public void setmHandler(Handler mHandler) {
		this.mHandler = mHandler;
	}
	public void appendParam(String param, String vaule){
		strbuf.append(param+"=");
		strbuf.append(vaule+"&");
	}

	public void appendParam(String param, int vaule){
		strbuf.append(param+"=");
		strbuf.append(vaule+"&");
	}
	public CallApiForGetXmlData(String apiFile) {
		strbuf = new StringBuffer();
		strbuf.append("http://api.nongsaro.go.kr/service/");
		strbuf.append(apiFile+"?");
		strbuf.append("apiKey=20150602UN18HBYQKWBFQUWLGVMDFA&");//api 키
	}
		
	public void run() {
		try {
			doc = newInstance().newDocumentBuilder().parse(strbuf.toString());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			mHandler.sendEmptyMessage(0);	
		}
	}

	@Override
	public Object getAttribute(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getFeature(String name) throws ParserConfigurationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DocumentBuilder newDocumentBuilder()
			throws ParserConfigurationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object value)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFeature(String name, boolean value)
			throws ParserConfigurationException {
		// TODO Auto-generated method stub
		
	}
}
