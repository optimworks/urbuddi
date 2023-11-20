package com.urbuddi.pages;

import com.urbuddi.base.BasePage;
import com.urbuddi.locaters.reimbursementLocaters;

public class reimbursementPage extends BasePage {

	reimbursementLocaters Reimbursement;
	

	public void Reimbursement_Menu() {

		click(Reimbursement.Reimbursement_Menu);
	}

	public void Reimbursement_Page_Is_Displayed() {

		elementPresence(Reimbursement.Reimbursement_Header);
	}

	public void Reimbursement_Apply_ExtraWork(String Date, String Hour) {
		click(Reimbursement.Reimbursement_Applyextrawork);
		type(Reimbursement.Applyextrawork_Date, Date);
		type(Reimbursement.Applyextrawork_Hour, Hour);
		click(Reimbursement.Applyextrawork_Lead);
		click(Reimbursement.Applyextrawork_Lead_Option);
		click(Reimbursement.Applyextrawork_Submit);

	}

	public void Reimbursement_Requests() {
		elementPresence(Reimbursement.Reimbursement_Requests);
		click(Reimbursement.Reimbursement_Requests);
		

	}

	public void Reimbursement_History() {
		
		elementPresence(Reimbursement.Reimbursement_History);
		click(Reimbursement.Reimbursement_History);

	}

}
