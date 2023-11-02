package com.urbuddi.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.urbuddi.steps.UrbuddiSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class FileUpload {
	@Steps
    private UrbuddiSteps fileUploadSteps;

    @Test
    public void uploadFileTest() {
        String filePath = "C:\\Users\\admin\\Downloads\\filexcel.xlsx"; // Replace with the actual file path
      //  fileUploadSteps.uploadFile(filePath);
    }
    
   

}
