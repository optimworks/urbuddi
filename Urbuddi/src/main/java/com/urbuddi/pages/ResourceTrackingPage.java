package com.urbuddi.pages;

import com.urbuddi.base.BasePage;
import com.urbuddi.locaters.ResourceTrackingLocaters;

import net.serenitybdd.core.pages.PageObject;

public class ResourceTrackingPage extends BasePage {
	String ResourceTracking_Menu = "xpath=//p[text()=\"Resource Tracking\"]";
	String ResourceTracking_Header = "xpath=//header[text()=\"Resource Tracking\"]";
	String ResourceTracking_Add_Resource = "xpath=//*[text()=\"Add Resource\"]";
	String ResourceTracking_Add_Resource_Popup = "xpath=//h4[text()=\"Add Resource\"]";
	String ResourceTracking_Employee_Id = "css=[name=\"employeeId\"]";
	String ResourceTracking_Allocated_Date = "css=[name=\"allocatedDate\"]";
	String ResourceTracking_Device_Type = "css=[name=\"deviceType\"]";
	String ResourceTracking_Device_Type_Option = "xpath=//*[@name=\"deviceType\"]//option[text()=\"Laptop\"]";
	String ResourceTracking_SerialId = "css=[name=\"serialId\"]";
	String ResourceTracking_Model = "css=[name=\"model\"]";
	String ResourceTracking_Total_Assigned = "css=[name=\"totalAssigned\"]";
	String ResourceTracking_Submit_Button = "xpath=//*[text()=\"Submit\"]";
	ResourceTrackingLocaters ResourceTracking;

	public void resourceTrackingMenuOption() {
		click(ResourceTracking_Menu);
	}

	public void verifyResourceTrackingHeader() {
		elementPresence(ResourceTracking_Header);
	}

	public void addResource(String employeeid, String allocateddate, String serialid, String model) {
		click(ResourceTracking_Add_Resource);
		elementPresence(ResourceTracking_Add_Resource_Popup);
		type(ResourceTracking_Employee_Id, employeeid);
		click(ResourceTracking_Allocated_Date);
		type(ResourceTracking_Allocated_Date, allocateddate);
		click(ResourceTracking_Device_Type);
		click(ResourceTracking_Device_Type_Option);
		type(ResourceTracking_SerialId, serialid);
		type(ResourceTracking_Model, model);
		type(ResourceTracking_Total_Assigned, "1");
		click(ResourceTracking_Submit_Button);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
