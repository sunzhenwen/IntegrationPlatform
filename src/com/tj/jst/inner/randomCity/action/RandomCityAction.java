package com.tj.jst.inner.randomCity.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomCity.model.RandomCity;
import com.tj.jst.inner.randomCity.service.IRandomCityService;
import com.tj.jst.inner.randomCity.service.RandomCityServiceImpl;

/**
 * 随机地市查询
 * 
 * @author Administrator
 *
 */
public class RandomCityAction extends BaseAction {

	private RandomCity randomCity;// Model类
	private List<DictionaryClass> citysList;
	private String cityCode;//城市编码
	
	/**
	 * 跳转地市随机页面
	 * 
	 * @return
	 */
	public String randomCityPage() {
		IRandomCityService rcs = new RandomCityServiceImpl();
		citysList = rcs.queryCitys();
		return "randomCityPage";
	}

	/**
	 * 跳转地市随机页面
	 * 
	 * @return
	 */
	public String queryArea() {
		IRandomCityService rcs = new RandomCityServiceImpl();
		randomCity = rcs.queryArea(cityCode);
		citysList = rcs.queryCitys();
		return "randomCityPage";
	}
	
	public RandomCity getRandomCity() {
		return randomCity;
	}

	public void setRandomCity(RandomCity randomCity) {
		this.randomCity = randomCity;
	}

	public List<DictionaryClass> getCitysList() {
		return citysList;
	}

	public void setCitysList(List<DictionaryClass> citysList) {
		this.citysList = citysList;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
