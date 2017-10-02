package org.metasee.database.dao;

import org.metasee.database.model.WorkShop;

public interface WorkShopDao {
	public void save(WorkShop workShop);
	public WorkShop getWorkShopById(int id);
	public boolean checkWorkShopNameAndUser(String name, int userId);
	public void deleteById(int id);
	public void update(WorkShop workShop);
	public WorkShop getWorkShopByNamAndUserName(String name, String userName);
}
