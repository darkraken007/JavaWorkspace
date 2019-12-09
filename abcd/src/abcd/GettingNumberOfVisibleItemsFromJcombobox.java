package abcd;

import javax.swing.JComboBox;

public class GettingNumberOfVisibleItemsFromJcombobox {

	 public static void main(String[] argv) throws Exception {
		    String[] items = new String[50];
		    for (int i = 0; i < items.length; i++) {
		      items[i] = "" + Math.random();
		    }
		    JComboBox cb = new JComboBox(items);

		    // Retrieve the current max visible rows
		    int maxVisibleRows = cb.getMaximumRowCount();

		    // Change the current max visible rows
		    maxVisibleRows = 20;
		    cb.setMaximumRowCount(maxVisibleRows);

		  }
}
