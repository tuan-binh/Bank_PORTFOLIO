package view;

public class Navbar {
	public static final void Menu() {
		System.out.println("**************************************** BANK ****************************************");
		System.out.println("*                           *                             *                          *");
		System.out.println("*        1. SIGN IN         *          2. SIGN UP         *          3. EXIT         *");
		System.out.println("*                           *                             *                          *");
		System.out.println("**************************************************************************************");
	}
	
	public static final void MenuAdmin() {
		System.out.println("*************************************** ADMIN ****************************************");
		System.out.println("*          1. EMPLOYEE MANAGER             *              2. USER MANAGER            *");
		System.out.println("**************************************************************************************");
		System.out.println("*            3. MONEY MANAGER              *         4. INTEREST RATE MANAGER         *");
		System.out.println("**************************************************************************************");
		System.out.println("*                                      5. BACK                                      *");
		System.out.println("**************************************************************************************");
	}
	
	public static final void Employee() {
		System.out.println("********************************* MANAGER EMPLOYEE ***********************************");
		System.out.println("*          1. ADD EMPLOYEE                          2. EDIT EMPLOYEE                 *");
		System.out.println("*          3. LAYOFF EMPLOYEE                       4. SEARCH EMPLOYEE               *");
		System.out.println("*          5. SHOW EMPLOYEES                        6. BACK                          *");
		System.out.println("**************************************************************************************");
	}
	
	public static final void User() {
		System.out.println("*********************************** MANAGER USER *************************************");
		System.out.println("*             1. SHOW USERS                          2. SEARCH USERS                 *");
		System.out.println("*             3. CHANGE STATUS USER                  4. BACK                         *");
		System.out.println("**************************************************************************************");
	}
	
	public static final void Money() {
		System.out.println("********************************** MANAGER MONEY *************************************");
		System.out.println("*            1. ADD CAPITAL FUNDS                  2. MINUS CAPITAL FUNDS            *");
		System.out.println("*            3. BACK                                                                 *");
		System.out.println("**************************************************************************************");
		
	}
	
	public static final void Interest() {
		System.out.println("********************************* MANAGER INTEREST ***********************************");
		System.out.println("*            1. SHOW INTERESTS RATE                 2. ADD INTEREST RATE             *");
		System.out.println("*            3. EDIT INTEREST RATE                  4. DELETE INTEREST RATE          *");
		System.out.println("*            5. EXIT                                                                 *");
		System.out.println("**************************************************************************************");
	}
	
	public static final void MenuEmployee() {
		System.out.println("************************************ MENU EMPLOYEE ************************************");
		
	}
	
}
