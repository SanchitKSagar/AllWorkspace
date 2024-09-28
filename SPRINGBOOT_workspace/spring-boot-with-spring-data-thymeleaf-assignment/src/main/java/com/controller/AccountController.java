package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Account;
import com.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class AccountController {

	@Autowired
	AccountService service;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openIndexPage(Model m, Account accnt) {   // DI
		// Default values for index.html
		m.addAttribute("msg", null);
		m.addAttribute("listOfAccounts", null);
		m.addAttribute("accnt", accnt);
		m.addAttribute("showTable", false);
		return "index";
	}
	
	@RequestMapping(value = "/storeaccount", method = RequestMethod.POST)
	public String storeEmployee (Model model, Account accnt)
	{
		String serviceResponse = service.addAccount(accnt);
		if(serviceResponse.equals("Account saved successfully"))
		{
			accnt.setAccountNo(0);
			accnt.setAmount(0.0f);
			accnt.setName("");
		}
		else
		{
			accnt.setAccountNo(accnt.getAccountNo());
			accnt.setAmount(accnt.getAmount());
			accnt.setName(accnt.getName());
		}
		model.addAttribute("msg", serviceResponse);
		model.addAttribute("accnt", accnt);
		
		return "index";
	}
	
	@RequestMapping(value = "/retrieveAllAccounts", method = RequestMethod.GET)
	public String retrieveAll(Model m)
	{
		m.addAttribute("showTable", true);
		m.addAttribute("listOfAccounts", service.retrieveAllAccounts());
		m.addAttribute("accnt", new Account(0, null, 0.0f));
		return "index";
	}
	
	@RequestMapping(value="/deposit", method = RequestMethod.GET)
	public String depositAmount(Model m, HttpServletRequest req) {
		Long accountNo= Long.parseLong(req.getParameter("accntNo"));
		Account account = service.retrieveAccountById(accountNo);
		m.addAttribute("deposit_msg", null);
		m.addAttribute("accNo", account.getAccountNo());
		m.addAttribute("accName", account.getName());
		m.addAttribute("accAmt", account.getAmount());
		m.addAttribute("amount", 0.0f);
		m.addAttribute("isPanRequired", false);
		return "deposit";
	}
	
	@RequestMapping(value = "/depositButton", method = RequestMethod.POST)
	public String depositButton(Model m, HttpServletRequest req)
	{
		Float depositAmount = Float.parseFloat(req.getParameter("amount"));
		Long accountNo= Long.parseLong(req.getParameter("accNo"));
		Boolean isPanRequired = Boolean.parseBoolean(req.getParameter("isPanRequired"));
		Account account = service.retrieveAccountById(accountNo);
		String response = service.depositAmount(accountNo, depositAmount, isPanRequired);
		if(response.equals("PANrequired"))
		{
			m.addAttribute("deposit_msg", "Pleae enter PAN details as Deposit amount is > 50000");
			m.addAttribute("accNo", account.getAccountNo());
			m.addAttribute("accName", account.getName());
			m.addAttribute("accAmt", account.getAmount());
			m.addAttribute("amount", depositAmount);
			m.addAttribute("isPanRequired", true);
			return "deposit";
		}
		m.addAttribute("deposit_msg", "Deposit Successful");
		m.addAttribute("accNo", account.getAccountNo());
		m.addAttribute("accName", account.getName());
		m.addAttribute("accAmt", account.getAmount());
		m.addAttribute("amount", 0.0f);
		m.addAttribute("isPanRequired",false);
		return "deposit";
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdrawAmount(Model m, HttpServletRequest req)
	{
		Long accountNo = Long.parseLong(req.getParameter("accntNo"));
		Account account = service.retrieveAccountById(accountNo);
		m.addAttribute("withdraw_msg", null);
		m.addAttribute("accNo", account.getAccountNo());
		m.addAttribute("accName", account.getName());
		m.addAttribute("accAmt", account.getAmount());
		m.addAttribute("amount", 0.0f);
		return "withdraw";
	}
	
	@RequestMapping(value = "/withdrawButton", method = RequestMethod.POST) 
	public String withdrawButton(Model m, HttpServletRequest req)
	{
		Long accountNo = Long.parseLong(req.getParameter("accNo"));
		Account account = service.retrieveAccountById(accountNo);
		Float amount = Float.parseFloat(req.getParameter("amount"));
		String response = service.withdrawAmount(account, amount);
		m.addAttribute("withdraw_msg", response);
		m.addAttribute("accNo", account.getAccountNo());
		m.addAttribute("accName", account.getName());
		m.addAttribute("accAmt", account.getAmount());
		m.addAttribute("amount", amount);
		return "withdraw";
	}
	
	@RequestMapping(value = "/checkBalance", method = RequestMethod.GET)
	public String checkBalance(Model m)
	{
		m.addAttribute("checkBal_msg", null);
		m.addAttribute("accountNo", null);
		m.addAttribute("isResultPresent", false);
		m.addAttribute("accName", null);
		m.addAttribute("accAmt", 0.0f);
		return "checkBal";
	}
	
	@RequestMapping(value = "/checkButton", method = RequestMethod.POST)
	public String checkBalanceButton(Model m, HttpServletRequest req)
	{
		Long accountNo = Long.parseLong(req.getParameter("accountNo"));
		Account account = service.retrieveAccountById(accountNo);
		if(account == null)
		{
			m.addAttribute("checkBal_msg", "No account with Account Number " + accountNo + " exists");
			m.addAttribute("accountNo", null);
			m.addAttribute("isResultPresent", false);
			m.addAttribute("accName", null);
			m.addAttribute("accAmt", 0.0f);
		}
		else
		{
			m.addAttribute("checkBal_msg", null);
			m.addAttribute("accountNo", accountNo);
			m.addAttribute("isResultPresent", true);
			m.addAttribute("accName", account.getName());
			m.addAttribute("accAmt", account.getAmount());
		}
		return "checkBal";
	}
}
