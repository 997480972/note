package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.SysMenu;
public interface SysMenuMapper {
	
	public List<SysMenu> getForList();

}
