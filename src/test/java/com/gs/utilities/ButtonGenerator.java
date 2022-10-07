package com.gs.utilities;

import com.gs.pages.AccommodationOverviewPage;
import com.gs.pages.AddAccommodationPage;
import com.gs.pages.AirGnsPage;

public class ButtonGenerator {
    AirGnsPage airGnsPage;
    AccommodationOverviewPage accommodationOverviewPage;
    AddAccommodationPage addAccommodationPage;

    /**
     *This method is used for generating click action
     * @param buttonName
     */
    public void clickButton(String buttonName) {
        setComponent();
        switch (buttonName) {
            case"AirGns":
               BrowserUtils.clickWithJse(airGnsPage.airGnsButton);
                break;
            case"removeButton":
               BrowserUtils.clickWithJse(accommodationOverviewPage.removeButton);
                break;
            case"accommodationButton":
                BrowserUtils.clickWithJse(addAccommodationPage.accommodationButton);
                break;
            case"submitButton":
                BrowserUtils.clickWithJse(addAccommodationPage.submitButton);
                break;
           case"addAccommodationButton":
                BrowserUtils.clickWithJse(airGnsPage.addAccommodationButton);
                break;
            case"priceFilterButton":
                BrowserUtils.clickWithJse(accommodationOverviewPage.priceFilterButton);
                break;
            case"sampleAccommodation":
                BrowserUtils.clickWithJse(accommodationOverviewPage.sampleAccommodation);
                break;
            case"englishButton":
                BrowserUtils.clickWithJse(airGnsPage.englishButton);
                break;
            case"germanButton":
                BrowserUtils.clickWithJse(airGnsPage.germanButton);
                break;
        }
    }
    public void setObject(){
        if(airGnsPage==null){
            airGnsPage=new AirGnsPage();
        }
        if(accommodationOverviewPage==null){
            accommodationOverviewPage=new AccommodationOverviewPage();
        }
        if(addAccommodationPage==null){
            addAccommodationPage=new AddAccommodationPage();
        }
    }

    public void resetObject(){
        airGnsPage=null;
        accommodationOverviewPage=null;
        addAccommodationPage=null;
    }
    public void setComponent(){
        resetObject();
        setObject();
    }
}