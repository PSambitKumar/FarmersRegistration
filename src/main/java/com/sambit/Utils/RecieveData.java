package com.sambit.Utils;

import com.sambit.Bean.BankDetailsBean;
import org.springframework.http.ResponseEntity;

import java.util.Iterator;

public class RecieveData {
	public static String data(ResponseEntity response){
		String result = null;
		System.out.println("Inside Receive Data--------------->>");
		System.out.println(response);

		ResponseEntity<BankDetailsBean> responseEntity = response;
		BankDetailsBean bankDetailsBean = responseEntity.getBody();

		System.out.println("Bank Details : " + bankDetailsBean);

		if (bankDetailsBean.getBANK() != null){
			System.out.println("NotEmpty");
			result =  "NotEmpty";
		}else {
			result =  "Empty";
		}
		System.out.println(responseEntity);

		return result;
	}
}
