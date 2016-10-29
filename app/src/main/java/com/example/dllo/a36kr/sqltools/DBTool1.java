package com.example.dllo.a36kr.sqltools;

import android.os.Handler;
import android.os.Looper;

import com.example.dllo.a36kr.volley.MyApp;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by xiaoyuLu on 16/10/29.
 *
 * 泛型学习: http://jingyan.baidu.com/article/454316ab76711df7a7c03aa0.html
 *
 * 问题: 泛型书写方式, 照着明达的已经改了
 */
public class DBTool1 {

    private static DBTool1 dbTool = new DBTool1();
    private Executor threadPool; // 线程池
    private LiteOrm liteOrm;
    private Handler handler; // 用于线程切换

    private DBTool1() {
        int coreNum = Runtime.getRuntime().availableProcessors();
        threadPool = Executors.newFixedThreadPool(coreNum); // 注意线程池的多个初始化方式

        liteOrm = LiteOrm.newSingleInstance(MyApp.getContext(), "MyDatabase.db");

        handler = new Handler(Looper.getMainLooper());
    }

    public static DBTool1 getInstance() {
        return dbTool;
    }

    /* 插入数据库 */
    public<T> void insertData(final T tClass) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.insert(tClass);
            }
        });
    }

//    /* 查询数据库 综合写法*/
//    public<T> void queryAllData(final OnQueryListener onQueryListener) {
//        threadPool.execute(new Runnable() {
//            // 定义这个Class 对象 放在 liteOrm.query(aClass);
//            Class aClass;
//            @Override
//            public void run() {
//                final ArrayList<T> classArrayList = liteOrm.query(aClass);
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        onQueryListener.onQuery(classArrayList);
//                    }
//                });
//            }
//        });
//    }

    /* 查询数据库 分开写法 */
    public<T> void queryAllData(Class<T> tClass,OnQueryListener onQueryListener) {
        threadPool.execute(new QueryRunnable(onQueryListener, tClass));
    }

    /* 第一个Runnable类, 外部的Runnable */
    private class QueryRunnable<T> implements Runnable {

        private OnQueryListener onQueryListener;
        private Class<T> tClass = null;

        public QueryRunnable(OnQueryListener onQueryListener, Class<T> tClass) {
            this.onQueryListener = onQueryListener;
            this.tClass = tClass;
        }

        @Override
        public void run() {
            // 查询
            ArrayList<T> tArrayList = liteOrm.query(tClass);
            handler.post(new CallBackRunable(onQueryListener, tArrayList));
        }
    }

    /* 第二个Runnable(内部嵌套的那个): Handler使用的 Runnable , 将查询到 数据返回到主线程使用的Runnable*/
    private class CallBackRunable<T> implements Runnable{

        private OnQueryListener onQueryListener;
        private List<T> tList;

        public CallBackRunable(OnQueryListener onQueryListener, List<T> tList) {
            this.onQueryListener = onQueryListener;
            this.tList = tList;
        }

        @Override
        public void run() {
            onQueryListener.onQuery(tList);
        }
    }

    /* 定义接口, 实现数据的回调 */
    public interface OnQueryListener<T> {
        void onQuery(List<T> classList);
    }

}
