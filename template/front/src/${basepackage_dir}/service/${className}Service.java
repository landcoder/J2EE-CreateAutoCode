<#assign className = table.className>   
package ${basepackage}.service;

import org.springframework.dao.DataAccessException;

import com.aigou.framework.base.Page;
import com.aigou.framework.base.VEntity;
import ${basepackage}.model.${className};

/**
 * @author landcoder
 * @company oschina
 */
public interface ${className}Service {

	public ${className} getById(${table.idCol.javaType} id) throws DataAccessException;
	
	public void saveOrUpdate(${className} entity) throws DataAccessException;
	
	public void save(${className} entity) throws DataAccessException;
	
	public void removeById(${table.idCol.javaType} id) throws DataAccessException;
	
	public void update(${className} entity) throws DataAccessException;

	public Page findPage(VEntity p) throws DataAccessException;
}
