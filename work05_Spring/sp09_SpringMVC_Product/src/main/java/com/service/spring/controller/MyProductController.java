package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("/myProduct.do")
	public ModelAndView insert(MyProduct pvo) throws Exception{
		System.out.println("pvo ::: "+pvo); //pvo값에 시퀀스 없음(0)을 확인.
		myProductService.addProduct(pvo);
		System.out.println("addProduct 호출 후 pvo :: "+pvo); //먼저 시퀀스를 생성한 후 찾아와서 insert를 하기에 해당 pvo에 시퀀스 값이 있음(!0)을 확인. 
		return new ModelAndView("insert_result", "vo", pvo); //이때 바인딩 하는 이름은 pvo가 아니라 vo다! 
	}
	
	@RequestMapping("/myProductSearch.do")
    public ModelAndView find(String command, String word) throws Exception{
        List<MyProduct> list = null;
        String viewName = "";
        if(command.equals("findProductByName")) {
            list=myProductService.findProductByName(word);
            viewName = "find_result";
        }else if(command.equals("findProductByMaker")) {
            list=myProductService.findProductByMaker(word);
            viewName = "find_result";
        }else if(command.equals("findProducts")) {
            list=myProductService.findProducts();
            viewName = "find_result";
        }
        return new ModelAndView(viewName,"list",list);

    }
}
