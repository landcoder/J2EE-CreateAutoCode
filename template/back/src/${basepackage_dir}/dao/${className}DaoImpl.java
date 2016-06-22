<#assign className = table.className>   
package ${basepackage}.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aigou.framework.base.BaseIbatis3Dao;
import com.aigou.framework.base.VEntity;
import com.aigou.framework.base.Page;
import ${basepackage}.model.${className};

@Repository(value="${table.lowerClassName}Dao")
public class ${className}DaoImpl extends BaseIbatis3Dao<${className},${table.idCol.javaType}>{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "${basepackage}.model.${className}.";
	}
	
	public void saveOrUpdate(${className} entity) {
		if(entity.get${table.idCol.upFirstProName}() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public List<${className}> findList(VEntity p) {
		return selectList("findlist",p);
	}
	
	public Number findCount(VEntity p) {
		return (Number)selectOne("findcount",p);
	}
	
	public Page findPage(VEntity p) {
		Number totalCount = findCount(p);
		if(totalCount == null || totalCount.longValue() <= 0) {
			return new Page(1,20,0);
		}
		Page page = new Page(p.getCpage(),p.getPageSize(),totalCount.intValue());
		page.setResult(findList(p));
		return page;
	}
}
