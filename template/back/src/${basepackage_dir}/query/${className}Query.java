<#assign className = table.className>   
package ${basepackage}.query;
${table.include}
import com.aigou.framework.base.VEntity;

public class ${className}Query extends VEntity implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	<#list table.cols as column>
	<#if column.javaType=='Date'>
	private ${column.javaType} ${column.proName}Begin;
	private ${column.javaType} ${column.proName}End;
	<#else>
	private ${column.javaType} ${column.proName};<#if column.comment!=''>//${column.comment!''}</#if>
	</#if>
	</#list>

<#list table.cols as column>
	<#if column.javaType=='Date'>
	public void set${column.upFirstProName}Begin(${column.javaType} value) {
		this.${column.proName}Begin = value;
	}

	public ${column.javaType} get${column.upFirstProName}Begin() {
		return this.${column.proName}Begin;
	}

	public void set${column.upFirstProName}End(${column.javaType} value) {
		this.${column.proName}End = value;
	}

	public ${column.javaType} get${column.upFirstProName}End() {
		return this.${column.proName}End;
	}

	<#else>
	public void set${column.upFirstProName}(${column.javaType} value) {
		this.${column.proName} = value;
	}

	public ${column.javaType} get${column.upFirstProName}() {
		return this.${column.proName};
	}

	</#if>
</#list>
}