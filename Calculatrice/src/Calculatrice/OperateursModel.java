package Calculatrice;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class OperateursModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> operateurs;
	
	public OperateursModel() {
		// TODO Auto-generated constructor stub
		super();
		
		operateurs = new ArrayList<String>();
		
		operateurs.add("+");
		operateurs.add("-");
		operateurs.add("*");
		operateurs.add("/");
	}
	
	public String getSelectedOperateur(){
		return (String)getSelectedItem();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return operateurs.get(index);
	}

	@Override
	public int getIndexOf(Object anObject) {
		// TODO Auto-generated method stub
		return operateurs.indexOf(anObject);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return operateurs.size();
	}
	
	
}
