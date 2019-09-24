package com.synergisticit.onlinebanking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.synergisticit.onlinebanking.domain.Transaction;
//import com.synergisticit.onlinebanking.service.AccountServiceImpl;
import com.synergisticit.onlinebanking.service.TransactionService;
import com.synergisticit.onlinebanking.validation.TransactionValidator;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransactionValidator transactionValidator;
//	
//	@Autowired
//	@Qualifier("accountServiceImpl")
//	AccountServiceImpl accountService;
//	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(transactionValidator);
	}
	
	
	
	//____________Transfer Between Accounts_______________//
	
	@RequestMapping(value="/transamt",method=RequestMethod.GET)
	public String transfersave(Transaction transaction){
		return "transfer";
	}
	
	@RequestMapping(value="/savetrans",method=RequestMethod.POST)
	public String savetransfer(@ModelAttribute Transaction transaction,Model model)
	{
		Transaction transferamt=transactionService.transferamount(transaction.getAmounttx(),transaction.getFromAccount(),transaction.getToAccount());
		model.addAttribute("transactionService",transferamt);
		return "amttransfersaved";
	}
	
	//_________________DEPOSIT AMOUNT__________________//
	//PreAuthorize,@PostAuthorized->works and entering into the method and @secured are used for method level security
	//TWO WAYS TO DO 1)METHOD LEVEL 2)JSP PAGE 
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="/depositform")
	public String depositform(@ModelAttribute("transaction")Transaction transaction)
	{
		
		return "deposit";
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value="/savedeposit")
	public String savedeposit(@Valid @ModelAttribute("transaction") Transaction transaction,Model model,BindingResult result)
	{
		transactionValidator.validate(transaction, result);
		System.out.println("result.hasErrors()"+result.hasErrors());
		if(result.hasErrors()){
			System.out.println("return back to deposit form");
		}else{
		Transaction depositamount=transactionService.deposit(transaction.getDepositamt(), transaction.getFromAccount(),transaction.getToAccount());
		model.addAttribute("newbalance",depositamount);
		}
		return "deposit";
		
	}
	
	
	//_________________WITHDRAW FROM ACCOUNT___________________________//
	//@Secured("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/withdrawform",method=RequestMethod.GET)
	//public String withdrawform(Transaction transaction,@SessionAttribute("user") User user){
		public String withdrawform(Transaction transaction){
		
		return "withdraw";
	}
	
	@RequestMapping(value="/savewithdrawform",method=RequestMethod.POST)
	public String savewithdrawamt(@ModelAttribute Transaction transaction,Model model)
	{
		
		Transaction withdrawamount=transactionService.withdraw(transaction.getWithdrawamt(), transaction.getFromAccount(), transaction.getToAccount());
		model.addAttribute("withdrawbalance",withdrawamount);
		return "withdraw";
		
	}
	
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String accessdenied(Model model){
		return "accessdenied";
	}
	
	/*@RequestMapping(value="/savetrans",method=RequestMethod.POST)
	public String savetransfer(double amounttx,long fromAccount,long toAccount,Model model)
	{
		Transaction transferamt=accountService.transfer(amounttx,fromAccount,toAccount);
		model.addAttribute("transactionService",transferamt);
		return "amttransfersaved";
		
	}
*/
	
	
}
