package org.timur.sar.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorAccount 
{
	private String type;
	private String title;
	private String detail;
	private Integer status;
	private String instance;
	
	public ErrorAccount()
	{
		
	}
	
	public ErrorAccount(String detail, Integer status, String instance)
	{
		super();
		this.type = "http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation";
		this.title = "Your request data didn't pass validation";
		this.detail = detail;
		this.status = status;
		this.instance = instance;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getDetail() 
	{
		return detail;
	}

	public void setDetail(String detail) 
	{
		this.detail = detail;
	}

	public Integer getStatus() 
	{
		return status;
	}

	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public String getInstance() 
	{
		return instance;
	}

	public void setInstance(String instance) 
	{
		this.instance = instance;
	}
	
	
}
