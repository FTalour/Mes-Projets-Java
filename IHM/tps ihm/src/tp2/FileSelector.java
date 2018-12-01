package tp2;

import java.io.File;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * 
 */
@SuppressWarnings("serial")
public class FileSelector extends JDialog {

	private JComboBox<String> parentdirs;
	private JList<String> filelist;
	private JButton btn_ok;
	private JButton btn_cancel;

	private String directory = null;
	private String file = null;

	private ActionListener parentdirsListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int index = parentdirs.getSelectedIndex();
			if (index < 1)
				return;
			String path = "/";
			for (int i = parentdirs.getItemCount() - 2; i >= index; i--)
				path = path + parentdirs.getItemAt(i) + File.separator;
			show(path);
		}
	};

	private ActionListener btnListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (button == btn_cancel)
				dispose();
			else if (button == btn_ok) {
				file = (String) filelist.getSelectedValue();
				if (!show(getFilePath()))
					dispose();
			}
		}
	};

	private ListSelectionListener filelistListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting())
				return;
			btn_ok.setEnabled(filelist.getSelectedIndex() != -1);
		}
	};

	private MouseAdapter mouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2)
				btn_ok.doClick();
		}
	};

	public FileSelector(String title, String lbl_cancel, String lbl_ok) {
		super((JFrame) null, title, true /* modal */);

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		parentdirs = new JComboBox<String>();
		parentdirs.addActionListener(parentdirsListener);
		pane.add(parentdirs, BorderLayout.PAGE_START);

		filelist = new JList<String>();
		filelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		filelist.setVisibleRowCount(10);
		filelist.addListSelectionListener(filelistListener);
		filelist.addMouseListener(mouseListener);
		pane.add(new JScrollPane(filelist), BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
		buttons.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttons.add(Box.createHorizontalGlue());
		
		btn_cancel = new JButton(lbl_cancel);
		btn_cancel.addActionListener(btnListener);
		buttons.add(btn_cancel);
		
		btn_ok = new JButton(lbl_ok);
		btn_ok.addActionListener(btnListener);
		buttons.add(btn_ok);
		
		pane.add(buttons, BorderLayout.PAGE_END);

		show(System.getProperty("user.dir"));

		pack();
		setVisible(true);
	}

	Boolean show(String path) {
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory())
			return false;

		directory = dir.getAbsolutePath();
		file = null;
		btn_ok.setEnabled(false);
		parentdirs.removeAllItems();
		filelist.setListData(new Vector<String>());

		// Update the listbox showing the files in this directory
		String[] files = dir.list();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				File f = new File(path, files[i]);
				if (f.isDirectory())
					files[i] = files[i] + File.separator;
			}
			filelist.setListData(files);
		}

		// Update the combobox showing the list of parent directories
		parentdirs.insertItemAt(File.separator, 0);
		String[] dirs = path.split("[\\\\]");
		for (String p : dirs) {
			if (p.equals(""))
				continue;
			parentdirs.insertItemAt(p, 0);
		}
		parentdirs.setSelectedIndex(0);

		return true;
	}

	public String getFilePath() {
		if (directory == null || file == null)
			return null;
		return directory + File.separator + file;
	}

	static public void main(String args[]) {
		FileSelector fs = new FileSelector("File open...", "Cancel", "Open");
		System.out.println(fs.getFilePath());
		System.exit(1);
	}

}
