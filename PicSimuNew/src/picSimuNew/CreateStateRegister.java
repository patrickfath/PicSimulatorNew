package picSimuNew;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class CreateStateRegister {
	static Label valueOfPclLabel ;
	static Label valueOfPcLabel ;
	static Composite rightSide;

	public static void createAllStates(Composite riComposite) {
		rightSide = riComposite;
		Label pclLabel = new Label(riComposite, SWT.NONE);
		pclLabel.setLayoutData(new GridData());
		pclLabel.setText("PCL");

		valueOfPclLabel = new Label(riComposite, SWT.NONE);
		valueOfPclLabel.setLayoutData(new GridData());
		valueOfPclLabel.setText("00"+"h");
		
		Label pcLabel = new Label(riComposite, SWT.NONE);
		pcLabel.setLayoutData(new GridData());
		pcLabel.setText("PC");

		valueOfPcLabel = new Label(riComposite, SWT.NONE);
		valueOfPcLabel.setLayoutData(new GridData());
		valueOfPcLabel.setText("0000");

	}

	public static void setPCL(String addresstoJumpTo) {

		valueOfPcLabel.setText(addresstoJumpTo);
		valueOfPclLabel.setText(addresstoJumpTo.substring(2, 4)+"h");
		rightSide.layout();
		CreateRegister.editValuePCL(addresstoJumpTo);

	}



}
