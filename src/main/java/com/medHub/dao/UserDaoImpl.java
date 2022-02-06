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
	
							//register new user
	public void insert(User user) {
		
		Connection con = null;
		PreparedStatement pst =null;
		try {
			String insert = "insert into users (full_name,user_mobile,user_password,user_email) values(?,?,?,?)";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(insert);
			pst.setString(1, user.getUserName());
			pst.setLong(2, user.getUserMobile());
			pst.setString(3, user.getUserPassword());
			pst.setString(4, user.getUserMail());
			pst.executeUpdate();
			pst = con.prepareStatement(commitQuery);
			pst.execute();
		
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(pst!=null){
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}     	
				}
				if(con !=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

	}
	

								//	user login
	public User login(User user) {

		
		Connection con = null;
		PreparedStatement pst  = null;
		try {

			String check = "select user_id,full_name,delivery_address,user_password,user_wallet,user_email,user_mobile,account_status,points from users where user_email= ? and user_password= ? ";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(check);
			pst.setString(1, user.getUserMail());
			pst.setString(2, user.getUserPassword());
			int i = pst.executeUpdate();
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("full_name"), rs.getString("delivery_address"), rs.getString("user_password"), rs.getDouble("user_wallet"),
						rs.getString("user_email"), rs.getLong("user_mobile"), rs.getString("account_status"), rs.getInt("points"));

				return user;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pst!=null){
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}     	
				}
				if(con !=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return null;

	}
	
	
	
								//list all users access by admin
	public List<User> ViewAllUser() {
		
		List<User> userList = new ArrayList<>();
		Statement stm =null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			String viewUsers = "select  user_id,full_name,delivery_address,user_password,user_wallet,user_email,user_mobile,account_status,points from users";
			conn = ConnectionUtil.getDBconnect();
			stm = conn.createStatement();
			rs = stm.executeQuery(viewUsers);
			while (rs.next()) {
				User allUsers = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getInt(9));
				userList.add(allUsers);

			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return userList;

	}

									//user profile update
	public int update(User currentUser) {
		String update = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
				update = "update users set full_name=?,user_password=?,user_mobile=?,delivery_address=? where user_email='"
						+ currentUser.getUserMail() + "'";
				con = ConnectionUtil.getDBconnect();
				pst = con.prepareStatement(update);
				pst.setString(1, currentUser.getUserName());
				pst.setString(2, currentUser.getUserPassword());
				pst.setLong(3, currentUser.getUserMobile());
				pst.setString(4, currentUser.getAddress());
				int res = pst.executeUpdate();
				pst.executeUpdate(commitQuery);
				if (res > 0) {
					return res;
				} 
				
			} catch (Exception e) {
			e.printStackTrace();
			}finally {
				if(pst!=null){
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}     	
				}
				if(con !=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		return 0;
	}
	
	
								//get user details by userId
	public User getUserById(int userId) throws NullPointerException{
		
		
		Connection con = null;
		PreparedStatement pst = null;
		User userModule = null;
		String getuserId = "select * from users where user_id=?";
		try {
			
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(getuserId);
			pst.setInt(1, userModule.getUserId());
			ResultSet rs = pst.executeQuery(getuserId);
		} catch (SQLException  | NullPointerException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

		return userModule;

	}
	
							// delete user by admin
	public boolean deleteUser(int userId) {

		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		try {
			con = ConnectionUtil.getDBconnect();
			String delete = "update users set account_status =? where user_id=?";
			pst = con.prepareStatement(delete);
			pst.setString(1, "inactive");
			pst.setInt(2, userId);
			result = pst.executeUpdate();
			if(result > 0) {
				return true;
			} 
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}


	
												//ADD MONEY TO WALLET

	public int addMoneyInWallet(double walletAmount, User currentUser) {

		int result = 0;
		User user = new User();
		PreparedStatement pst =null;
		Connection con = null;
		try {
				String walletQuery = "update users set user_wallet = ? where user_email =?";
				con=ConnectionUtil.getDBconnect();
				pst = con.prepareStatement(walletQuery);
				pst.setDouble(1, walletAmount);
				pst.setString(2, currentUser.getUserMail());
				result = pst.executeUpdate();
				pst.executeUpdate(commitQuery);
				if (result > 0) {
					UserDaoImpl userDao = new UserDaoImpl();
					currentUser.setWallet(walletAmount);
					user.setWallet(walletAmount);
					result=1;
			}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(pst!=null){
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}     	
				}
				if(con !=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		return result;
	}
	
	

							// points update when purchase done
	
	public void updateUserPoints(Order order) {
		
		Connection con = null;
		PreparedStatement pst =null;
		try {
			String pointsQuery = "update users set points= ? where user_id = ?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(pointsQuery);
			pst.setInt(1, order.getUser().getPoints());
			pst.setInt(2, order.getUser().getUserId());
			pst.executeUpdate();
			pst = con.prepareStatement(commitQuery);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

	}
	

						//	update walletmoney	
	public void updateWalletMoney(Order order) {
		
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String query = "update users set user_wallet=? where user_id = ?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setDouble(1, order.getUser().getWallet());
			pst.setInt(2, order.getUser().getUserId());
			pst.executeUpdate();
			pst.executeUpdate(commitQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}


	public int updatePassword(String confirmPassword, int userId) {
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String updatePassword = "update users set user_password=? where user_id=?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(updatePassword);
			pst.setString(1, confirmPassword);
			pst.setInt(2, userId);
			int result = pst.executeUpdate();
			con.prepareStatement(commitQuery);
			pst.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;
	}
	
	

	public boolean updatePointsConverted(User CurrentUser) {

		boolean flag = false;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			String query = "update users set points=0 where User_email=?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setString(1, CurrentUser.getUserMail());
			int result = pst.executeUpdate();
			CurrentUser.setPoints(0);
			pst.executeUpdate(commitQuery);
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;

	}
	
	public void updateUserPoints(int points,User currentUser) {
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String pointsQuery = "update users set points=? where user_id = ?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(pointsQuery);
			pst.setInt(1, points);
			pst.setInt(2, currentUser.getUserId());
			pst.executeUpdate();
			pst = con.prepareStatement(commitQuery);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

						//	update walletmoney	
	public void updateWalletMoney(double wallet,User currentUser) {
		
		
		PreparedStatement pst = null;
		Connection con = null;
		try {
			String query = "update users set user_wallet=? where user_id =?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setDouble(1, wallet);
			pst.setInt(2, currentUser.getUserId());
			pst.executeUpdate();
			pst.executeUpdate(commitQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	
	
	public boolean checkMail(String mail) {
		
		boolean flag = true;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String query = "select * from users where user_email= ? ";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setString(1, mail);
			ResultSet result = pst.executeQuery();
		
			if(result.next())
			{
				flag=false;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				     	
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return flag;
	}
	
	public boolean checkMobileNum(Long mobileNumber)
	{
		boolean flag=false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		 
		 
		try {
			String query="select user_mobile from users where user_mobile=?";
			con = ConnectionUtil.getDBconnect();
			pst = con.prepareStatement(query);
			pst.setLong(1, mobileNumber);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				
				flag=true;
			} 
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flag;
		
	}

	
	
}
