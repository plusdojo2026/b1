package test;

import dao.UsersDAO;
import dto.User;

public class UsersDAOTest {

    // データ表示
    public static void showData(User user) {
        if (user == null) {
            System.out.println("データなし");
            return;
        }

        System.out.println("ID：" + user.getId());
        System.out.println("電話番号：" + user.getPhone());
        System.out.println("PW：" + user.getPw());
        System.out.println("名前：" + user.getName());
        System.out.println("ランクID：" + user.getRank_id());
        System.out.println("アイコン：" + user.getIcon());
        System.out.println("投票数：" + user.getVote());
        System.out.println("レベルアップメニュー数：" + user.getLevelup_menu());
        System.out.println();
    }

    public static void main(String[] args) {

        UsersDAO dao = new UsersDAO();

        // -------------------------
        // selectById
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");

        User user1 = dao.selectById(1);

        if (user1 != null) {
            showData(user1);
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        User ins = new User(
                0,
                "09099998888",
                "testpw",
                "テストユーザー",
                1,
                "test.png",
                0,
                0,
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // search
        // -------------------------
        System.out.println("---------- search()のテスト ----------");

        User searchUser = dao.search("09099998888", "testpw");

        if (searchUser != null) {
            showData(searchUser);
        } else {
            System.out.println("検索失敗");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        if (searchUser != null) {

            searchUser.setName("更新ユーザー");
            searchUser.setPw("newpw");

            if (dao.update(searchUser)) {
                System.out.println("更新成功！");

                User updated = dao.search("09099998888", "newpw");
                showData(updated);

            } else {
                System.out.println("更新失敗！");
            }

        } else {
            System.out.println("更新対象なし");
        }

        // -------------------------
        // delete
        // -------------------------
        System.out.println("---------- delete()のテスト ----------");

        User deleteUser = dao.search("09099998888", "newpw");

        if (deleteUser != null) {

            if (dao.delete(deleteUser.getId())) {
                System.out.println("削除成功！");

                User check = dao.search("09099998888", "newpw");

                if (check == null) {
                    System.out.println("削除確認OK（データなし）");
                } else {
                    System.out.println("削除失敗");
                }

            } else {
                System.out.println("削除失敗！");
            }

        } else {
            System.out.println("削除対象なし");
        }
    }
}