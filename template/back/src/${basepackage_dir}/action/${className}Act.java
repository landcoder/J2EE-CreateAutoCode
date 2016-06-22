<#assign className = table.className>   
package ${basepackage}.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aigou.framework.base.BaseAction;
import ${basepackage}.query.${className}Query;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

@Controller
@RequestMapping("/perm")
public class ${className}Act extends BaseAction {

	@Resource
	private ${className}Service ${table.lowerClassName}Service;

	/**
	 * 根据id获取${table.table_comment}信息
	 * @param ${table.idCol.proName}
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${table.lowerClassName}/aoe.do", method = RequestMethod.GET)
	public String get(${table.idCol.javaType} ${table.idCol.proName},HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		if (${table.idCol.proName} != null) {
			model.put("${table.lowerClassName}", ${table.lowerClassName}Service.getById(${table.idCol.proName}));
		}
		return backResult("${table.lowerClassName}/addOrEdit.html");
	}

	/**
	 * 获取${table.table_comment}列表
	 * @param q
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${table.lowerClassName}/plist.do")
	public String page(${className}Query q,HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		model.put("q", q);
		model.put("page", ${table.lowerClassName}Service.findPage(q));
		return backResult("${table.lowerClassName}/list.html");
	}

	/**
	 * 添加,修改
	 * @param ${table.lowerClassName}
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${table.lowerClassName}/merge.do", method = RequestMethod.POST)
	public String merge(${table.className} ${table.lowerClassName},HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		${table.lowerClassName}Service.saveOrUpdate(${table.lowerClassName});
		model.put("page", ${table.lowerClassName}Service.findPage(new ${table.className}Query()));
		return backResult("${table.lowerClassName}/list.html");
	}

	/**
	 * 删除
	 * @param ids
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${table.lowerClassName}/del.do", method = RequestMethod.POST)
	public String del(String ids,HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		String[] ida = ids.split(",");
		for (int i = 0; i < ida.length; i++) {
			${table.lowerClassName}Service.removeById(${table.idCol.javaType}.valueOf(ida[i]));
		}
		return ajax(response, "success");
	}
}