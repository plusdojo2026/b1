package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Vote;

public class VotesDAO {
	// 引数idのデータを返す
	public Vote selectById(int id) {

		Connection conn = null;
		Vote vote = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			String sql = "SELECT * FROM votes WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				vote = new Vote(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("contest_id"),
						rs.getInt("contestmenu_id"), rs.getTimestamp("created_at").toLocalDateTime(),
						rs.getTimestamp("updated_at").toLocalDateTime());
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

		return vote;
	}

	// 引数contest_idで指定された項目のデータを返す
	public List<Vote> selectByContestId(int contest_id) {
		Connection conn = null;
		List<Vote> votelist = new ArrayList<Vote>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM votes WHERE contest_id = ? ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, contest_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = ps.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Vote votes = new Vote(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("contest_id"),
						rs.getInt("contestmenu_id"), rs.getTimestamp("created_at").toLocalDateTime(),
						rs.getTimestamp("updated_at").toLocalDateTime());
				votelist.add(votes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			votelist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			votelist = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					votelist = null;
				}
			}
		}

		// 結果を返す
		return votelist;
	}

	// 👇 ★ここに追加するのがベスト
	public List<Vote> getTop3Votes() {
		Connection conn = null;
		List<Vote> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			String sql = """
					    SELECT contestmenu_id, COUNT(*) AS vote_count
					    FROM votes
					    GROUP BY contestmenu_id
					    ORDER BY vote_count DESC
					    LIMIT 3
					""";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Vote v = new Vote();
				v.setContestmenu_id(rs.getInt("contestmenu_id"));
				v.setVoteCount(rs.getInt("vote_count"));
				list.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	// 引数voteのデータを格納する
	public boolean insert(Vote vote) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			String sql = "INSERT INTO votes(user_id, contest_id, contestmenu_id) VALUES(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, vote.getUser_id());
			ps.setInt(2, vote.getContest_id());
			ps.setInt(3, vote.getContestmenu_id());

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

	// 引数voteで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Vote vote) {
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
			String sql = "UPDATE votes SET " + "user_id=?,contest_id=?,contestmenu_id=? " + "WHERE id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL文を完成させる
			ps.setInt(1, vote.getUser_id());
			ps.setInt(2, vote.getContest_id());
			ps.setInt(3, vote.getContestmenu_id());
			ps.setInt(4, vote.getId());

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
			String sql = "DELETE FROM votes WHERE id=?";
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