package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Contest;

public class ContestsDAO {
	// 引数idのデータを返す
	public Contest selectById(int id) {

	    Connection conn = null;
	    Contest contest = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM contests WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            contest = new Contest(
	                rs.getInt("id"),
	                rs.getString("name"),                
	                rs.getTimestamp("start_at").toLocalDateTime(),
	                rs.getTimestamp("end_at").toLocalDateTime(),
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

	    return contest;
	}
	
	// 引数nameで指定された項目のデータを返す
	public Contest selectByName(String name) {
		Connection conn = null;
		Contest contest = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM contests WHERE name = ? ORDER BY id DESC limit 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if (name != null) {
				ps.setString(1,name);
			} else {
				ps.setString(1, "");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			if (rs.next()) {
	            contest = new Contest(
	                rs.getInt("id"),
	                rs.getString("name"),                
	                rs.getTimestamp("start_at").toLocalDateTime(),
	                rs.getTimestamp("end_at").toLocalDateTime(),
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

	    return contest;
	}
	
	// 引数contestで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Contest contest) {
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
	                "INSERT INTO contests (" +
	                "name,start_at,end_at" +
	                ") VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (contest.getName() != null) {
				ps.setString(1, contest.getName());
			} else {
				ps.setString(1, "");
			}
			ps.setTimestamp(2, java.sql.Timestamp.valueOf(contest.getStart_at()));
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(contest.getEnd_at()));
            
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
	public boolean update(Contest contest) {
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
	                "UPDATE contests SET " +
	                "name=?,start_at=?,end_at=? " +
	                "WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (contest.getName() != null) {
				ps.setString(1, contest.getName());
			} else {
				ps.setString(1, "");
			}
			ps.setTimestamp(2, java.sql.Timestamp.valueOf(contest.getStart_at()));
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(contest.getEnd_at()));
            ps.setInt(4, contest.getId());
            
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
			String sql = "DELETE FROM contests WHERE id=?";
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

	// 現在日時が含まれる項目のデータを返す
	public Contest selectByNowDate() {
		Connection conn = null;
		Contest contest = null;
	
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
	
			// SQL文を準備する
			String sql = "SELECT * FROM contests WHERE NOW() BETWEEN start_at AND end_at;"
					+ "";
			PreparedStatement ps = conn.prepareStatement(sql);
	
			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();
	
			// 結果表をコレクションにコピーする
			if (rs.next()) {
	            contest = new Contest(
	                rs.getInt("id"),
	                rs.getString("name"),                
	                rs.getTimestamp("start_at").toLocalDateTime(),
	                rs.getTimestamp("end_at").toLocalDateTime(),
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
	
	    return contest;
    
	}
}