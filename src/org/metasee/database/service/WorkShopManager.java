package org.metasee.database.service;

import org.metasee.database.model.WorkShop;

public interface WorkShopManager {
	public void save(WorkShop workShop) throws Exception;
	public WorkShop getWorkShopById(int id) throws Exception;
	public boolean checkWorkShopNameAndUser(String name, int userId) throws Exception;
	public void deleteById(int id) throws Exception;
	public void update(WorkShop workShop) throws Exception;
	public WorkShop getWorkShopByNamAndUserName(String name, String userName) throws Exception;
}
