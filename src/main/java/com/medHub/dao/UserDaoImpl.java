package com.medhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exceptions.UserExistsException;
import com.interfaces.UserDAO;
import com.medhub.model.Order;
import com.medhub.model.Product;
import com.medhub.model.User;
import com.medhub.util.ConnectionUtil;

public class UserDaoImpl implements UserDAO {

	
	 String commitQuery= "commit";
	
									/*
									 * register new user* 
									 					*/	
	 
	 public boolean insert(User user){
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		boolean flag= false;
		try {
			String insert = "insert into users (full_name,user_mobile,user_password,user_email) values(?,?,?,?)";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, user.getUserName());
			pstmt.setLong(2, user.getUserMobile());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserMail());
			int res=pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
			System.out.println(res);
			if(res>0)
			{
				flag=true;
			}
		
			}catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(pstmt,con,rs);
			}
		return flag;

	}
	

								//	user login
	public User login(User user) {

		
		Connection con = null;
		PreparedStatement pstmt  = null;
		ResultSet rs =null;
		try {

			String check = "select user_id,full_name,delivery_address,user_password,user_wallet,user_email,user_mobile,account_status,points from users where user_email= ? and user_password= ? ";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(check);
			pstmt.setString(1, user.getUserMail());
			pstmt.setString(2, user.getUserPassword());
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("full_name"), rs.getString("delivery_address"), rs.getString("user_password"), rs.getDouble("user_wallet"),
						rs.getString("user_email"), rs.getLong("user_mobile"), rs.getString("account_status"), rs.getInt("points"));

				return user;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(pstmt,con,rs);
			}
			return null;

	}
	
	
	
								//list all users access by admin
	public List<User> viewAllUser() {
		
		List<User> userList = new ArrayList<>();
		Statement stmt =null;
		ResultSet rs = null;
		Connection con = null;
		try {
			String viewUsers = "select  user_id,full_name,delivery_address,user_password,user_wallet,user_email,user_mobile,account_status,points from users";
			con = ConnectionUtil.getDBconnect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(viewUsers);
			while (rs.next()) {
				User allUsers = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getInt(9));
				userList.add(allUsers);

			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.closeStatement(stmt,con,rs);
		}

		return userList;

	}

									//user profile update
	public int update(User currentUser) {
		String update = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
				update = "update users set full_name=?,user_password=?,user_mobile=?,delivery_address=? where user_email='"
						+ currentUser.getUserMail() + "'";
				con = ConnectionUtil.getDBconnect();
				pstmt = con.prepareStatement(update);
				pstmt.setString(1, currentUser.getUserName());
				pstmt.setString(2, currentUser.getUserPassword());
				pstmt.setLong(3, currentUser.getUserMobile());
				pstmt.setString(4, currentUser.getAddress());
				int res = pstmt.executeUpdate();
				pstmt.executeUpdate(commitQuery);
				if (res > 0) {
					return res;
				} 
				
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					ConnectionUtil.close(pstmt,con);
				}

		return 0;
	}
	
							// delete user by admin
	public boolean deleteUser(int userId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = ConnectionUtil.getDBconnect();
			String delete = "update users set account_status =? where user_id=?";
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, "inactive");
			pstmt.setInt(2, userId);
			result = pstmt.executeUpdate();
			if(result > 0) {
				return true;
			} 

			} catch (Exception e) {
			e.printStackTrace();
			}finally {
				ConnectionUtil.close(pstmt,con);
			}
		
		return false;
	}


	
												//ADD MONEY TO WALLET

	public int addMoneyInWallet(double walletAmount, User currentUser) {

		int result = 0;
		User user = new User();
		PreparedStatement pstmt =null;
		Connection con = null;
		try {
				String walletQuery = "update users set user_wallet = ? where user_email =?";
				con=ConnectionUtil.getDBconnect();
				pstmt = con.prepareStatement(walletQuery);
				pstmt.setDouble(1, walletAmount);
				pstmt.setString(2, currentUser.getUserMail());
				result = pstmt.executeUpdate();
				pstmt.executeUpdate(commitQuery);
				if (result > 0) {
					UserDaoImpl userDao = new UserDaoImpl();
					currentUser.setWallet(walletAmount);
					user.setWallet(walletAmount);
					result=1;
			}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.close(pstmt,con);
			}

		return result;
	}
	
	

							// points update when purchase done
	
	public void updateUserPoints(Order order) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			String pointsQuery = "update users set points= ? where user_id = ?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(pointsQuery);
			pstmt.setInt(1, order.getUser().getPoints());
			pstmt.setInt(2, order.getUser().getUserId());
			pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		

	}
	

						//	update walletmoney	
	public void updateWalletMoney(Order order) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String query = "update users set user_wallet=? where user_id = ?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, order.getUser().getWallet());
			pstmt.setInt(2, order.getUser().getUserId());
			pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		
		

	}


	public int updatePassword(String confirmPassword, int userId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String updatePassword = "update users set user_password=? where user_id=?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(updatePassword);
			pstmt.setString(1, confirmPassword);
			pstmt.setInt(2, userId);
			int result = pstmt.executeUpdate();
			con.prepareStatement(commitQuery);
			pstmt.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}

		return 0;
	}
	
	

	public boolean updatePointsConverted(User CurrentUser) {

		boolean flag = false;
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			String query = "update users set points=0 where User_email=?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, CurrentUser.getUserMail());
			int result = pstmt.executeUpdate();
			CurrentUser.setPoints(0);
			pstmt.executeUpdate(commitQuery);
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}
		return flag;

	}
	
	public void updateUserPoints(int points,User currentUser) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String pointsQuery = "update users set points=? where user_id = ?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(pointsQuery);
			pstmt.setInt(1, points);
			pstmt.setInt(2, currentUser.getUserId());
			pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}

	}

						//	update walletmoney	
	public void updateWalletMoney(double wallet,User currentUser) {
		
		
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			String query = "update users set user_wallet=? where user_id =?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, wallet);
			pstmt.setInt(2, currentUser.getUserId());
			pstmt.executeUpdate();
			pstmt.executeUpdate(commitQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con);
		}

	}

	
	
	public boolean checkMail(String mail) {
		
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "select user_email from users where user_email= ? ";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
		
			if(rs.next())
			{
				flag=true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
		}
		System.out.println(flag);
		
		return flag;
	}
	
	public boolean checkMobileNum(Long mobileNumber)
	{
		boolean flag=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		 
		 
		try {
			String query="select user_mobile from users where user_mobile=?";
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, mobileNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				
				flag=true;
			} 
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(pstmt,con,rs);
		}
		
		return flag;
		
	}

	
	
}
