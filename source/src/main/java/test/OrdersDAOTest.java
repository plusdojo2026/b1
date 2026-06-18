package test;

import java.util.List;

import dao.OrdersDAO;
import dto.Order;

public class OrdersDAOTest {

    // 一覧表示
    public static void showAllData(List<Order> list) {

        if (list == null || list.isEmpty()) {
            System.out.println("データなし");
            return;
        }

        for (Order o : list) {
            System.out.println("ID：" + o.getId());
            System.out.println("ユーザーID：" + o.getUser_id());
            System.out.println("メニューID：" + o.getMenu_id());
            System.out.println("メニュー数：" + o.getMenu_count());
            System.out.println("マイメニューID：" + o.getMymenu_id());
            System.out.println("マイメニュー数：" + o.getMymenu_count());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        OrdersDAO dao = new OrdersDAO();

        // -------------------------
        // selectById
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");

        Order o1 = dao.selectById(1);

        if (o1 != null) {
            System.out.println("ID：" + o1.getId());
            System.out.println("ユーザーID：" + o1.getUser_id());
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // selectByUserId
        // -------------------------
        System.out.println("---------- selectByUserId()のテスト ----------");

        List<Order> list1 = dao.selectByUserId(1);
        showAllData(list1);

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        Order ins = new Order(
                0,      // id
                1,      // user_id
                1,      // menu_id
                2,      // menu_count
                1,      // mymenu_id
                1,      // mymenu_count
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            showAllData(dao.selectByUserId(1));
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        List<Order> upList = dao.selectByUserId(1);

        if (upList != null && !upList.isEmpty()) {

            // 最新のレコードを取得
            Order up = upList.get(upList.size() - 1);

            up.setMenu_count(99);

            if (dao.update(up)) {
                System.out.println("更新成功！");
                showAllData(dao.selectByUserId(1));
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

        List<Order> delList = dao.selectByUserId(1);

        if (delList != null && !delList.isEmpty()) {

            // 最新のレコードを削除
            int id = delList.get(delList.size() - 1).getId();

            if (dao.delete(id)) {
                System.out.println("削除成功！");
                showAllData(dao.selectByUserId(1));
            } else {
                System.out.println("削除失敗！");
            }

        } else {
            System.out.println("削除対象なし");
        }
    }
}