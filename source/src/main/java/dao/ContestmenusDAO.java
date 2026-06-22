package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Contestmenu;

public class ContestmenusDAO {
	// 引数idのデータを返す
	public Contestmenu selectById(int id) {

	    Connection conn = null;
	    Contestmenu contestmenu = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM contestmenus WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	contestmenu = new Contestmenu(
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
	                rs.getInt("contest_id"),
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

	    return contestmenu;
	}
	
	// 引数idのデータを返す
	public Contestmenu selectByName(String name) {

	    Connection conn = null;
	    Contestmenu contestmenu = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM contestmenus WHERE name=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        if (name!= null) {
				ps.setString(1,name);
			} else {
				ps.setString(1, "");
			}

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	contestmenu = new Contestmenu(
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
	                rs.getInt("contest_id"),
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

	    return contestmenu;
	}
	
	// 引数user_idで指定された項目で検索して、取得されたデータのリストを返す
	public List<Contestmenu> selectByUserId(int user_id) {
		Connection conn = null;
		List<Contestmenu> contestmenulist = new ArrayList<Contestmenu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM contestmenus WHERE user_id = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,user_id);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Contestmenu contestmenus = new Contestmenu(
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
                        rs.getInt("contest_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				contestmenulist.add(contestmenus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			contestmenulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			contestmenulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					contestmenulist = null;
				}
			}
		}

		// 結果を返す
		return contestmenulist;
	}
	
	// 引数user_idで指定された項目で検索して、取得されたデータのリストを返す
	public List<Contestmenu> selectByContestId(int contest_id) {
		Connection conn = null;
		List<Contestmenu> contestmenulist = new ArrayList<Contestmenu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM contestmenus WHERE contest_id = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,contest_id);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Contestmenu contestmenus = new Contestmenu(
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
                        rs.getInt("contest_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				contestmenulist.add(contestmenus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			contestmenulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			contestmenulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					contestmenulist = null;
				}
			}
		}

		// 結果を返す
		return contestmenulist;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Contestmenu contestmenu) {
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
	                "INSERT INTO contestmenus (" +
	                "name,user_id,buns1,buns2," +
	                "patty1,patty2,patty3," +
	                "vege1,vege2,vege3," +
	                "topping1,topping2,topping3," +
	                "sauce,price,contest_id" +
	                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (contestmenu.getName() != null) {
				ps.setString(1, contestmenu.getName());
			} else {
				ps.setString(1, "");
			}
            ps.setInt(2, contestmenu.getUser_id());
            ps.setInt(3, contestmenu.getBuns1());
            ps.setInt(4, contestmenu.getBuns2());
            ps.setInt(5, contestmenu.getPatty1());
            ps.setInt(6, contestmenu.getPatty2());
            ps.setInt(7, contestmenu.getPatty3());
            ps.setInt(8, contestmenu.getVege1());
            ps.setInt(9, contestmenu.getVege2());
            ps.setInt(10, contestmenu.getVege3());
            ps.setInt(11, contestmenu.getTopping1());
            ps.setInt(12, contestmenu.getTopping2());
            ps.setInt(13, contestmenu.getTopping3());
            ps.setInt(14, contestmenu.getSauce());
            ps.setInt(15, contestmenu.getPrice());
            ps.setInt(16, contestmenu.getContest_id());

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
	public boolean update(Contestmenu contestmenu) {
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
	                "UPDATE contestmenus SET " +
	                "name=?,user_id=?,buns1=?,buns2=?," +
	                "patty1=?,patty2=?,patty3=?," +
	                "vege1=?,vege2=?,vege3=?," +
	                "topping1=?,topping2=?,topping3=?," +
	                "sauce=?,price=?,contest_id=? " +
	                "WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (contestmenu.getName() != null) {
				ps.setString(1, contestmenu.getName());
			} else {
				ps.setString(1, "");
			}
			ps.setInt(2, contestmenu.getUser_id());
            ps.setInt(3, contestmenu.getBuns1());
            ps.setInt(4, contestmenu.getBuns2());
            ps.setInt(5, contestmenu.getPatty1());
            ps.setInt(6, contestmenu.getPatty2());
            ps.setInt(7, contestmenu.getPatty3());
            ps.setInt(8, contestmenu.getVege1());
            ps.setInt(9, contestmenu.getVege2());
            ps.setInt(10, contestmenu.getVege3());
            ps.setInt(11, contestmenu.getTopping1());
            ps.setInt(12, contestmenu.getTopping2());
            ps.setInt(13, contestmenu.getTopping3());
            ps.setInt(14, contestmenu.getSauce());
            ps.setInt(15, contestmenu.getPrice());
            ps.setInt(16, contestmenu.getContest_id());
            ps.setInt(17, contestmenu.getId());

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
			String sql = "DELETE FROM contestmenus WHERE id=?";
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
	
	// コンテストIDからユーザー限定のリストを返す
	public List<Contestmenu> selectByContestId_User(int contest_id) {
	    Connection conn = null;
	    List<Contestmenu> contestmenulist = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/b1?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password"
	        );

	        String sql = "SELECT * FROM contestmenus WHERE contest_id = ? AND user_id != 1 ORDER BY id";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, contest_id);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Contestmenu contestmenus = new Contestmenu(
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
	                rs.getInt("contest_id"),
	                rs.getTimestamp("created_at").toLocalDateTime(),
	                rs.getTimestamp("updated_at").toLocalDateTime()
	            );
	            contestmenulist.add(contestmenus);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        // ここで null にしない！空リストのまま返す
	    } finally {
	        if (conn != null) {
	            try { conn.close(); } catch (SQLException e) {}
	        }
	    }

	    return contestmenulist;  // ← 空でも絶対 null にならない
	}
	
	// コンテストIDから店主限定のリストを返す
	public List<Contestmenu> selectByContestId_Admin(int contest_id) {
		Connection conn = null;
		List<Contestmenu> contestmenulist = new ArrayList<Contestmenu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM contestmenus WHERE contest_id = ? AND user_id = 1 ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,contest_id);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Contestmenu contestmenus = new Contestmenu(
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
                        rs.getInt("contest_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				contestmenulist.add(contestmenus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			contestmenulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			contestmenulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					contestmenulist = null;
				}
			}
		}

		// 結果を返す
		return contestmenulist;
	}
}