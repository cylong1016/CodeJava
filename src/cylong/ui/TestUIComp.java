package cylong.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import cylong.ui.button.Button;
import cylong.ui.chart.Chart;
import cylong.ui.chart.Column;
import cylong.ui.frame.Frame;
import cylong.ui.textfield.TextField;

/**
 * 测试自己定义的UI组件
 * @author cylong
 * @version 2014年12月29日 下午8:01:00
 */
public class TestUIComp {

	public static void main(String[] args) {
		Frame frame = new Frame();
		Dimension dimen = new Dimension(80, 30);
		JPanel panel = new JPanel();
		frame.add(panel);
		
		// 测试自定义Button
		Button btn = new Button("测试按钮");
		btn.setPreferredSize(dimen);
		panel.add(btn);
		
		// 测试自定义TextField
		TextField textField = new TextField();
		textField.setPreferredSize(dimen);
		panel.add(textField);
		
		// 测试表格
		ArrayList<Column> columns = new ArrayList<Column>();
		columns.add(new Column("hhh1", 2, Color.blue));
		columns.add(new Column("hhh2", 15, Color.blue));
		columns.add(new Column("hhh3", 7, Color.blue));
		columns.add(new Column("hhh4", 18, Color.blue));
		columns.add(new Column("hhh5", 21.1, Color.blue));
		Chart chart = new Chart("测试", columns, 21.1);
		chart.setPreferredSize(new Dimension(809, 145));
		panel.add(chart);
		
		frame.setVisible(true);
		frame.start();
	}

}
