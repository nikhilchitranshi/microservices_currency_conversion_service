package com.learning.microservices.currencyconversionservice.serviceproxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.microservices.currencyconversionservice.model.CurrencyConversionBean;

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getCurrencyExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) ;

}
