package picSimuNew;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class CreateCodeTable {
	static Table testTable;
	public static void createTable(Composite linksUnten) {
		testTable = new Table(linksUnten, SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION );
		testTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		testTable.setLinesVisible(true);
		testTable.setHeaderVisible(false);
		TableColumn checkColumn = new TableColumn(testTable, SWT.NONE);
		checkColumn.setText("x");
		checkColumn.setWidth(20);
		TableColumn textColumn = new TableColumn(testTable, SWT.SINGLE);
		textColumn.setWidth(1000);
	}

	public static void arrayInsertAllInOne(ArrayList<String> allInOneString) {
		int indexI = 0;
		for(int i = 0; i < allInOneString.size(); i++) {
			TableItem item = new TableItem(testTable, SWT.NONE);
			TableEditor editor = new TableEditor(testTable);
			Button checkButton = new Button(testTable, SWT.CHECK);
			editor.grabHorizontal = true;
			editor.setEditor(checkButton, item, 0);
			
			String subOfLine = allInOneString.get(i).substring(27);

			if(allInOneString.get(i).isEmpty()) {
				
			} else {
				item.setFont(new org.eclipse.swt.graphics.Font( testTable.getDisplay(), "Courier", 6,SWT.NONE));
				item.setText(1,subOfLine);
				if(subOfLine.startsWith("start") || subOfLine.startsWith("Start")) {
					indexI = i;
				}
			}
		}		
		if(indexI != 0) {
			testTable.setTopIndex(indexI);
			testTable.setSelection(indexI+1);
		}
	}


	public static void insertText(String lineOfDocument) {

		TableItem item = new TableItem(testTable, SWT.NONE);
		TableEditor editor = new TableEditor(testTable);
		Button checkButton = new Button(testTable, SWT.CHECK);
		editor.grabHorizontal = true;
		editor.setEditor(checkButton, item, 0);	


		String subOfLine = lineOfDocument.substring(27);
		System.err.println(subOfLine);

		if(lineOfDocument.isEmpty()) {

		} else {
			item.setFont(new org.eclipse.swt.graphics.Font( testTable.getDisplay(), "Courier", 6,SWT.NONE));
			item.setText(1,subOfLine);
			if(lineOfDocument.contains("goto")) {
				testTable.setSelection(item);
			}
		}
	}
}
