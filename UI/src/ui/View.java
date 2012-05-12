package ui;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class View extends ViewPart {
	public View() {
	}

	public static final String ID = "UI.view";
	//public static final String ID = "com.ksh.hello.rcpswt"; //$NON-NLS-1$
	private Text txtApp;
	private Text txtActivity;
	private Text txtContentproviderClass;
	private Text txtAuthority;
	private Text text;

	private TableViewer viewer;
	private Text PackagePathText;

	/**
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent instanceof Object[]) {
				return (Object[]) parent;
			}
			return new Object[0];
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		final Combo class_combo = new Combo(container, SWT.NONE);
		class_combo.setBounds(81, 60, 309, 23);

		final Combo xml_combo = new Combo(container, SWT.NONE);
		xml_combo.setBounds(81, 120, 309, 23);
		
		final Combo cp_combo = new Combo(container, SWT.NONE);
		cp_combo.setBounds(81, 90, 309, 23);
		{
			TabFolder tabFolder = new TabFolder(container, SWT.NONE);
			tabFolder.setBounds(415, 99, 273, 407);
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
			lblNewLabel.setBounds(7, 3, 110, 23);
			lblNewLabel.setText(" Target Application:");
		}
		{
			Label lblNewLabel_1 = new Label(container, SWT.NONE);
			lblNewLabel_1.setFont(SWTResourceManager.getFont("¸¼Àº °íµñ", 12, SWT.NORMAL));
			lblNewLabel_1.setBounds(5, 29, 70, 18);
			lblNewLabel_1.setText("Path:");
		}
		{
			Label lblNewLabel_2 = new Label(container, SWT.NONE);
			lblNewLabel_2.setFont(SWTResourceManager.getFont("¸¼Àº °íµñ", 12, SWT.NORMAL));
			lblNewLabel_2.setBounds(5, 63, 70, 20);
			lblNewLabel_2.setText("Class:");
		}
		{
			Label lblNewLabel_3 = new Label(container, SWT.NONE);
			lblNewLabel_3.setFont(SWTResourceManager.getFont("¸¼Àº °íµñ", 12, SWT.NORMAL));
			lblNewLabel_3.setBounds(5, 123, 70, 23);
			lblNewLabel_3.setText("XML:");
		}

		Label label = new Label(container, SWT.SEPARATOR | SWT.VERTICAL);
		// label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(396, 3, 2, 503);

		Label label_1 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 148, 390, 3);

		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(396, 90, 292, 3);

		final Label PackageNameLabel = new Label(container, SWT.NONE);
		PackageNameLabel.setAlignment(SWT.CENTER);
		// PackageNameLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		PackageNameLabel.setBounds(123, 3, 157, 23);
		PackageNameLabel.setText("(Will Insert APP Name)");

		{
			Button button_LoadView = new Button(container, SWT.NONE);
			
			
			button_LoadView.setBounds(415, 8, 110, 75);
			button_LoadView.setText("Click for View!");
		}

		{
			Button button_Generate = new Button(container, SWT.NONE);
			button_Generate.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					PackageNameLabel.setText("");
					PackagePathText.setText("");
					class_combo.removeAll();
					xml_combo.removeAll();
					cp_combo.removeAll();
				}
			});
			button_Generate.setBounds(531, 8, 157, 75);
			button_Generate.setText("Generate");
		}

		PackagePathText = new Text(container, SWT.BORDER);
		PackagePathText.setText("Will Insert Package Path(Here!)");
		PackagePathText.setBounds(81, 30, 309, 20);

		viewer = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("¸¼Àº °íµñ", 12, SWT.NORMAL));
		lblNewLabel_4.setBounds(4, 93, 71, 20);
		lblNewLabel_4.setText("CP:");
		
		Button button_LoadFile = new Button(container, SWT.NONE);
		button_LoadFile.setText("Browse");
		button_LoadFile.setBounds(283, 1, 107, 25);
		button_LoadFile.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				String PackageName = "";
				String PackagePath = "";
				String ProjectName = "";
				String ProjectPath = "";
				// String AddSrc="\\src\\";
				// String[] JavaClass=javafiles.list();
				// File LoadedDirectory=new File(PackagePath+AddSrc);
				
				if(PackageName!="" || PackagePath!="") { 
					
				}
				
				JFileChooser FileLoadPanel = new JFileChooser();
				FileLoadPanel.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = FileLoadPanel.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					ProjectName = FileLoadPanel.getSelectedFile().getName();
					PackageNameLabel.setText(ProjectName);
					ProjectPath = FileLoadPanel.getSelectedFile().getPath();
					PackagePathText.setText(ProjectPath);
					//PackagePath=ProjectPath+"\\src\\";
				}

				File selected_directory = new File(ProjectPath);
				ArrayList<File> files = new ArrayList<File>();
				visitAllFiles(files, selected_directory);

				for (File f : files) {
					String javaFile = f.getName();
					if (javaFile.endsWith(".java")) {
						class_combo.add(javaFile);
						cp_combo.add(javaFile);
					}
				}
				class_combo.setText("Successful creation of Class list");
				cp_combo.setText("Successful creation of ContentProvider list");

				for (File f : files) {
					String xmlFile = f.getName();
					if (xmlFile.endsWith(".xml")) {
						xml_combo.add(xmlFile);
					}
				}
				xml_combo.setText("Successful creation of XML list");
			}
			private void visitAllFiles(ArrayList<File> files, File directory) {
				// TODO Auto-generated method stub
				if (directory.isDirectory()) {
					File[] children = directory.listFiles();
					for (File f : children) {
						visitAllFiles(files, f);
					}
				} else {
					files.add(directory);
				}
			}

		});
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setBounds(7, 152, 383, 354);
		
		
		createActions();
		initializeToolBar();
		initializeMenu();

	}

	private void createActions() {
		// Create the actions
	}

	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}