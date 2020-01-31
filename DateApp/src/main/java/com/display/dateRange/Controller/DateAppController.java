package com.display.dateRange.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.display.dateRange.Model.DateModel;

@Controller
public class DateAppController {
	
	@Value( "${error_101}" )
	private String errorMessage;
	
	@Value("${error_102}")
	private String dateEmptyError;
	

	@GetMapping("/")
	public String getDatePage() {
		return "datePage";
	}
	
	/* This method gets the date value and processes it*/
	
	@PostMapping("/result")
	public ModelAndView getDateRange(@ModelAttribute(name="dateModel") DateModel dateModel) {
		
		Date startDate = dateModel.getStartDate();
		Date endDate = dateModel.getEndDate();
		ModelAndView mv = new ModelAndView();
		if(startDate != null && endDate != null) {
		if(startDate.compareTo(endDate) > 0) {
			 mv.addObject("error", errorMessage);
			 mv.setViewName("datePage.html");
			 return mv;
		}else {
			int diffdate = (int)( (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
			mv.setViewName("result.html");
			mv.addObject("result", diffdate);
			return mv;
		}
		}
		else {
			 mv.addObject("error", dateEmptyError);
			 mv.setViewName("datePage.html");
			 return mv;
		}
	}
	
	

}
