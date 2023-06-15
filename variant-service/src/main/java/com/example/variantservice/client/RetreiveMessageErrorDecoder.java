package com.example.variantservice.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import com.example.variantservice.exception.CarNotFoundException;
import com.example.variantservice.exception.ExceptionMessage;

import feign.Response;
import feign.codec.ErrorDecoder;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder errorDecoder = new Default();
	
	@Override
	public Exception decode(String methodKey, Response response) {
		ExceptionMessage exceptionMessage = null;
		try(InputStream body = response.body().asInputStream()){
			exceptionMessage = new ExceptionMessage((String) response.headers().get("date").toArray()[1],
					response.status(),
					HttpStatus.resolve(response.status()).getReasonPhrase(),
					IOUtils.toString(body,StandardCharsets.UTF_8),
					response.request().url()
					);
		} catch (IOException exception) {
			return new Exception(exception.getMessage());
		}
		switch (response.status()) {
		case 404: {
			
			throw new CarNotFoundException(exceptionMessage);
		}
		default:
			return errorDecoder.decode(methodKey, response);
		}
		
		return null;
	}

}
