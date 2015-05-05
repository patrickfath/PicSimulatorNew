package picSimuNew;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class CreateRegister {
	static Table table;
	public static void setItemInput(Table table, TableItem item) {
		//		TableItem itemInut = new TableItem(table, SWT.NONE);
		for(int i = 1; i < 9; i++) {
			item.setText(i,"00");
//			item.setText(i,"0"+i);
		}
	}

	public static void createTheRegister(Composite linksOben) {

		table = new Table(linksOben, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		//		table.addSelectionListener(new SelectionAdapter() {
		//			public void widgetSelected(SelectionEvent e) {
		//				//				System.err.println(table.getSelectionIndex());
		//				int tableSelectionIndex = table.getSelectionIndex();
		//				TableItem itemsOfLine = table.getItem(tableSelectionIndex);
		////				Rectangle rectangle = itemsOfLine.getBounds();
		//				
		//				for(int i = 0; i < 9; i++) {
		//					System.err.println(itemsOfLine.getText(i));
		//				}
		//			}
		//		});

		for(int i = 0; i < 9; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setWidth(30);
			tableColumn.setResizable(false);			
			if(i != 0) {
				tableColumn.setText("0" + (i-1) +"");
			}		
			//			table.getColumn(i).pack(); //pack geht hier nicht wegen der eventuell anderen Größe einder Spalte nach eintragen eines neuen Wertes
		}

		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		table.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 1; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							final int column = i;
							final Text text = new Text(table, SWT.NONE);
							Listener textListener = new Listener() {
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, text.getText());
										text.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item
											.setText(column, text
													.getText());
											// FALL THROUGH
										case SWT.TRAVERSE_ESCAPE:
											text.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};
							text.addListener(SWT.FocusOut, textListener);
							text.addListener(SWT.Traverse, textListener);
							editor.setEditor(text, item, i);
							text.setText(item.getText(i));
							text.selectAll();
							text.setFocus();
							text.setTextLimit(2);
							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});

// register 02h --> PCL ::: nehme table.getItemCount /columnCount (siehe selectionAdapter)


		int zeileDez = 0;
		TableItem item = null;
		for(int i = 0; i < 32; i++) {
			Device device = Display.getCurrent();
			Color grey = new Color(device, 160, 160,160);
			item = new TableItem(table, SWT.NONE);

			String zeileHexa = Integer.toHexString(zeileDez);
			if (zeileHexa.length() < 2) {
				zeileHexa = '0' + zeileHexa;
			}
			item.setBackground(0,grey);
			item.setText(0,String.valueOf(zeileHexa).toUpperCase());

			zeileDez = zeileDez + 8;
			setItemInput(table,item);
		}
	}
	
	public static void editValuePCL(String addresstoJumpTo) {
		table.getItem(0).setText(3, addresstoJumpTo.substring(2, 4));
	}


}
