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
		//		testTable.setLinesVisible(true);
		testTable.setHeaderVisible(false);
		TableColumn checkColumn = new TableColumn(testTable, SWT.NONE);
		checkColumn.setText("x");
		checkColumn.setWidth(20);
		TableColumn textColumn = new TableColumn(testTable, SWT.SINGLE);
		textColumn.setWidth(1000);
	}

	public static void arrayInsertAllInOne(ArrayList<String> arrayLinesReadIn) {
		int indexI = 0;
		for(int i = 0; i < arrayLinesReadIn.size(); i++) {
			TableItem item = new TableItem(testTable, SWT.NONE);
			TableEditor editor = new TableEditor(testTable);
			Button checkButton = new Button(testTable, SWT.CHECK);
			editor.grabHorizontal = true;
			editor.setEditor(checkButton, item, 0);

			String operandRegisterComment = arrayLinesReadIn.get(i).substring(27);

			if(arrayLinesReadIn.get(i).isEmpty()) {

			} else {
				item.setFont(new org.eclipse.swt.graphics.Font( testTable.getDisplay(), "Courier", 6,SWT.NONE));
				item.setText(1,operandRegisterComment);
				if(arrayLinesReadIn.get(i).startsWith("0000")) {
					testTable.setSelection(i);
				}
			}
		}	
	}

	public static void nextStep() {
		int selIndex = testTable.getSelectionIndex();
		testTable.setSelection(selIndex+1);
	}

	public static void runStep(ArrayList<String> arrayLinesReadIn, int literals, boolean pclCheck, int indexPlus) {
		int aTestSelIndex = testTable.getSelectionIndex();

		if(pclCheck == true && indexPlus == 2) {
			aTestSelIndex = aTestSelIndex+2;
			testTable.setSelection(aTestSelIndex);
		} else if(pclCheck == true && indexPlus != 2) {
			aTestSelIndex = aTestSelIndex+ indexPlus;
			testTable.setSelection(aTestSelIndex);
		} else {
			String literalToHex = Integer.toHexString(literals);
			while(literalToHex.length() < 4) {
				literalToHex = "0" + literalToHex;
			}

			for(int i = 0; i < arrayLinesReadIn.size(); i++) {
				String adressesToJumpHex = arrayLinesReadIn.get(i).substring(0, 4);
				if(adressesToJumpHex.equals(literalToHex)) {
					testTable.setSelection(i);
					CreateStateRegister.setPCL(adressesToJumpHex);
					//TODO
					System.err.println("FU");
				}
			}
		}
	}


	/**
	 * (abgleich u.U des Arrays mit dem TabellenIndex)
	 * bestimme die Sprungadresse (bsp. goto main, springe zu main (in der Tabelle und im Array))
	 * Springe einfach zu der Stelle im Array in der Tabelle
	 * 
	 */



	//death
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
