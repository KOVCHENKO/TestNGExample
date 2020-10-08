package com.ilkow.willey.pageobjects;

import com.ilkow.willey.Config;
import com.ilkow.willey.utils.PageUtility;
import com.ilkow.willey.utils.TestUtility;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class EducationPage extends PageUtility {

    public MainMenuPage mainMenuPage;

    public EducationPage() {
        this.mainMenuPage = new MainMenuPage();
    }

    public By infAndLibraryScience = By.xpath("//a[@href='/en-us/Education/Information+%26+Library+Science-c-ED30']");
    public By eduAndPublicPolicy = By.xpath("//a[@href='/en-us/Education/Education+%26+Public+Policy-c-ED05']");
    public By k12General = By.xpath("//a[@href='/en-us/Education/K+12+General-c-ED10']");
    public By higherEduGeneral = By.xpath("//a[@href='/en-us/Education/Higher+Education+General-c-ED20']");
    public By vocationalTechnology = By.xpath("//a[@href='/en-us/Education/Vocational+Technology-c-ED40']");
    public By conflictResolution = By.xpath("//a[@href='/en-us/Education/Conflict+Resolution+%26+Mediation+%28School+settings%29-c-ED50']");
    public By curriculumToolsGeneral = By.xpath("//a[@href='/en-us/Education/Curriculum+Tools+General-c-ED60']");
    public By specialEducationalNeeds = By.xpath("//a[@href='/en-us/Education/Special+Educational+Needs-c-ED70']");
    public By theoryOfEducation = By.xpath("//a[@href='/en-us/Education/Theory+of+Education-c-ED03']");
    public By educationSpecialTopics = By.xpath("//a[@href='/en-us/Education/Education+Special+Topics-c-EDZ0']");
    public By educationalResearchStatistics = By.xpath("//a[@href='/en-us/Education/Educational+Research+%26+Statistics-c-ED04']");
    public By literacyReading = By.xpath("//a[@href='/en-us/Education/Literacy+%26+Reading-c-ED80']");
    public By classroomManagement = By.xpath("//a[@href='/en-us/Education/Classroom+Management-c-ED06']");

    public ArrayList<By> getAllSideMenuElements() {
        return new ArrayList<>(){
            {
                add(infAndLibraryScience);
                add(eduAndPublicPolicy);
                add(k12General);
                add(higherEduGeneral);
                add(vocationalTechnology);
                add(conflictResolution);
                add(curriculumToolsGeneral);
                add(specialEducationalNeeds);
                add(theoryOfEducation);
                add(educationSpecialTopics);
                add(educationalResearchStatistics);
                add(literacyReading);
                add(classroomManagement);
            }
        };
    }

    public MainMenuPage getMainMenu() {
        return mainMenuPage;
    }

    public void navigateTo() {
        TestUtility.driver.get(Config.baseUrl);
    }

}
