package test;

import java.util.List;

import dao.VotesDAO;
import dto.Vote;

public class VotesDAOTest {

    // 一覧表示
    public static void showAllData(List<Vote> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("データなし");
            return;
        }

        for (Vote v : list) {
            System.out.println("ID：" + v.getId());
            System.out.println("ユーザーID：" + v.getUser_id());
            System.out.println("コンテストID：" + v.getContest_id());
            System.out.println("コンテストメニューID：" + v.getContestmenu_id());
            System.out.println();
        }
    }

    // 1件表示
    public static void showData(Vote vote) {
        if (vote == null) {
            System.out.println("データなし");
            return;
        }

        System.out.println("ID：" + vote.getId());
        System.out.println("ユーザーID：" + vote.getUser_id());
        System.out.println("コンテストID：" + vote.getContest_id());
        System.out.println("コンテストメニューID：" + vote.getContestmenu_id());
        System.out.println();
    }

    public static void main(String[] args) {

        VotesDAO dao = new VotesDAO();

        // -------------------------
        // selectById
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");

        Vote vote1 = dao.selectById(1);

        if (vote1 != null) {
            showData(vote1);
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // selectByContestId
        // -------------------------
        System.out.println("---------- selectByContestId()のテスト ----------");

        List<Vote> list1 = dao.selectByContestId(1);
        showAllData(list1);

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        Vote ins = new Vote(
                0,
                1,      // user_id
                999,    // contest_id
                1,      // contestmenu_id
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            showAllData(dao.selectByContestId(999));
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        List<Vote> upList = dao.selectByContestId(999);

        if (upList != null && !upList.isEmpty()) {

            Vote up = upList.get(0);

            up.setContest_id(998);
            up.setContestmenu_id(2);

            if (dao.update(up)) {
                System.out.println("更新成功！");
                showAllData(dao.selectByContestId(998));
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

        List<Vote> delList = dao.selectByContestId(998);

        if (delList != null && !delList.isEmpty()) {

            int id = delList.get(0).getId();

            if (dao.delete(id)) {
                System.out.println("削除成功！");

                List<Vote> checkList = dao.selectByContestId(998);

                if (checkList == null || checkList.isEmpty()) {
                    System.out.println("削除確認OK（データなし）");
                } else {
                    showAllData(checkList);
                }

            } else {
                System.out.println("削除失敗！");
            }

        } else {
            System.out.println("削除対象なし");
        }
    }
}