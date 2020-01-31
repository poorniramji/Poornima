package com.display.batch;

import org.springframework.batch.item.ItemProcessor;


public class ItemsProcessor implements ItemProcessor<String, String> {


	  @Override
	  public String process(String line) throws Exception {
	   //convert to cipher
		  CaesarCipher caesarCipher = new CaesarCipher();
		  String cipheredText = caesarCipher.cipher(line, 3);
		return cipheredText;
	  }
	}


