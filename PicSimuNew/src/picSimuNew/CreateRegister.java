package picSimuNew;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class CreateRegister {

	public static void createTheRegister(Composite linksOben) {

		Table table = new Table(linksOben, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		for(int i = 0; i < 9; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setWidth(30);
			tableColumn.setResizable(false);
			if(i != 0) {
				tableColumn.setText(i-1 +"");
			}		
			table.getColumn(i).pack();
		}
		int zeileDez = 0;
		for(int i = 0; i < 20; i++) {
			Device device = Display.getCurrent();
			Color grey = new Color(device, 160, 160,160);
			TableItem item = new TableItem(table, SWT.NONE);
			String zeileHexa = Integer.toHexString(zeileDez);
			if (zeileHexa.length() < 2) {
				zeileHexa = '0' + zeileHexa;
			}
			item.setBackground(0,grey);
			item.setText(0,String.valueOf(zeileHexa));

			zeileDez = zeileDez + 8;
		}

	}
}
