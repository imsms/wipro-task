package com.sms.homebrew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sms.homebrew.Constant;
import com.sms.homebrew.model.Formula;
import com.sms.homebrew.service.FormulaService;

@Service
public class FormulaServiceImpl implements FormulaService {
	@Autowired
	private WebClient.Builder builder;

	@Override
	public Formula getFormula(String name) {
		StringBuffer buffer = new StringBuffer();
		//buffer.append(Constant.GATEWAY_URL);
		buffer.append("formula/");
		buffer.append("{FORMULA}.json");
		
		return builder.build()
				 .get()
				 .uri(buffer.toString(), name)
				 .retrieve()
				 .bodyToMono(Formula.class)
				 .block();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formula> getAllFormula() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(Constant.GATEWAY_URL);
		buffer.append(Constant.FORMULAS_URL);
		
		return (List<Formula>) builder.build()
				 .get()
				 .uri(buffer.toString())
				 .retrieve()
				 .bodyToMono(Formula.class)
				 .block();
	}

}
