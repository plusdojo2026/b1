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
	                rs.getInt("buns"),
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
	                rs.getInt("buns"),
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
			String sql = "SELECT * FROM menus WHERE buns = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,buns);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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
	
	// 引数patty1で指定された項目で検索して、取得されたデータのリストを返す
	public List<Menu> selectByPatty1(int patty1) {
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
			String sql = "SELECT * FROM menus WHERE patty1 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,patty1);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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
	
	// 引数patty2で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByPatty2(int patty2) {
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
			String sql = "SELECT * FROM menus WHERE patty2 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,patty2);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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

	// 引数patty3で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByPatty3(int patty3) {
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
			String sql = "SELECT * FROM menus WHERE patty3 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,patty3);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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

	// 引数vege1で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByVege1(int vege1) {
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
			String sql = "SELECT * FROM menus WHERE vege1 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,vege1);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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

	// 引数vege2で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByVege2(int vege2) {
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
			String sql = "SELECT * FROM menus WHERE vege2 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,vege2);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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
		
	// 引数vege3で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByVege3(int vege3) {
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
			String sql = "SELECT * FROM menus WHERE vege3 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,vege3);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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

	// 引数topping1で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByTopping1(int topping1) {
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
			String sql = "SELECT * FROM menus WHERE topping1 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,topping1);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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

	// 引数topping2で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByTopping2(int topping2) {
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
			String sql = "SELECT * FROM menus WHERE topping2 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,topping2);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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

	// 引数topping3で指定された項目で検索して、取得されたデータのリストを返す
	
	public List<Menu> selectByTopping3(int topping3) {
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
			String sql = "SELECT * FROM menus WHERE topping3 = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,topping3);
			

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Menu menus = new Menu(
						rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getInt("buns"),
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
                        rs.getInt("buns"),
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


	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
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
	                "name,image,buns," +
	                "patty1,patty2,patty3," +
	                "vege1,vege2,vege3," +
	                "topping1,topping2,topping3," +
	                "sauce,price,judge" +
	                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(3, menu.getBuns());
            ps.setInt(4, menu.getPatty1());
            ps.setInt(5, menu.getPatty2());
            ps.setInt(6, menu.getPatty3());
            ps.setInt(7, menu.getVege1());
            ps.setInt(8, menu.getVege2());
            ps.setInt(9, menu.getVege3());
            ps.setInt(10, menu.getTopping1());
            ps.setInt(11, menu.getTopping2());
            ps.setInt(12, menu.getTopping3());
            ps.setInt(13, menu.getSauce());
            ps.setInt(14, menu.getPrice());
            ps.setInt(15, menu.getJudge());

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
	                "name=?,image=?,buns=?," +
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
			ps.setInt(3, menu.getBuns());
            ps.setInt(4, menu.getPatty1());
            ps.setInt(5, menu.getPatty2());
            ps.setInt(6, menu.getPatty3());
            ps.setInt(7, menu.getVege1());
            ps.setInt(8, menu.getVege2());
            ps.setInt(9, menu.getVege3());
            ps.setInt(10, menu.getTopping1());
            ps.setInt(11, menu.getTopping2());
            ps.setInt(12, menu.getTopping3());
            ps.setInt(13, menu.getSauce());
            ps.setInt(14, menu.getPrice());
            ps.setInt(15, menu.getJudge());

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