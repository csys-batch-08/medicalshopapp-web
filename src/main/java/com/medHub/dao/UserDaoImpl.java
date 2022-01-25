package com.medHub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exceptions.UserExistsException;
import com.interfaces.UserDAO;
import com.medHub.model.Order;
import com.medHub.model.Product;
import com.medHub.model.User;
import com.medHub.util.ConnectionUtil;

public class UserDaoImpl implements UserDAO {

							//register new user
	public void insert(User user) {
		try {
			String ins = "insert into users (full_name,user_mobile,user_password,user_email) values(?,?,?,?)";
			String commit = "commit";
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement pst = con.prepareStatement(ins);
			pst.setString(1, user.getName());
			pst.setLong(2, user.getUserMobile());
			pst.setString(3, user.getUserPassword());
			pst.setString(4, user.getUserMail());
			int res = pst.executeUpdate();
			PreparedStatement smt = con.prepareStatement(commit);
			smt.execute();
		
			} catch (Exception e) {
			
			}

	}

								//	user login
	public User login(User user) {

		User loginUser = null;
		try {

			String check = "select user_id,full_name,delivery_address,user_password,user_wallet,user_email,user_mobile,account_status,points from users where user_email= ? and user_password= ? ";
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement pst = con.prepareStatement(check);
			pst.setString(1, user.getUserMail());
			pst.setString(2, user.getUserPassword());
			int i = pst.executeUpdate();
			ResultSet rs = pst.executeQuery();


			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6), rs.getLong(7), rs.getString(8), rs.getInt(9));

				return user;
				}

			} catch (Exception e) {
//		e.printStackTrace();
			}
			return loginUser;

	}
	
	
								//list all users access by admin
	public List<User> ViewAllUser() {
		List<User> userList = new ArrayList<User>();
		try {
			String viewUsers = "select  user_id,full_name,delivery_address,user_password,user_wallet,user_email,user_mobile,account_status,points from users";
			Connection conn = ConnectionUtil.getDBconnect();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(viewUsers);

			rs = stm.executeQuery(viewUsers);
			while (rs.next()) {
				User allUsers = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getInt(9));
				userList.add(allUsers);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;

	}

									//user profile update
	public int update(User currentUser) {
		String update = null;
		try {
			update = "update users set full_name=?,user_password=?,user_mobile=?,delivery_address=? where user_email='"
					+ currentUser.getUserMail() + "'";
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, currentUser.getName());
			pst.setString(2, currentUser.getUserPassword());
			pst.setLong(3, currentUser.getUserMobile());
			pst.setString(4, currentUser.getAddress());
			int res = pst.executeUpdate();
			System.out.println(res);
			res = pst.executeUpdate("commit");

			if (res > 0) {
			} else {
			}

			return res;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
								//get user details by userId
	public User getUserById(int userId) {
		String getuserId = "select * from users where user_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		User userModule = null;

		con = ConnectionUtil.getDBconnect();
		try {
			pstatement = con.prepareStatement(getuserId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		try {
			pstatement.setInt(1, userModule.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}
		try {
			ResultSet rs = pstatement.executeQuery(getuserId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}

		return userModule;

	}
	
							// delete user by admin
	public boolean deleteUser(int userId) {

		Connection con = null;
		PreparedStatement pst = null;
		int deleteStatus = 0;
		int result = 0;
		try {
			con = ConnectionUtil.getDBconnect();
			String delete = "update users set account_status ='inactive' where user_id=?";
			pst = con.prepareStatement(delete);
			pst.setInt(1, userId);
			result = pst.executeUpdate();

		} catch (Exception e) {
		}
		if (result > 0) {
			return true;
		} else
			return false;

	}

//														ADD MONEY TO WALLET

	public int addMoneyInWallet(double walletAmount, User currentUser) {

		String walletQuery = "update users set user_wallet =" + walletAmount + " where user_email ='"
				+ currentUser.getUserMail() + "'";
		int result = 0;
		User user = new User();
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement ps = con.prepareStatement(walletQuery);
			result = ps.executeUpdate();
			ps.executeUpdate("commit");
			if (result > 0) {
				UserDaoImpl userDao = new UserDaoImpl();
				currentUser.setWallet(walletAmount);
				user.setWallet(walletAmount);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		return result;
	}

							// points update when purchase done
	public void updateUserPoints(Order order) {
		try {
			String pointsQuery = "update users set points='" + order.getUser().getPoints() + "' where user_id = '"
					+ order.getUser().getUserId() + "'";
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement ps = con.prepareStatement(pointsQuery);
			ps.executeUpdate();
			ps = con.prepareStatement("commit");
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

						//	update walletmoney	
	public void updateWalletMoney(Order order) {
		
		String query = "update users set user_wallet='" + order.getUser().getWallet() + "' where user_id = '"
				+ order.getUser().getUserId() + "'";
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			int result = ps.executeUpdate();
			ps.executeUpdate("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public int updatePassword(String confirmPassword, int userId) {
		try {
			String updatePassword = "update users set user_password='" + confirmPassword + "' where user_id='" + userId
					+ "'";
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement ps = con.prepareStatement(updatePassword);
			int result = ps.executeUpdate();
			con.prepareStatement("commit");
			ps.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return 0;
	}

	public boolean updatePointsConverted(User CurrentUser) {
		// TODO Auto-generated method stub

		boolean flag = false;
		String query = "update users set points=0 where User_email='" + CurrentUser.getUserMail() + "'";
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			int result = ps.executeUpdate();
			CurrentUser.setPoints(0);
			ps.executeUpdate("commit");
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
	
	public void updateUserPoints(int points,User currentUser) {
		try {
			
			String pointsQuery = "update users set points='" + points + "' where user_id = '"+ currentUser.getUserId()+ "'";
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement ps = con.prepareStatement(pointsQuery);
			ps.executeUpdate();
			ps = con.prepareStatement("commit");
			ps.executeUpdate();
		} catch (Exception e) {
		}

	}

						//	update walletmoney	
	public void updateWalletMoney(double wallet,User currentUser) {
		
		String query = "update users set user_wallet='" + wallet + "' where user_id = '"+ currentUser.getUserId() + "'";
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			int result = ps.executeUpdate();
			ps.executeUpdate("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkMail(String mail) {
		boolean flag = true;
		String query = "select * from users where user_email= '"+mail+"'";
		Connection con = ConnectionUtil.getDBconnect();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet result = ps.executeQuery();
		
			if(result.next())
			{
				flag=false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}

}
