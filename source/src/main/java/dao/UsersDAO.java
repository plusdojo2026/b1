package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class UsersDAO {
	// 引数idで指定された項目で検索して、取得されたデータを返す
	public User selectById(int id) {
		Connection conn = null;
		User user = null ;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
	        	user = new User(
        			rs.getInt("id"), 
					rs.getString("phone"), 
					rs.getString("pw"), 
					rs.getString("name"),
					rs.getInt("rank_id"), 
					rs.getString("icon"), 
					rs.getInt("vote"),
					rs.getInt("levelup_menu"), 
					rs.getTimestamp("created_at").toLocalDateTime(), 
					rs.getTimestamp("updated_at").toLocalDateTime()
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	    return user;
	}

	// 引数phone,pwで指定された項目で検索して、取得されたデータを返す
	public User search(String phone ,String pw) {
		Connection conn = null;
		User user = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "SELECT * FROM users WHERE phone = ? AND pw = ? LIMIT 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			if (phone != null) {
			    ps.setString(1,phone);
			} else {
			    ps.setString(1, "");
			}

			if (pw != null) {
			    ps.setString(2, pw);
			} else {
			    ps.setString(2, "");
			}
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
	        	user = new User(
        			rs.getInt("id"), 
					rs.getString("phone"), 
					rs.getString("pw"), 
					rs.getString("name"),
					rs.getInt("rank_id"), 
					rs.getString("icon"), 
					rs.getInt("vote"),
					rs.getInt("levelup_menu"), 
					rs.getTimestamp("created_at").toLocalDateTime(), 
					rs.getTimestamp("updated_at").toLocalDateTime()
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	    return user;
	}

	// 引数userで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User user) {
		Connection conn = null;
		boolean result = false;
		
		

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO users (phone,pw,name,rank_id,icon,vote,levelup_menu)" + "VALUES (?, ?, ?, 1, ?, 5, 1)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			if (user.getPhone() != null) {
			    pStmt.setString(1, user.getPhone());
			} else {
			    pStmt.setString(1, "");
			}

			if (user.getPw() != null) {
			    pStmt.setString(2, user.getPw());
			} else {
			    pStmt.setString(2, "");
			}

			if (user.getName() != null) {
			    pStmt.setString(3, user.getName());
			} else {
			    pStmt.setString(3, "");
			}

			if (user.getIcon() != null) {
			    pStmt.setString(4, user.getIcon());
			} else {
			    pStmt.setString(4, "default.png");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数userで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(User user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "UPDATE users SET phone=?, pw=?, name=?, rank_id=?,icon=?,vote=?,levelup_menu=?, updated_at=NOW() " + "WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user.getPhone() != null) {
			    pStmt.setString(1, user.getPhone());
			} else {
			    pStmt.setString(1, "");
			}

			if (user.getPw() != null) {
			    pStmt.setString(2, user.getPw());
			} else {
			    pStmt.setString(2, "");
			}

			if (user.getName() != null) {
			    pStmt.setString(3, user.getName());
			} else {
			    pStmt.setString(3, "");
			}

			pStmt.setInt(4, user.getRank_id());

			if (user.getIcon() != null) {
			    pStmt.setString(5, user.getIcon());
			} else {
			    pStmt.setString(5, "default.png");
			}

			pStmt.setInt(6, user.getVote());

			pStmt.setInt(7, user.getLevelup_menu());

			pStmt.setInt(8, user.getId());


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数idで指定された番号のレコードを削除し、成功したらtrueを返す
	public boolean delete(int id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "DELETE FROM users WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1,id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
