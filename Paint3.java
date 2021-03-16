package report2;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public  class Paint3 extends Frame implements MouseListener,MouseMotionListener, ActionListener{
	int x,y;
	ArrayList<Figure> objList;
	CheckboxGroup cbg,cbg_c;
	Checkbox c1,c2,c3,c4,c5,c6,co1,co2,co3;
	Button end,undo,clear;
	int mode=0;
	int mode_c=0;
	Figure obj;
	TextField text; 
	
	public static void main(String args[]) {
		Paint3 f=new Paint3();
		f.setSize(640,480);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);
	}
	Paint3(){
		objList=new ArrayList<Figure>();
		
		setLayout(null);
		cbg=new CheckboxGroup();
		cbg_c=new CheckboxGroup();
		
		text=new TextField(20);
		text.setBounds(170, 450, 300, 20);
		add(text);		
		
		c1=new Checkbox("丸",cbg,true);
		c1.setBounds(560,30,60,30);
		add(c1);
		c2=new Checkbox("円",cbg,false);
		c2.setBounds(560,60,60,30);
		add(c2);
		c3=new Checkbox("四角",cbg,false);
		c3.setBounds(560,90,60,30);
		add(c3);
		c4=new Checkbox("線",cbg,false);
		c4.setBounds(560,120,60,30);
		add(c4);
		c5=new Checkbox("楕円",cbg,false);
		c5.setBounds(560,150,60,30);
		add(c5);
		c6=new Checkbox("消しゴム",cbg,false);
		c6.setBounds(560,180,60,30);
		add(c6);
		co1=new Checkbox("赤",cbg_c,false);
		co1.setBounds(30,50,60,30);
		add(co1);
		co2=new Checkbox("黒",cbg_c,true);
		co2.setBounds(30,80,60,30);
		add(co2);
		co3=new Checkbox("青",cbg_c,false);
		co3.setBounds(30,110,60,30);
		add(co3);
		end=new Button("終了");
		end.setBounds(560,300,60,30);
		add(end);
		undo=new Button("Undo");
		undo.setBounds(560,270,60,30);
		add(undo);
		clear=new Button("Clear");
		clear.setBounds(560,240,60,30);
		add(clear);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		end.addActionListener(this);
		undo.addActionListener(this);
		clear.addActionListener(this);
		
	}

	@Override public void paint(Graphics g) {
		Figure f;
		for(int i=0;i<objList.size();i++) {
			f=objList.get(i);
			f.paint(g);
		}
		if(mode >= 1) obj.paint(g);
	}
	@Override public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==undo) {
			if(objList.size()>0) {
			objList.remove(objList.size()-1);
			repaint();
			}
		}else if(obj==clear) {
			objList.clear();
			repaint();
		}else if(obj==end) {
			System.exit(0);
		}
	}
	@Override public void mousePressed(MouseEvent e) {
		Checkbox c,co;
		x=e.getX();
		y=e.getY();
		c=cbg.getSelectedCheckbox();
		co=cbg_c.getSelectedCheckbox();
		obj=null;
	
		if(co==co1) {
			mode_c=1;
		}else if(co==co2) {
			mode_c=2;
		}else if(co==co3) {
			mode_c=3;
		}
		if(c==c1) {
			mode=1;
			obj=new Dot();
		}else if(c==c2) {
			mode=2;
			obj=new Circle();
		}else if(c==c3) {
			mode=2;
			obj=new Rect();
		}else if(c==c4) {
			mode=2;
			obj=new Line();
		}else if(c==c5) {
			mode=2;
			obj=new Ellipse();
		}else if(c==c6) {
			mode=2;
			obj=new Erase();
		}

		if(obj != null) {
			obj.moveto(x,y);
			repaint();
		}

	}
	public void mouseReleased(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if(mode_c==1) {
			obj.setPenColor(Color.red);
		}else if(mode_c==2) {
			obj.setPenColor(Color.black);
		}else if(mode_c==3) {
			obj.setPenColor(Color.blue);
		}
		if(mode==1) obj.moveto(x, y);
		else if(mode == 2) obj.setWH(x - obj.x, y - obj.y);
		if(mode>=1) {
			objList.add(obj);
			obj=null;
		}
		mode=0;
		repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if(mode==1) {
			obj.moveto(x,y);
		}else if(mode==2) {
			obj.setWH(x - obj.x, y - obj.y);
		}
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}

}
