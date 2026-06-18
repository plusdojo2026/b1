package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Order;

public class OrdersDAO {
	// 引数idのデータを返す
	public Order selectById(int id) {

	    Connection conn = null;
	    Order order = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM orders WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	order = new Order(
	                rs.getInt("id"),
	                rs.getInt("user_id"),                
	                rs.getInt("menu_id"),
	                rs.getInt("menu_count"),
	                rs.getInt("mymenu_id"),
	                rs.getInt("mymenu_count"),
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

	    return order;
	}
	
	// 引数user_idで指定された項目のデータを返す
	public List<Order> selectByUserId(int user_id) {
		Connection conn = null;
		List<Order> orderlist = new ArrayList<Order>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Order orders = new Order(
						rs.getInt("id"),
		                rs.getInt("user_id"),                
		                rs.getInt("menu_id"),
		                rs.getInt("menu_count"),
		                rs.getInt("mymenu_id"),
		                rs.getInt("mymenu_count"),
		                rs.getTimestamp("created_at").toLocalDateTime(),
		                rs.getTimestamp("updated_at").toLocalDateTime() 
		            );
				orderlist.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			orderlist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			orderlist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					orderlist = null;
				}
			}
		}

		// 結果を返す
		return orderlist;
	}
	
	
	// 引数orderのデータを格納する
	public boolean insert(Order order) {
	    Connection conn = null;
	    boolean result = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/b1?"
	            + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
	            "root", "password");

	        String sql =
	            "INSERT INTO orders(user_id, menu_id, menu_count, mymenu_id, mymenu_count) VALUES(?,?,?,?,?)";

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, order.getUser_id());
	        ps.setInt(2, order.getMenu_id());
	        ps.setInt(3, order.getMenu_count());
	        ps.setInt(4, order.getMymenu_id());
	        ps.setInt(5, order.getMymenu_count());

	        if (ps.executeUpdate() == 1) {
	            result = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return result;
	}

	// 引数orderで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Order order) {
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
			String sql =
	                "UPDATE orders SET " +
	                "user_id=?,menu_id=?,menu_count=?,mymenu_id=?,mymenu_count=? " +
	                "WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			ps.setInt(1, order.getUser_id());
	        ps.setInt(2, order.getMenu_id());
	        ps.setInt(3, order.getMenu_count());
	        ps.setInt(4, order.getMymenu_id());
	        ps.setInt(5, order.getMymenu_count());
	        ps.setInt(6, order.getId());
	        
			// SQL文を実行する
			if (ps.executeUpdate() == 1) {
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
			String sql = "DELETE FROM orders WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, id);

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