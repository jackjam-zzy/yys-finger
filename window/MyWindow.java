package window;

import service.Impl.RobotServiceImpl;
import service.RobotService;
import util.YysUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

///**
// * @Description:
// * @Author: zzy
// */
//public class MyWindow{
//
//    private RobotService robotService = new RobotServiceImpl();
//
//    public void init(){
//        JFrame frame = new JFrame("🦅🐏🦁-金✋☞");
//        frame.setResizable(false);//设置窗体是否可以改变大小
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭就退出
//        frame.setBounds(490,270,980,540);
//
//
//        JPanel panel = new JPanel();
////        panel.setBackground(Color.BLACK);
//        frame.add(panel);
//
//        panel.setLayout(null);
//
//
//
//        JLabel jl_x = new JLabel("x 坐标:");
//        jl_x.setBounds(10,20,50,25);
//        panel.add(jl_x);
//
//        JTextField jt_x = new JTextField(20);
//        jt_x.setBounds(70,20,150,25);
//        panel.add(jt_x);
//
//        JLabel jl_y = new JLabel("y 坐标:");
//        jl_y.setBounds(230,20,50,25);
//        panel.add(jl_y);
//
//        JTextField jt_y = new JTextField(20);
//        jt_y.setBounds(290,20,150,25);
//        panel.add(jt_y);
//
//        JButton jb_get = new JButton("取得鼠标位置");
//        jb_get.setBounds(500,20,150,25);
//        panel.add(jb_get);
//        jb_get.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        frame.setVisible(true);//设置可见
//
//    }
//
//}
