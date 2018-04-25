package com.learning.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.learning.microservices.currencyconversionservice.serviceproxies.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyCalculatorController {
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurencyCalculatoryBean(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
	
		CurrencyConversionBean response = proxy.getCurrencyExchangeValue(from, to);
		
		return new CurrencyConversionBean(response.getId(),from, to, response.getConversionMultiple(),
							quantity, response.getConversionMultiple().multiply(quantity), response.getPort());
		
	}
	
	
	
}
