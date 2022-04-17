package com.sms.homebrew.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.homebrew.Constant;
import com.sms.homebrew.model.Formula;
import com.sms.homebrew.service.FormulaService;

@RestController
@RequestMapping(value = Constant.APP_URL)
public class HomebrewController {
	@Autowired
	private FormulaService formulaService;
	
	@RequestMapping(value = Constant.FORMULA + Constant.GET_NAME + "/", method = RequestMethod.GET)
    public Formula getFormulaByName(@RequestParam(value = "value") String name) {
		Formula formula = formulaService.getFormula(name);

        return formula;
    }
	
	@GetMapping(value = Constant.FORMULA + "/")
    public String getAllFormula() {

        return "Success";
    }
}
