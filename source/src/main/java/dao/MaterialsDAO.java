package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Material;

public class MaterialsDAO {
	// 引数idのデータを返す
	public Material selectById(int id) {

	    Connection conn = null;
	    Material material = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM materials WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	material = new Material(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("category"),
	                rs.getInt("price"),
	                rs.getString("image"),
	                rs.getInt("protein"),
	                rs.getInt("df"),
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

	    return material;
	}
	
	// 引数nameで指定された項目で検索して、取得されたデータのリストを返す
	public List<Material> selectByName(String name) {
		Connection conn = null;
		List<Material> materiallist = new ArrayList<Material>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM materials WHERE name = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if (name != null) {
				ps.setString(1,name);
			} else {
				ps.setString(1, "");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Material materials = new Material(
						rs.getInt("id"),
		                rs.getString("name"),
		                rs.getInt("category"),
		                rs.getInt("price"),
		                rs.getString("image"),
		                rs.getInt("protein"),
		                rs.getInt("df"),
		                rs.getTimestamp("created_at").toLocalDateTime(),
		                rs.getTimestamp("updated_at").toLocalDateTime()
		            );
				materiallist.add(materials);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			materiallist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			materiallist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					materiallist = null;
				}
			}
		}

		// 結果を返す
		return materiallist;
	}
	
	// 引数categoryで指定された項目で検索して、取得されたデータのリストを返す
	public List<Material> selectByCategory(int category) {
		Connection conn = null;
		List<Material> materiallist = new ArrayList<Material>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM materials WHERE category = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,category);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Material materials = new Material(
						rs.getInt("id"),
		                rs.getString("name"),
		                rs.getInt("category"),
		                rs.getInt("price"),
		                rs.getString("image"),
		                rs.getInt("protein"),
		                rs.getInt("df"),
		                rs.getTimestamp("created_at").toLocalDateTime(),
		                rs.getTimestamp("updated_at").toLocalDateTime()
		            );
				materiallist.add(materials);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			materiallist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			materiallist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					materiallist = null;
				}
			}
		}

		// 結果を返す
		return materiallist;
	}

	// 引数materialで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Material material) {
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
	                "INSERT INTO materials (" +
	                "name,category,price," +
	                "image,protein,df" +
	                ") VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (material.getName() != null) {
				ps.setString(1, material.getName());
			} else {
				ps.setString(1, "");
			}
            ps.setInt(2, material.getCategory());
            ps.setInt(3, material.getPrice());
            if (material.getImage() != null) {
				ps.setString(4, material.getImage());
			} else {
				ps.setString(4, "");
			}
            ps.setInt(5, material.getProtein());
            ps.setInt(6, material.getDf());

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

	// 引数materialで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Material material) {
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
	                "UPDATE materials SET " +
	                "name=?,category=?,price=?," +
	                "image=?,protein=?,df=? " +
	                "WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (material.getName() != null) {
				ps.setString(1, material.getName());
			} else {
				ps.setString(1, "");
			}
            ps.setInt(2, material.getCategory());
            ps.setInt(3, material.getPrice());
            if (material.getImage() != null) {
				ps.setString(4, material.getImage());
			} else {
				ps.setString(4, "");
			}
            ps.setInt(5, material.getProtein());
            ps.setInt(6, material.getDf());
            ps.setInt(7, material.getId());
            
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
			String sql = "DELETE FROM materials WHERE id=?";
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