package com.springmvc.controller.old;
 
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.springmvc.demo.model.Brand;
import com.springmvc.demo.model.Car;
import com.springmvc.demo.service.BrandManager;
import com.springmvc.demo.service.CarManager;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
 
public class CarNewController extends SimpleFormController {

	/**
	 * These methods are called before the form is displayed:
	 formBackingObject: initialize the Command used to init the form.
	 referenceData: set the view attributes (using a Map)
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	Car defaultCar = new Car();
    	defaultCar.setModel("new model");
    	defaultCar.setPrice(new BigDecimal(15000));
    	return defaultCar;
    }
 
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
    	Map<Object, Object> dataMap = new HashMap<Object, Object>();
    	BrandManager brandManager = new BrandManager();
    	dataMap.put("brandList", brandManager.getBrandList());
    	return dataMap;
    }

	/**
	 * These are called after:
	 initBinder: prevent Spring to do some bindings and so them by ourselves if needed. Here we used the brand id parameter to set the actual Brand.
	 onSubmit: the main code. In this case, we used the command object, which is a Car, to create a new Car.
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    	binder.setDisallowedFields(new String[] {"brand"});
 
    	Car car = (Car)binder.getTarget();
 
    	// set car's brand from request parameter brand id
    	BrandManager brandManager = new BrandManager();    	
    	Long brandId = null;
    	try {
	    	brandId = Long.parseLong(request.getParameter("brand"));
		} catch (Exception e) {}		
		if (brandId != null) {
			Brand brand = brandManager.getBrandById(brandId);
			car.setBrand(brand);
		}    
    }
 
    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
    	CarManager carManager = new CarManager();
    	carManager.createCar((Car)command);
 
    	return new ModelAndView(new RedirectView(getSuccessView()));
    }
 
}