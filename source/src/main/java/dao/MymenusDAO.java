package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Mymenu;

public class MymenusDAO {
	// 引数idのデータを返す
	public Mymenu selectById(int id) {

	    Connection conn = null;
	    Mymenu mymenu = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM mymenus WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            mymenu = new Mymenu(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("user_id"),
	                rs.getInt("buns1"),
	                rs.getInt("buns2"),
	                rs.getInt("patty1"),
	                rs.getInt("patty2"),
	                rs.getInt("patty3"),
	                rs.getInt("vege1"),
	                rs.getInt("vege2"),
	                rs.getInt("vege3"),
	                rs.getInt("topping1"),
	                rs.getInt("topping2"),
	                rs.getInt("topping3"),
	                rs.getInt("sauce"),
	                rs.getInt("price"),
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

	    return mymenu;
	}
	
	// 引数user_idで指定された項目で検索して、取得されたデータのリストを返す
	public List<Mymenu> select(int user_id) {
		Connection conn = null;
		List<Mymenu> mymenulist = new ArrayList<Mymenu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT id,name,user_id,buns1,buns2,patty1,patty2,patty3,"
					+ "vege1,vege2,vege3,topping1,topping2,topping3,sauce,price,created_at,"
					+ "updated_at FROM mymenus WHERE user_id = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,user_id);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Mymenu mymenus = new Mymenu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("user_id"),
                        rs.getInt("buns1"),
                        rs.getInt("buns2"),
                        rs.getInt("patty1"),
                        rs.getInt("patty2"),
                        rs.getInt("patty3"),
                        rs.getInt("vege1"),
                        rs.getInt("vege2"),
                        rs.getInt("vege3"),
                        rs.getInt("topping1"),
                        rs.getInt("topping2"),
                        rs.getInt("topping3"),
                        rs.getInt("sauce"),
                        rs.getInt("price"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				mymenulist.add(mymenus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mymenulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			mymenulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					mymenulist = null;
				}
			}
		}

		// 結果を返す
		return mymenulist;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Mymenu mymenu) {
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
	                "INSERT INTO mymenus (" +
	                "name,user_id,buns1,buns2," +
	                "patty1,patty2,patty3," +
	                "vege1,vege2,vege3," +
	                "topping1,topping2,topping3," +
	                "sauce,price" +
	                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (mymenu.getName() != null) {
				ps.setString(1, mymenu.getName());
			} else {
				ps.setString(1, "");
			}
            ps.setInt(2, mymenu.getUser_id());
            ps.setInt(3, mymenu.getBuns1());
            ps.setInt(4, mymenu.getBuns2());

            ps.setInt(5, mymenu.getPatty1());
            ps.setInt(6, mymenu.getPatty2());
            ps.setInt(7, mymenu.getPatty3());

            ps.setInt(8, mymenu.getVege1());
            ps.setInt(9, mymenu.getVege2());
            ps.setInt(10, mymenu.getVege3());

            ps.setInt(11, mymenu.getTopping1());
            ps.setInt(12, mymenu.getTopping2());
            ps.setInt(13, mymenu.getTopping3());

            ps.setInt(14, mymenu.getSauce());
            ps.setInt(15, mymenu.getPrice());

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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Mymenu mymenu) {
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
	                "UPDATE mymenus SET " +
	                "name=?,user_id=?,buns1=?,buns2=?," +
	                "patty1=?,patty2=?,patty3=?," +
	                "vege1=?,vege2=?,vege3=?," +
	                "topping1=?,topping2=?,topping3=?," +
	                "sauce=?,price=? " +
	                "WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (mymenu.getName() != null) {
				ps.setString(1, mymenu.getName());
			} else {
				ps.setString(1, "");
			}
			ps.setInt(2, mymenu.getUser_id());
            ps.setInt(3, mymenu.getBuns1());
            ps.setInt(4, mymenu.getBuns2());

            ps.setInt(5, mymenu.getPatty1());
            ps.setInt(6, mymenu.getPatty2());
            ps.setInt(7, mymenu.getPatty3());

            ps.setInt(8, mymenu.getVege1());
            ps.setInt(9, mymenu.getVege2());
            ps.setInt(10, mymenu.getVege3());

            ps.setInt(11, mymenu.getTopping1());
            ps.setInt(12, mymenu.getTopping2());
            ps.setInt(13, mymenu.getTopping3());

            ps.setInt(14, mymenu.getSauce());
            ps.setInt(15, mymenu.getPrice());

            ps.setInt(16, mymenu.getId());

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

	// 引数cardで指定された番号のレコードを削除し、成功したらtrueを返す
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
			String sql = "DELETE FROM mymenus WHERE id=?";
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