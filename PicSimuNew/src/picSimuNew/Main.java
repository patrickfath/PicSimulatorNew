package picSimuNew;

import java.util.ArrayList;
import java.util.Stack;

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
	static int counterInexOfArray = 0;
	static boolean flag;
	static Label label;
	static String getLine;
	static Composite leftDown;
	static Composite leftUp;
	static Composite rightSide;
	static Composite leftUpRight;
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
//				Worker.workWithArrayList(arrayLinesReadIn);
				//TODO	one method call only
				Worker.subSTheArrayList(arrayLinesReadIn);
			}
		});
		return dateiMenu;
	}

	public static void createComposites() {
		//Composite for "leftSide"
		Composite leftSide = new Composite(shell, SWT.BORDER);
		leftSide.setLayout(new GridLayout(2,false));
		leftSide.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

		//Composite for the "rightSide"
		rightSide = new Composite(shell, SWT.BORDER);
		rightSide.setLayout(new GridLayout(2,true));
		rightSide.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		//GridData for Composite "leftUp"
		GridData grids = new GridData(SWT.LEFT, SWT.FILL, false, true,1,1);
		leftUp = new Composite(leftSide, SWT.BORDER);
		leftUp.setLayout(new GridLayout());
		leftUp.setLayoutData(grids);
		
		GridData gridFBtns = new GridData(SWT.FILL, SWT.FILL, false, true,1,1);
		leftUpRight = new Composite(leftSide, SWT.BORDER);
		leftUpRight.setLayout(new GridLayout());
		leftUpRight.setLayoutData(gridFBtns);

		//GridData for Composite "leftDown"
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, true,2,1);
		data.widthHint = 800;
		data.heightHint = 400;
		leftDown = new Composite(leftSide, SWT.BORDER);
		leftDown.setLayout(new GridLayout());
		leftDown.setLayoutData(data);
	}
	
	public static void createStepBtn() {
		Button nextStepButton = new Button(leftUpRight, SWT.PUSH);
		nextStepButton.setLayoutData(new GridData());
		nextStepButton.setText("Step");
		nextStepButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
//				System.err.println("lollll");
//				CreateCodeTable.nextStep();
				Worker.stepByStepClick(arrayLinesReadIn);
				counterInexOfArray++;
				
				System.err.println(counterInexOfArray);
			}
		});
	}
	
	public static void createRunBtn() {
		Button runBtn = new Button(leftUpRight, SWT.PUSH);
		runBtn.setLayoutData(new GridData());
		runBtn.setText("RUN");
		runBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
//				Worker.runStepThrough(arrayLinesReadIn);
				
			}
		});
	}


	public static void main (String [] args) {
		Main picSimulator = new Main();
		
		createMenu();
		createComposites();

		CreateStateRegister.createAllStates(rightSide);
		CreateRegister.createTheRegister(leftUp);
		CreateCodeTable.createTable(leftDown);
		
		
		createStepBtn();
		createRunBtn();
		


		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
