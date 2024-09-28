package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
	AccountRepo repo;
	
	public String addAccount(Account accnt)
	{
		if(accnt.getAmount() < 1000)
			return "Amount must be >1000 ";
		Optional<Account> acc = repo.findById(accnt.getAccountNo());
		if(acc.isPresent())
		{
			return "Account number already exists";
		}
		else
		{
			repo.save(accnt);
			return "Account saved successfully";
		}
	}
	
	public List<Account> retrieveAllAccounts()
	{
		return repo.findAll();
	}
	
	public Account retrieveAccountById(Long id)
	{
		Optional<Account> op = repo.findById(id);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	public String depositAmount(Long id, float addAmount, boolean isPanEnterted) {
		if(addAmount > 50000 && !isPanEnterted)
			return "PANrequired";
		Optional<Account> accountO = repo.findById(id);
		if(accountO.isPresent())
		{
			Account account = accountO.get();
			account.setAmount(account.getAmount() + addAmount);
			repo.saveAndFlush(account);
			return "Saved successfully";
		}
		return "Exception Occured";
	}
	
	public String withdrawAmount(Account account, float amount) {
		if(account.getAmount() < amount)
			return "Insufficient Balance";
		if(Math.abs(account.getAmount() - amount) < 1000)
			return "Invalid request as final balance will be less than 1000";
		// Withdraw logic
		account.setAmount(Math.abs(account.getAmount() - amount));
		repo.saveAndFlush(account);
		return "Withdraw Successful";
	}
	
}
