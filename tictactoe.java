package continental;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jpl7.Query;


public class tictactoe extends JPanel implements MouseListener, ActionListener{
	private String array[];
	private boolean turn;
	private int xsize;
	private int ysize;
	
	public tictactoe(){
		super();
		this.array= new String [9];
		this.turn=true;//user
		this.xsize=600;
		this.ysize=600;
		
		this.setPreferredSize(new Dimension(this.xsize,this.ysize));
		this.addMouseListener(this);
		this.setFocusable(true);
	}
	public void changeturn(){
		if(this.turn){
			this.turn=false;
		}
		else{
			this.turn=true;
		}
	}
	
	public boolean setx(int num){
		if(this.array[num]!=""){
			this.array[num]="x";
			return true;
		}
		return false;
		
	}
	public boolean seto(int num){
		if(this.array[num]!=""){
		this.array[num]="o";
		return true;
		}
		return false;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(7, 33, 99));
		g.drawLine(199, 0, 199, 600);
		g.drawLine(200, 0, 200, 600);
		g.drawLine(201, 0, 201, 600);
		g.drawLine(399, 0, 399, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(401, 0, 401, 600);
		g.drawLine(0, 199, 600, 199);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 201, 600, 201);
		g.drawLine(0, 399, 600, 399);
		g.drawLine(0, 400, 600, 400);
		g.drawLine(0, 401, 600, 401);
		this.paintX(g);
		this.paintO(g);
		
	}
	public void paintO(Graphics g){
		
		
		if(array[0]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(15,15,170, 170);
		}
		if(array[1]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(215,15,170, 170);
		}
		if(array[2]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(415,15,170, 170);
		}
		if(array[3]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(15,215,170, 170);
		}
		if(array[4]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(215,215,170, 170);
		}
		if(array[5]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(415,215,170, 170);
		}
		if(array[6]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(15,415,170, 170);
		}
		if(array[7]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(215,415,170, 170);
		}
		if(array[8]=="o"){
			g.setColor(new Color(2, 255, 99));
			g.fillOval(415,415,170, 170);
		}
	}
	
	public void paintX(Graphics g){
	
		
		if(array[0]=="x"){
			g.setColor(new Color(255, 255, 99));
			g.fillRect(15, 15, 170, 170);
		}
		if(array[1]=="x"){
			g.fillRect(215,15,170, 170);
		}
		
		if(array[2]=="x"){
			g.fillRect(415,15,170, 170);
		}
		g.setColor(new Color(255, 255, 99));
		if(array[3]=="x"){
			g.fillRect(15, 215, 170, 170);
		}
		if(array[4]=="x"){
			g.fillRect(215, 215, 170, 170);
		}
		if(array[5]=="x"){
			g.fillRect(415, 215, 170, 170);
		}
		
		if(array[6]=="x"){
			g.fillRect(15, 415, 170, 170);
		}
		if(array[7]=="x"){
			g.fillRect(215, 415, 170, 170);
		}
		if(array[7]=="x"){
			g.fillRect(415, 415, 170, 170);
		}
	}
	public int  getCasillax(int x){
		int casilla= x/(this.xsize/3);
		return casilla;
	}
	public int  getCasillay(int y){
		int casilla= y/(this.ysize/3);
		return casilla;
	}
	
	public int getCasilla(int x, int y){
		if(x==0&&y==0){
			return 0;
		}
		if(x==1&&y==0){
			return 1;
		}
		if(x==2&&y==0){
			return 2;
		}
		if(x==0&&y==1){
			return 3;
		}
		if(x==1&&y==1){
			return 4;
		}
		if(x==2&&y==1){
			return 5;
		}
		if(x==0&&y==2){
			return 6;
		}
		if(x==1&&y==2){
			return 7;
		}
		if(x==2&&y==2){
			return 8;
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		String tl="consult('C:/Users/Sandra/Desktop/java/continental/src/continental/TicTacToe.pl')";
		Query el =new Query(tl);
		System.out.println(tl+ " "+(el.hasSolution()?"success":" fail"));
		tictactoe ven= new tictactoe();
		String s = "run";
	    Query q = new Query(s);
	    // run the query
	    if (q.hasNext()) {
	      // now I can ask for the father of nikos
	     System.out.println("que pex");
	      q = new Query(s);}

		JFrame jf= new JFrame();
		jf.setTitle("Tic-Tac-Toe");
		jf.getContentPane().add(ven);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.turn){
		int x = this.getCasillax(e.getY());
		int y = this.getCasillay(e.getX());
		int casilla= this.getCasilla(y, x);
		System.out.println(this.array[casilla]);
		System.out.println(x+","+y);
		setx(casilla);
		this.changeturn();
		}
		
		repaint();
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("holi");
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
