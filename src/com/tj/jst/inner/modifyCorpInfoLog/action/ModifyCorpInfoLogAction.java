package com.tj.jst.inner.modifyCorpInfoLog.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.CorpBadIntegrityServiceImpl;
import com.tj.jst.inner.integrity.corpBadIntegrity.service.ICorpBadIntegrityService;
import com.tj.jst.inner.modifyCorpInfoLog.condition.ModifyCorpInfoLogCondition;
import com.tj.jst.inner.modifyCorpInfoLog.model.ModifyCorpInfoLog;
import com.tj.jst.inner.modifyCorpInfoLog.service.IModifyCorpInfoLogService;
import com.tj.jst.inner.modifyCorpInfoLog.service.ModifyCorpInfoLogServiceimpl;
import com.tj.jst.inner.personrecord.constructor.condition.ConstructorCondition;

public class ModifyCorpInfoLogAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//省
	private List<DictionaryClass> provinces;
	//市
	private List<DictionaryClass> citys;
	private List<DictionaryClass> citys1;
	//区
	private List<DictionaryClass> areas;
	private List<DictionaryClass> areas1;
	//企业类型(TBAPTITUDEKINDDIC)
	private List<DictionaryClass> certTypeNums;
	//省code
	private String provinceId;
	//市code
	private String cityNum;
	
	private String result;
	
	private ModifyCorpInfoLog modifyCorpInfoLog;
	
	private String logId ;
	
	private ModifyCorpInfoLogCondition condition = new ModifyCorpInfoLogCondition();

	public void setCondition(ModifyCorpInfoLogCondition condition) {
		this.condition = condition;
	}

	public ModifyCorpInfoLogCondition getCondition() {
		ModifyCorpInfoLogCondition sessionCondition = (ModifyCorpInfoLogCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String queryPage() {
		
		IModifyCorpInfoLogService service = new ModifyCorpInfoLogServiceimpl();
		currentPage = service.queryPage(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
		
	}
	
	/**
	 * 详细
	 * @return
	 */
	public String queryInfo(){
		
		IModifyCorpInfoLogService service = new ModifyCorpInfoLogServiceimpl();
		modifyCorpInfoLog = service.queryInfo(this.getLogId());
		provinces = service.queryProvince();
		citys = service.queryCity(modifyCorpInfoLog.getProvinceNum());
		citys1 = service.queryCity(modifyCorpInfoLog.getProvinceNum1());
		areas = service.queryArea(modifyCorpInfoLog.getCityNum());
		areas1 = service.queryArea(modifyCorpInfoLog.getCityNum1());
		this.queryDictionary();
		return "queryInfo" ;
	}
	
	/**
	 * 查询市
	 * @return
	 */
	public String queryCity()
    {
		IModifyCorpInfoLogService service = new ModifyCorpInfoLogServiceimpl();
		citys = service.queryCity(provinceId);
		JSONArray json = JSONArray.fromObject(citys);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询区
	 * @return
	 */
	public String queryArea()
    {
		IModifyCorpInfoLogService service = new ModifyCorpInfoLogServiceimpl();
		areas = service.queryArea(cityNum);
		JSONArray json = JSONArray.fromObject(areas);//给result赋值，传递给页面 
        result = json.toString();
        return "success";
    }
	
	/**
	 * 查询字典表
	 */
	public void queryOtherDictionary()
	{
		IModifyCorpInfoLogService service = new ModifyCorpInfoLogServiceimpl();
		BaseDao dao = new BaseDao();
		//企业类型(TBAPTITUDEKINDDIC)
		certTypeNums = service.queryCertTypeNums();
	}
	

	public List<DictionaryClass> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DictionaryClass> provinces) {
		this.provinces = provinces;
	}

	public List<DictionaryClass> getCitys() {
		return citys;
	}

	public void setCitys(List<DictionaryClass> citys) {
		this.citys = citys;
	}

	public List<DictionaryClass> getAreas() {
		return areas;
	}

	public void setAreas(List<DictionaryClass> areas) {
		this.areas = areas;
	}

	public List<DictionaryClass> getCertTypeNums() {
		return certTypeNums;
	}

	public void setCertTypeNums(List<DictionaryClass> certTypeNums) {
		this.certTypeNums = certTypeNums;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public ModifyCorpInfoLog getModifyCorpInfoLog() {
		return modifyCorpInfoLog;
	}

	public void setModifyCorpInfoLog(ModifyCorpInfoLog modifyCorpInfoLog) {
		this.modifyCorpInfoLog = modifyCorpInfoLog;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DictionaryClass> getCitys1() {
		return citys1;
	}

	public void setCitys1(List<DictionaryClass> citys1) {
		this.citys1 = citys1;
	}

	public List<DictionaryClass> getAreas1() {
		return areas1;
	}

	public void setAreas1(List<DictionaryClass> areas1) {
		this.areas1 = areas1;
	}
	
}
