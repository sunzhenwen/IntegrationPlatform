package com.tj.jst.inner.randomProject.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomProject.model.RandomProject;
import com.tj.jst.inner.randomProject.service.IRandomProjectService;
import com.tj.jst.inner.randomProject.service.RandomProjectServiceImpl;

/**
 * 随机项目
 * 
 * @author Administrator
 *
 */
public class RandomProjectAction extends BaseAction {

	private RandomProject randomProject;// Model类
	private List<DictionaryClass> citysList;
	private List<DictionaryClass> areaList;
	private String cityCode;//城市编码
	private String areaCode;//区县编码
	private String result;
	private List<RandomProject> randomProjects;
	
	/**
	 * 跳转地市随机页面
	 * 
	 * @return
	 */
	public String randomProjectPage() {
		IRandomProjectService rcs = new RandomProjectServiceImpl();
		citysList = rcs.queryCitys();
		return "randomProjectPage";
	}

	/**
	 * 根据地市查询项目
	 * 
	 * @return
	 */
	public String queryProject() {
		IRandomProjectService rcs = new RandomProjectServiceImpl();
		citysList = rcs.queryCitys();
		if(!"".equals(areaCode) && areaCode!=null)
		{
			randomProjects = rcs.queryProject(areaCode);
		}else
		{
			randomProjects = rcs.queryProject(cityCode);
		}
		
		return "randomProjectPage";
	}
	
	/**
	 * 查询区县
	 * @return
	 */
	public String queryArea()
    {
		IRandomProjectService rcs = new RandomProjectServiceImpl();
		areaList = rcs.queryArea(cityCode);
		JSONArray json = JSONArray.fromObject(areaList);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }


	public RandomProject getRandomProject() {
		return randomProject;
	}

	public void setRandomProject(RandomProject randomProject) {
		this.randomProject = randomProject;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<DictionaryClass> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<DictionaryClass> areaList) {
		this.areaList = areaList;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public List<RandomProject> getRandomProjects() {
		return randomProjects;
	}

	public void setRandomProjects(List<RandomProject> randomProjects) {
		this.randomProjects = randomProjects;
	}

}
