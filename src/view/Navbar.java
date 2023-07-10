package view;

import java.sql.SQLOutput;

import static config.ColorConsole.*;

public class Navbar {
	public static void Menu() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━ BANK ━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                           ┃                             ┃                          ┃                          ┃");
		System.out.println("┃        " + PURPLE + "1. ĐĂNG NHẬP       " + BLUE + "┃          " + PURPLE + "2. ĐĂNG KÝ         " + BLUE + "┃     " + PURPLE + "3. QUÊN MẬT KHẨU     " + BLUE + "┃        " + PURPLE + "0. THOÁT          " + BLUE + "┃");
		System.out.println("┃                           ┃                             ┃                          ┃                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void MenuAdmin() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ADMIN ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃          " + PURPLE + "1. QUẢN LÝ NHÂN VIÊN                   2. QUẢN LÝ NGƯỜI DÙNG              " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "3. QUẢN LÝ TIỀN NGÂN HÀNG              4. QUẢN LÝ LÃI XUẤT                " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "5. THỐNG KÊ GIAO DỊNH TRONG NGÀY       0. ĐĂNG XUẤT                       " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void Employee() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER EMPLOYEE ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃          " + PURPLE + "1. THÊM NHÂN VIÊN                        2. THAY ĐỔI NHÂN VIÊN            " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "3. SA THẢI NHÂN VIÊN                     4. TÌM KIẾM NHÂN VIÊN            " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "5. HIỂN THỊ TẤT CẢ NHÂN VIÊN             0. TRỞ LẠI                       " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void User() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER USER ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃           " + PURPLE + "1. HIỂN THỊ NGƯỜI DÙNG                   2. TÌM KIẾM NGƯỜI DÙNG          " + BLUE + "┃");
		System.out.println("┃           " + PURPLE + "3. THAY ĐỔI TRẠNG THÁI NGƯỜI DÙNG        4. CẤP LẠI MẬT KHẨU             " + BLUE + "┃");
		System.out.println("┃           " + PURPLE + "0. TRỞ LẠI                                                               " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void Money() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER MONEY ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃            " + PURPLE + "1. THÊM TIỀN VỐN VÀO NGÂN HÀNG                                          " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "2. RÚT TIỀN VỐN RA KHỎI NGÂN HÀNG                                       " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "0. BACK                                                                 " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
	}
	
	public static void Interest() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER INTEREST ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃            " + PURPLE + "1. HIỂN THỊ LÃI XUẤT                   2. THÊM LÃI XUẤT MỚI             " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "3. THAY ĐỔI LÃI XUẤT                   4. XÓA LÃI XUẤT                  " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "0. TRỞ LẠI                                                              " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void MenuEmployee() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MENU EMPLOYEE ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                     ┃");
		System.out.println("┃            " + PURPLE + "1. THAY ĐỔI TIỀN NGƯỜI DÙNG       2. HIỂN THỊ NGƯỜI DÙNG                 " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "3. HIỂN THỊ LÃI XUẤT              4. THÊM GÓI TIẾT KIẾM CHO NGƯỜI DÙNG   " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "0. ĐĂNG XUẤT                                                             " + BLUE + "┃");
		System.out.println("┃                                                                                     ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void MenuUser(int notification) {
		System.out.println(BLUE + "┣━━━━━━━━━━━━━━━━━━━━━━━━━━ USER ━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                          ┃");
		System.out.println("┃                " + PURPLE + "1. XEM THÔNG TIN CÁ NHÂN                  " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "2. CHUYỂN TIỀN                            " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "3. GỬI TIỀN TIẾT KIỆM                     " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "4. NẠP TIỀN VÀ RÚT TIỀN                   " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "5. XEM BIẾN ĐỘNG SỐ DƯ  " + RED + (String.valueOf(notification).length() == 1 ? (notification == 0 ? "     "+ "             " + BLUE + "┃" : "( " + notification + " )"+ "             " + BLUE + "┃") : (notification == 0 ? "     "+ "             " + BLUE + "┃" : "( " + notification + ")"+ "            " + BLUE + "┃")));
		System.out.println("┃                " + PURPLE + "6. THAY ĐỔI THÔNG TIN CÁ NHÂN             " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "7. THAY ĐỔI MẬT KHẨU                      " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "0. ĐĂNG XUẤT                              " + BLUE + "┃");
		System.out.println("┃                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void UserInterestRate() {
		System.out.println(BLUE + "┣━━━━━━━━━━━━━━━━━━━━━━━━━━ USER ━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                          ┃");
		System.out.println("┃                " + PURPLE + "1. GỬI LÃI XUẤT KHÔNG KỲ HẠN              " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "2. XEM GÓI ĐÃ MUA                         " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "0. TRỞ LẠI                                " + BLUE + "┃");
		System.out.println("┃                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void ShowMyInterestRate() {
		System.out.println(BLUE + "┣━━━━━━━━━━━━━━━━━━━━━━━━━━ USER ━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                          ┃");
		System.out.println("┃                " + PURPLE + "1. RÚT TIỀN MỘT PHẦN                      " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "2. RÚT TIỀN TOÀN BỘ                       " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "0. Quay Lại                               " + BLUE + "┃");
		System.out.println("┃                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void showDeposit() {
		System.out.println(BLUE + "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                             ┃                            ┃");
		System.out.println("┃       ( 1 ) 200.000         ┃     ( 2 ) 500.000          ┃");
		System.out.println("┃                             ┃                            ┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                             ┃                            ┃");
		System.out.println("┃       ( 3 ) 1.000.000       ┃     ( 4 ) 2.000.000        ┃");
		System.out.println("┃                             ┃                            ┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                     ( 0 ) Thoát                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}