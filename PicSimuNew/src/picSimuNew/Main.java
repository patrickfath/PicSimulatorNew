package picSimuNew;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import picSimuNew.CreateItems;

public class Main {
	static Display display = new Display();
	static Shell shell = new Shell(display);
	static Menu menu;
	static MenuItem openFile;
	static Text textMain;
	static String path;
	static boolean flag;
	static Label label;
	static String getLine;
	static Composite leftDown;
	static Composite leftUp;
	static Composite rightSide;
	static String[] arrayWithLines;
	static ArrayList<String> arrayLinesReadIn = new ArrayList<>();


	public Main() {
		shell.setText("Pic-Simu");
		shell.setMaximized(true);
		shell.setLayout(new GridLayout(2,false));
		GridData grid = new GridData(SWT.FILL, SWT.FILL, true, true);
		grid.widthHint = 800;
		grid.heightHint = 800;
		shell.setLayoutData(grid);
	}


	public static void createMenu() {
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("datei");
		menuItem.setMenu(createItemsForMenu());
	}

	public static Menu createItemsForMenu() {
		Menu dateiMenu = new Menu(shell, SWT.DROP_DOWN);
		openFile = CreateItems.getMenuPoint(dateiMenu, "open");
		openFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				arrayLinesReadIn.clear();
				arrayLinesReadIn = OpenDocument.openDocument(leftDown, arrayLinesReadIn);
//				CreateCodeTable.arrayInsertAllInOne(arrayLinesReadIn);
				Worker.workWithArrayList(arrayLinesReadIn);
			}
		});
		return dateiMenu;
	}

	public static void createComposites() {
		//Composite for "leftSide"
		Composite leftSide = new Composite(shell, SWT.BORDER);
		leftSide.setLayout(new GridLayout(1,false));
		leftSide.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

		//Composite for the "rightSide"
		rightSide = new Composite(shell, SWT.BORDER);
		rightSide.setLayout(new GridLayout());
		rightSide.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		//GridData for Composite "leftUp"
		GridData grids = new GridData(SWT.LEFT, SWT.FILL, false, true);
		leftUp = new Composite(leftSide, SWT.BORDER);
		leftUp.setLayout(new GridLayout());
		leftUp.setLayoutData(grids);

		//GridData for Composite "leftDown"
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, true);
		data.widthHint = 800;
		data.heightHint = 400;
		leftDown = new Composite(leftSide, SWT.BORDER);
		leftDown.setLayout(new GridLayout());
		leftDown.setLayoutData(data);
	}
	
	public static void createStepBtn() {
		Button nextStepButton = new Button(rightSide, SWT.PUSH);
		nextStepButton.setLayoutData(new GridData());
		nextStepButton.setText("Step");
		nextStepButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.err.println("lollll");
				CreateCodeTable.nextStep();
			}
		});
	}


	public static void main (String [] args) {
		Main picSimulator = new Main();
		createMenu();
		createComposites();

		CreateRegister.createTheRegister(leftUp);
		CreateCodeTable.createTable(leftDown);
		createStepBtn();


		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
