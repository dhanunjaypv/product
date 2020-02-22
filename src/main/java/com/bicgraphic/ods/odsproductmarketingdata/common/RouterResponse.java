package com.bicgraphic.ods.odsproductmarketingdata.common;

import org.springframework.http.HttpStatus;

public class RouterResponse {
	
	private HttpStatus httpCode;
	private String data;

	public HttpStatus getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(HttpStatus httpCode) {
		this.httpCode = httpCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RouterResponse [httpCode=" + httpCode + ", data=" + data + "]";
	}

}
