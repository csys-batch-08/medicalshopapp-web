package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.medhub.model.Order;
import com.medhub.model.User;

public interface UserDAO {

	public boolean insert(User user) throws SQLException;
	public User login(User user);
	public List<User> viewAllUser();
	public int update (User currentUser);
	public boolean deleteUser(int userId);
	public int addMoneyInWallet(double walletAmount,User currentUser);
	public void updateUserPoints(Order order);
	public void updateWalletMoney(Order order);
	public int updatePassword(String confirmPassword, int userId);
	public boolean updatePointsConverted(User CurrentUser) throws SQLException;
}
