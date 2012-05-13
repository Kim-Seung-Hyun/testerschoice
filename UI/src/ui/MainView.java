package ui;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class MainView extends ViewPart {

	public static final String ID = "ui.gg"; //$NON-NLS-1$
	private Text text_4;
	private Text txtParsingviewContents;

	public MainView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		{
			Button btnNewButton = new Button(container, SWT.NONE);
			btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
				}
			});
			btnNewButton.setFont(SWTResourceManager.getFont("@HY견고딕", 10, SWT.NORMAL));
			btnNewButton.setBounds(311, 10, 110, 75);
			btnNewButton.setText("Click for Load!");
		}
		{
			Combo combo = new Combo(container, SWT.NONE);
			combo.setBounds(145, 10, 123, 23);
		}
		{
			Combo combo = new Combo(container, SWT.NONE);
			combo.setBounds(145, 49, 123, 23);
		}
		{
			Combo combo = new Combo(container, SWT.NONE);
			combo.setBounds(145, 86, 123, 23);
		}
		{
			text_4 = new Text(container, SWT.BORDER);
			text_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			text_4.setBounds(145, 121, 123, 23);
		}
		{
			Button btnNewButton_1 = new Button(container, SWT.NONE);
			btnNewButton_1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				}
			});
			btnNewButton_1.setFont(SWTResourceManager.getFont("HY견고딕", 9, SWT.NORMAL));
			btnNewButton_1.setBounds(427, 10, 157, 75);
			btnNewButton_1.setText("Complete Working set");
		}
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setBounds(10, 154, 288, 304);
		{
			txtParsingviewContents = new Text(composite, SWT.BORDER);
			txtParsingviewContents.setFont(SWTResourceManager.getFont("맑은 고딕", 16, SWT.NORMAL));
			txtParsingviewContents.setText("(parsing-view contents)");
			txtParsingviewContents.setBounds(36, 77, 230, 57);
		}
		{
			TabFolder tabFolder = new TabFolder(container, SWT.NONE);
			tabFolder.setFont(SWTResourceManager.getFont("@HY그래픽M", 9, SWT.BOLD | SWT.ITALIC));
			tabFolder.setBounds(311, 99, 273, 359);
			{
				TabItem tbtmAdd = new TabItem(tabFolder, SWT.NONE);
				tbtmAdd.setText("add");
			}
			{
				TabItem tbtmQuery = new TabItem(tabFolder, SWT.NONE);
				tbtmQuery.setText("query");
			}
			{
				TabItem tbtmDelete = new TabItem(tabFolder, SWT.NONE);
				tbtmDelete.setText("delete");
				{
					TabFolder tabFolder_1 = new TabFolder(tabFolder, SWT.NONE);
					tbtmDelete.setControl(tabFolder_1);
				}
			}
		}
		{
			Label lblNewLabel = new Label(container, SWT.NONE);
			lblNewLabel.setAlignment(SWT.RIGHT);
			lblNewLabel.setFont(SWTResourceManager.getFont("@양재백두체B", 9, SWT.NORMAL));
			lblNewLabel.setBounds(4, 15, 135, 23);
			lblNewLabel.setText(" Target Application:");
		}
		{
			Label lblNewLabel_1 = new Label(container, SWT.NONE);
			lblNewLabel_1.setAlignment(SWT.RIGHT);
			lblNewLabel_1.setFont(SWTResourceManager.getFont("@양재백두체B", 9, SWT.NORMAL));
			lblNewLabel_1.setBounds(74, 54, 65, 23);
			lblNewLabel_1.setText("Activity:");
		}
		{
			Label lblNewLabel_2 = new Label(container, SWT.NONE);
			lblNewLabel_2.setAlignment(SWT.RIGHT);
			lblNewLabel_2.setFont(SWTResourceManager.getFont("@양재백두체B", 9, SWT.NORMAL));
			lblNewLabel_2.setBounds(10, 91, 129, 15);
			lblNewLabel_2.setText("  content Provider:");
		}
		{
			Label lblNewLabel_3 = new Label(container, SWT.NONE);
			lblNewLabel_3.setAlignment(SWT.RIGHT);
			lblNewLabel_3.setFont(SWTResourceManager.getFont("@양재백두체B", 9, SWT.NORMAL));
			lblNewLabel_3.setBounds(53, 126, 86, 15);
			lblNewLabel_3.setText("Authority:");
		}
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(303, 0, 2, 468);
		
		Label label_1 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 147, 305, 2);
		
		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(303, 91, 291, 2);

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
