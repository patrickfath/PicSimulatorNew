package picSimuNew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

public class OpenDocument {
	static String path;

	public static ArrayList<String> openDocument(Composite leftDown, ArrayList<String> arrayLinesReadIn) {
		CreateCodeTable.testTable.removeAll();
		CreateCodeTable.createTable(leftDown);
		
				
		FileDialog fileDialog = new FileDialog(leftDown.getShell(), SWT.OPEN);
		fileDialog.setText("open");
		fileDialog.setFilterPath("D:/User");
		String filename = fileDialog.open();
		if(filename != null) {
			try { 
				BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
				path = filename.toString();
				String singleLineOfDocument = "";
				while((singleLineOfDocument = bufferedReader.readLine()) != null){
//					CreateCodeTable.insertText(singleLineOfDocument);
					arrayLinesReadIn.add(singleLineOfDocument);
				}
				CreateCodeTable.arrayInsertAllInOne(arrayLinesReadIn);
				bufferedReader.close();
				leftDown.layout();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			leftDown.layout();
		}
		
		return arrayLinesReadIn;
	}

}
