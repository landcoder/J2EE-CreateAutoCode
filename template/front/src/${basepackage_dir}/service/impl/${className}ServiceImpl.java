<#assign className = table.className>   
package ${basepackage}.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.aigou.framework.base.BaseService;
import com.aigou.framework.base.IEntityDao;
import com.aigou.framework.base.Page;
import com.aigou.framework.base.VEntity;
import ${basepackage}.dao.${className}DaoImpl;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

@Service(value="${table.lowerClassName}Service")
public class ${className}ServiceImpl extends BaseService<${className},${table.idCol.javaType}> implements ${className}Service {

	@Resource
	private ${className}DaoImpl ${table.lowerClassName}Dao;

	public IEntityDao<${className},${table.idCol.javaType}> getEntityDao() {
		return this.${table.lowerClassName}Dao;
	}

	public Page findPage(VEntity p) throws DataAccessException {
		return ${table.lowerClassName}Dao.findPage(p);
	}
}
