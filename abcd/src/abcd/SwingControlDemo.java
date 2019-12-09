package abcd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicLookAndFeel;
 
public class SwingControlDemo {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      SwingControlDemo  swingControlDemo = new SwingControlDemo();      
      swingControlDemo.showComboboxDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showComboboxDemo(){                                    
      headerLabel.setText("Control in action: JComboBox"); 

      final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();

      fruitsName.addElement("Apple");
      fruitsName.addElement("Grapes");
      fruitsName.addElement("Mango");
      fruitsName.addElement("Peer");
      fruitsName.addElement("java");
      fruitsName.addElement("mkm");
      fruitsName.addElement("asda");
      fruitsName.addElement("sdaskj");
      fruitsName.addElement("ruqw");
      fruitsName.addElement("1oiqwoi");
      fruitsName.addElement("asnkds");
      fruitsName.addElement("asdajnmkm");

      final JComboBox fruitCombo = new JComboBox(fruitsName);
      fruitCombo.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("DOWN"), "cDownArrow");
      fruitCombo.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("UP"), "cUpArrow");
      Action customDownArrow = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("in");
			JComboBox box = (JComboBox)arg0.getSource();
			BasicComboPopup pop = (BasicComboPopup)box.getAccessibleContext().getAccessibleChild(0);
			JList list	= pop.getList();
			System.out.println("next index" + "  "+ (list.getSelectedIndex()+1)%box.getItemCount());
			System.out.println("current index= " +list.getSelectedIndex()+ "dsasd --");
			if(((list.getSelectedIndex()+2)%box.getMaximumRowCount())==0){
				System.out.println("\n" + "in");
				Component c = (Container)pop.getComponent(0);
				if(c instanceof JScrollPane){
					JScrollPane scrollpane = (JScrollPane) c;
			        JScrollBar scrollBar = scrollpane.getVerticalScrollBar();
			        scrollBar.setValue(scrollBar.getBlockIncrement(1));
				}
			}

			list.setSelectedIndex(list.getSelectedIndex()+1);
			if((list.getSelectedIndex()+1)>box.getMaximumRowCount()){
				Component c = (Container)pop.getComponent(0);
				if(c instanceof JScrollPane){
					JScrollPane scrollpane = (JScrollPane) c;
			        JScrollBar scrollBar = scrollpane.getVerticalScrollBar();
			        scrollBar.setValue(scrollBar.getValue()+scrollBar.getUnitIncrement(1));
			        
				}
			}
			
		}
	};
	
	Action customUpArrow = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JComboBox box = (JComboBox)arg0.getSource();
			BasicComboPopup pop = (BasicComboPopup)box.getAccessibleContext().getAccessibleChild(0);
			JList list	= pop.getList();
			//System.out.println("next index" + "  "+ (list.getSelectedIndex()+1)%box.getItemCount());
			System.out.println("current index= " +list.getSelectedIndex() + "--current value= "+ (box.getItemCount()-list.getSelectedIndex()));
/*			if((((box.getItemCount()-list.getSelectedIndex())+1)%box.getMaximumRowCount())==0){
				Component c = (Container)pop.getComponent(0);
				if(c instanceof JScrollPane){
					JScrollPane scrollpane = (JScrollPane) c;
			        JScrollBar scrollBar = scrollpane.getVerticalScrollBar();
			        scrollBar.setValue(scrollBar.getUnitIncrement(-1));
				}
			}*/
			list.setSelectedIndex(list.getSelectedIndex()-1);

		}
	};
      fruitCombo.getActionMap().put("cDownArrow",customDownArrow);
      fruitCombo.getActionMap().put("cUpArrow", customUpArrow);
      fruitCombo.setSelectedIndex(0);

    //  JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);    

      JButton showButton = new JButton("Show");
      

      
      fruitCombo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getModifiers()==ActionEvent.MOUSE_EVENT_MASK || arg0.getModifiers()==ActionEvent.KEY_EVENT_MASK||true){
		//		System.out.println("arg0"+"  "+arg0.getModifiers());
			}
			
			
		}
	});

      /*fruitCombo.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
				
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
				System.out.println("enter key pressed"+arg0.getKeyCode());
			}
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});*/
      //System.out.println(fruitCombo.getComponentListeners().toString());
      controlPanel.add(fruitCombo);          
      controlPanel.add(showButton);    
      mainFrame.setVisible(true);             
   }
}