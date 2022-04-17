package com.sms.homebrew.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.homebrew.model.Formula;

@Service
public interface FormulaService {
	Formula getFormula(String name);
	
	List<Formula> getAllFormula();
}
