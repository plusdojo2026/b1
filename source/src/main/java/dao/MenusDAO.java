package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Menu;

public class MenusDAO {
	// 引数idのデータを返す
	public Menu selectById(int id) {

	    Connection conn = null;
	    Menu menu = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM menus WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            menu = new Menu(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("image"),
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
	                rs.getInt("judge"),
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

	    return menu;
	}
	
	// 引数nameのデータを返す
	public Menu selectByName(String name) {

	    Connection conn = null;
	    Menu menu = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM menus WHERE name=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        if (name!= null) {
				ps.setString(1,name);
			} else {
				ps.setString(1,"");
			}

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            menu = new Menu(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("image"),
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
	                rs.getInt("judge"),
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

	    return menu;
	}
		
	// 引数bunsで指定された項目で検索して、取得されたデータのリストを返す
	public List<Menu> selectByBuns(int buns) {
		Connection conn = null;
		List<Menu> menulist = new ArrayList<Menu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM menus WHERE buns1 = ? or buns2=? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,buns);
			ps.setInt(2,buns);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
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
                        rs.getInt("judge"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				menulist.add(menus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			menulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			menulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					menulist = null;
				}
			}
		}

		// 結果を返す
		return menulist;
	}
	
	// 引数pattyで指定された項目で検索して、取得されたデータのリストを返す

	public List<Menu> selectByPatty(int patty) {
		Connection conn = null;
		List<Menu> menulist = new ArrayList<Menu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "SELECT * FROM menus WHERE patty1 = ? or patty2 = ? or patty3 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,patty);
			ps.setInt(2,patty);
			ps.setInt(3,patty);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
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
                        rs.getInt("judge"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				menulist.add(menus);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			menulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			menulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					menulist = null;
				}
			}
		}

		// 結果を返す
		return menulist;
	}
	
	// 引数vegeで指定された項目で検索して、取得されたデータのリストを返す

	public List<Menu> selectByVege(int vege) {
		Connection conn = null;
		List<Menu> menulist = new ArrayList<Menu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "SELECT * FROM menus WHERE vege1 = ? or vege2 = ? or vege3 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,vege);
			ps.setInt(2,vege);
			ps.setInt(3,vege);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
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
                        rs.getInt("judge"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				menulist.add(menus);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			menulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			menulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					menulist = null;
				}
			}
		}

		// 結果を返す
		return menulist;
	}
	
	// 引数toppingで指定された項目で検索して、取得されたデータのリストを返す

	public List<Menu> selectByTopping(int topping) {
		Connection conn = null;
		List<Menu> menulist = new ArrayList<Menu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "SELECT * FROM menus WHERE topping1 = ? or topping2 = ? or topping3 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,topping);
			ps.setInt(2,topping);
			ps.setInt(3,topping);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
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
                        rs.getInt("judge"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				menulist.add(menus);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			menulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			menulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					menulist = null;
				}
			}
		}

		// 結果を返す
		return menulist;
	}

	// 引数sauceで指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectBySauce(int sauce) {
		Connection conn = null;
		List<Menu> menulist = new ArrayList<Menu>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM menus WHERE sauce = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,sauce);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
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
                        rs.getInt("judge"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
				menulist.add(menus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			menulist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			menulist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					menulist = null;
				}
			}
		}

		// 結果を返す
		return menulist;
	}

	// 引数menuで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Menu menu) {
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
	                "INSERT INTO menus (" +
	                "name,image," +
	                "buns1,buns2" +
	                "patty1,patty2,patty3," +
	                "vege1,vege2,vege3," +
	                "topping1,topping2,topping3," +
	                "sauce,price,judge" +
	                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (menu.getName() != null) {
				ps.setString(1, menu.getName());
			} else {
				ps.setString(1, "");
			}
			if (menu.getImage() != null) {
				ps.setString(2, menu.getImage());
			} else {
				ps.setString(2, "");
			}
            ps.setInt(3, menu.getBuns1());
            ps.setInt(4, menu.getBuns2());
            ps.setInt(5, menu.getPatty1());
            ps.setInt(6, menu.getPatty2());
            ps.setInt(7, menu.getPatty3());
            ps.setInt(8, menu.getVege1());
            ps.setInt(9, menu.getVege2());
            ps.setInt(10, menu.getVege3());
            ps.setInt(11, menu.getTopping1());
            ps.setInt(12, menu.getTopping2());
            ps.setInt(13, menu.getTopping3());
            ps.setInt(14, menu.getSauce());
            ps.setInt(15, menu.getPrice());
            ps.setInt(16, menu.getJudge());

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

	// 引数menuで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Menu menu) {
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
	                "UPDATE menus SET " +
	                "name=?,image=?," +
	                "buns1=?,buns2=?," +
	                "patty1=?,patty2=?,patty3=?," +
	                "vege1=?,vege2=?,vege3=?," +
	                "topping1=?,topping2=?,topping3=?," +
	                "sauce=?,price=?,judge=? " +
	                "WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (menu.getName() != null) {
				ps.setString(1, menu.getName());
			} else {
				ps.setString(1, "");
			}
			if (menu.getImage() != null) {
				ps.setString(2, menu.getImage());
			} else {
				ps.setString(2, "");
			}
			ps.setInt(3, menu.getBuns1());
			ps.setInt(4, menu.getBuns2());
            ps.setInt(5, menu.getPatty1());
            ps.setInt(6, menu.getPatty2());
            ps.setInt(7, menu.getPatty3());
            ps.setInt(8, menu.getVege1());
            ps.setInt(9, menu.getVege2());
            ps.setInt(10, menu.getVege3());
            ps.setInt(11, menu.getTopping1());
            ps.setInt(12, menu.getTopping2());
            ps.setInt(13, menu.getTopping3());
            ps.setInt(14, menu.getSauce());
            ps.setInt(15, menu.getPrice());
            ps.setInt(16, menu.getJudge());
            ps.setInt(17, menu.getId());
            
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
			String sql = "DELETE FROM menus WHERE id=?";
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