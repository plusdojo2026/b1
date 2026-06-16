package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Mymenu;

public class MymenuDAO {
	// 引数numberのデータを返す
	public Mymenu selectById(int id) {

	    Connection conn = null;
	    Mymenu card = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // データベースに接続する
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
 					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
 					"root", "password");
	        String sql = "SELECT * FROM mymenus WHERE number=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            card = new Mymenu(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("image"),
	                rs.getInt("user_id"),
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
	                rs.getTimestamp("created_at").toLocalDateTime(),
	                rs.getTimestamp("updated_at").toLocalDateTime();
	            );
	            private int id;
	        	private String name;			
	        	private String image;			
	        	private int user_id;			
	        	private int buns;		
	        	private int patty1;                         
	        	private int patty2;				
	        	private int patty3;				
	        	private int vege1;				
	        	private int vege2;				
	        	private int vege3;				
	        	private int topping1;
	        	private int topping2;				
	        	private int topping3;				
	        	private int sauce;				
	        	private int price;				
	        	private LocalDateTime created_at;
	        	private LocalDateTime updated_at;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return card;
	}
	
	// 引数card指定された項目で検索して、取得されたデータのリストを返す
	public List<Bc> select(String id,Bc card) {
		Connection conn = null;
		List<Bc> cardList = new ArrayList<Bc>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "M@kar0n1617");

			// SQL文を準備する
			String table = "bc_"+id;
			String sql = "SELECT number,company,department,position,name,name_kana,zipcode,"
					+ "address,phone,fax,email,remarks FROM "+table+" WHERE "
					+ "company LIKE ? AND department LIKE ? AND position LIKE ? AND "
					+ "name LIKE ? AND name_kana LIKE ? AND zipcode LIKE ? AND "
					+ "address LIKE ? AND phone LIKE ? AND fax LIKE ? AND email LIKE ? AND "
					+ "remarks LIKE ? ORDER BY number";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany() != null) {
				pStmt.setString(1, "%" + card.getCompany() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (card.getDepartment() != null) {
				pStmt.setString(2, "%" + card.getDepartment() + "%");
			} else {
				pStmt.setString(2, "%");
			}
			if (card.getPosition() != null) {
				pStmt.setString(3, "%" + card.getPosition() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			if (card.getName() != null) {
				pStmt.setString(4, "%" + card.getName() + "%");
			} else {
				pStmt.setString(4, "%");
			}
			if (card.getName_kana() != null) {
				pStmt.setString(5, "%" + card.getName_kana() + "%");
			} else {
				pStmt.setString(5, "%");
			}
			if (card.getZipcode() != null) {
				pStmt.setString(6, "%" + card.getZipcode() + "%");
			} else {
				pStmt.setString(6, "%");
			}
			if (card.getAddress() != null) {
				pStmt.setString(7, "%" + card.getAddress() + "%");
			} else {
				pStmt.setString(7, "%");
			}
			if (card.getPhone() != null) {
				pStmt.setString(8, "%" + card.getPhone() + "%");
			} else {
				pStmt.setString(8, "%");
			}
			if (card.getFax() != null) {
				pStmt.setString(9, "%" + card.getFax() + "%");
			} else {
				pStmt.setString(9, "%");
			}
			if (card.getEmail() != null) {
				pStmt.setString(10, "%" + card.getEmail() + "%");
			} else {
				pStmt.setString(10, "%");
			}
			if (card.getRemarks() != null) {
				pStmt.setString(11, "%" + card.getRemarks() + "%");
			} else {
				pStmt.setString(11, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bc bc = new Bc(rs.getInt("number"),rs.getString("company"),rs.getString("department"),
						rs.getString("position"),rs.getString("name"),rs.getString("name_kana"),
						rs.getString("zipcode"),rs.getString("address"),rs.getString("phone"),
						rs.getString("fax"),rs.getString("email"),rs.getString("remarks"));
				cardList.add(bc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(String id,Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "M@kar0n1617");

			// SQL文を準備する
			String table = "bc_"+id;
			String sql = "INSERT INTO "+table+" VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany() != null) {
				pStmt.setString(1, card.getCompany());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getDepartment() != null) {
				pStmt.setString(2, card.getDepartment());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getPosition() != null) {
				pStmt.setString(3, card.getPosition());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getName() != null) {
				pStmt.setString(4, card.getName());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getName_kana() != null) {
				pStmt.setString(5, card.getName_kana());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getZipcode() != null) {
				pStmt.setString(6, card.getZipcode());
			} else {
				pStmt.setString(6, "");
			}
			if (card.getAddress() != null) {
				pStmt.setString(7, card.getAddress());
			} else {
				pStmt.setString(7, "");
			}
			if (card.getPhone() != null) {
				pStmt.setString(8, card.getPhone());
			} else {
				pStmt.setString(8, "");
			}
			if (card.getFax() != null) {
				pStmt.setString(9, card.getFax());
			} else {
				pStmt.setString(9, "");
			}
			if (card.getEmail() != null) {
				pStmt.setString(10, card.getEmail());
			} else {
				pStmt.setString(10, "");
			}
			if (card.getRemarks() != null) {
				pStmt.setString(11, card.getRemarks());
			} else {
				pStmt.setString(11, "");
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(String id,Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "M@kar0n1617");

			// SQL文を準備する
			String table = "bc_"+id;
			String sql = "UPDATE "+table+" SET company=?,department=?,position=?,name=?,name_kana=?,zipcode=?,address=?,phone=?,fax=?,email=?,remarks=? WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany() != null) {
				pStmt.setString(1, card.getCompany());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getDepartment() != null) {
				pStmt.setString(2, card.getDepartment());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getPosition() != null) {
				pStmt.setString(3, card.getPosition());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getName() != null) {
				pStmt.setString(4, card.getName());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getName_kana() != null) {
				pStmt.setString(5, card.getName_kana());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getZipcode() != null) {
				pStmt.setString(6, card.getZipcode());
			} else {
				pStmt.setString(6, "");
			}
			if (card.getAddress() != null) {
				pStmt.setString(7, card.getAddress());
			} else {
				pStmt.setString(7, "");
			}
			if (card.getPhone() != null) {
				pStmt.setString(8, card.getPhone());
			} else {
				pStmt.setString(8, "");
			}
			if (card.getFax() != null) {
				pStmt.setString(9, card.getFax());
			} else {
				pStmt.setString(9, "");
			}
			if (card.getEmail() != null) {
				pStmt.setString(10, card.getEmail());
			} else {
				pStmt.setString(10, "");
			}
			if (card.getRemarks() != null) {
				pStmt.setString(11, card.getRemarks());
			} else {
				pStmt.setString(11, "");
			}
			pStmt.setInt(12, card.getNumber());

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

	// 引数cardで指定された番号のレコードを削除し、成功したらtrueを返す
	public boolean delete(String id,Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "M@kar0n1617");

			// SQL文を準備する
			String table = "bc_"+id;
			String sql = "DELETE FROM "+table+" WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, card.getNumber());

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