package continental;

import javax.swing.JFrame;

public class VentanaTic extends JFrame  {

	
 		public VentanaTic(){
 			super("Sudoku");
 			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 			tictactoe t= new tictactoe();
 			this.add(t);
 			this.pack();
 			this.setResizable(false);
 			this.setVisible(true);
 			this.setLocationRelativeTo(null);
 		}
 		
 	public static void main(String[] args) {
 		VentanaTic Principal = new VentanaTic();
 	}
}

