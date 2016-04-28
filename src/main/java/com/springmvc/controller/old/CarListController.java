package com.springmvc.controller.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springmvc.demo.service.CarManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CarListController implements Controller {

	//need to instantiate a CarManager somewhere else and pass it to this controller.
	// It's done in 'demo-servlet.xml':
	private CarManager carManager;
	public ModelAndView handleRequest(HttpServletRequest arg0,
									  HttpServletResponse arg1) throws Exception {

		//gets its instance of CarManager by itself: change that by making it an attribute:!
//		CarManager carManager = new CarManager();
 
		ModelAndView modelAndView = new ModelAndView("carList");
		modelAndView.addObject("carList", carManager.getCarList());
 
		return modelAndView;
	}

	public CarManager getCarManager() {
		return carManager;
	}

	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}
}