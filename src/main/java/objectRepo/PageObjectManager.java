package objectRepo;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	
	
	LoginPage login;
	HomePage home;
	CourseListPage course;
	AddNewCoursePage addCourse;
	CategoryPage categoryList;
	AddNewCategoryPage addCategory;
	UsersPage users;
	AddNewUserPage addUser;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}


	public LoginPage getLoginPage() {
		login = new LoginPage(driver);
		return login;
	}


	public HomePage getHomePage() {
		home = new HomePage(driver);
		return home;
	}


	public CourseListPage getCourseListPage() {
		course = new CourseListPage(driver);
		return course;
	}


	public AddNewCoursePage getAddCoursePage() {
		addCourse = new AddNewCoursePage(driver);
		return addCourse;
	}


	public CategoryPage getCategoryPage() {
		categoryList = new CategoryPage(driver);
		return categoryList;
	}


	public AddNewCategoryPage getAddNewCategoryPage() {
		addCategory = new AddNewCategoryPage(driver);
		return addCategory;
	}


	public UsersPage getUsersPage() {
		users = new UsersPage(driver);
		return users;
	}


	public AddNewUserPage getAddNewUserPage() {
		addUser = new AddNewUserPage(driver);
		return addUser;
	}
	
	

}
