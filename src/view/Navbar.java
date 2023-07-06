package view;

import java.sql.SQLOutput;

import static config.ColorConsole.*;

public class Navbar {
	public static final void Menu() {
		System.out.println(BLUE + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━ BANK ━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                           ┃                             ┃                          ┃");
		System.out.println("┃        " + PURPLE + "1. ĐĂNG NHẬP       " + BLUE + "┃          " + PURPLE + "2. ĐĂNG KÝ         " + BLUE + "┃          " + PURPLE + "0. THOÁT        " + BLUE + "┃");
		System.out.println(BLUE + "┃                           ┃                             ┃                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void MenuAdmin() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ADMIN ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃          " + PURPLE + "1. QUẢN LÝ NHÂN VIÊN                   2. QUẢN LÝ NGƯỜI DÙNG              " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "3. QUẢN LÝ TIỀN NGÂN HÀNG              4. QUẢN LÝ LÃI XUẤT                " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "0. ĐĂNG XUẤT                                                              " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void Employee() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER EMPLOYEE ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃          " + PURPLE + "1. THÊM NHÂN VIÊN                        2. THAY ĐỔI NHÂN VIÊN            " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "3. SA THẢI NHÂN VIÊN                     4. TÌM KIẾM NHÂN VIÊN            " + BLUE + "┃");
		System.out.println("┃          " + PURPLE + "5. HIỂN THỊ TẤT CẢ NHÂN VIÊN             0. TRỞ LẠI                       " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void User() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER USER ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃           " + PURPLE + "1. HIỂN THỊ NGƯỜI DÙNG                   2. TÌM KIẾM NGƯỜI DÙNG          " + BLUE + "┃");
		System.out.println("┃           " + PURPLE + "3. THAY ĐỔI TRẠNG THÁI NGƯỜI DÙNG        0. TRỞ LẠI                      " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void Money() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER MONEY ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃            " + PURPLE + "1. THÊM TIỀN VỐN VÀO NGÂN HÀNG                                          " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "2. RÚT TIỀN VỐN RA KHỎI NGÂN HÀNG                                       " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "0. BACK                                                                 " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
	}
	
	public static final void Interest() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MANAGER INTEREST ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┃            " + PURPLE + "1. HIỂN THỊ LÃI XUẤT                   2. THÊM LÃI XUẤT MỚI             " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "3. THAY ĐỔI LÃI XUẤT                  4. XÓA LÃI XUẤT                   " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "0. TRỞ LẠI                                                              " + BLUE + "┃");
		System.out.println("┃                                                                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void MenuEmployee() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ MENU EMPLOYEE ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                                                     ┃");
		System.out.println("┃            " + PURPLE + "1. THAY ĐỔI TIỀN NGƯỜI DÙNG       2. HIỂN THỊ NGƯỜI DÙNG                 " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "3. HIỂN THỊ LÃI XUẤT              4. THÊM GÓI TIẾT KIẾM CHO NGƯỜI DÙNG   " + BLUE + "┃");
		System.out.println("┃            " + PURPLE + "0. ĐĂNG XUẤT                                                             " + BLUE + "┃");
		System.out.println("┃                                                                                     ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void MenuUser() {
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━ USER ━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                          ┃");
		System.out.println("┃                " + PURPLE + "1. XEM THÔNG TIN CÁ NHÂN                  " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "2. CHUYỂN TIỀN                            " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "3. GỬI TIỀN TIẾT KIỆM                     " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "4. THAY ĐỔI THÔNG TIN CÁ NHÂN             " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "5. THAY ĐỔI MẬT KHẨU                      " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "0. ĐĂNG XUẤT                              " + BLUE + "┃");
		System.out.println("┃                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void UserInterestRate() {
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━ USER ━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                          ┃");
		System.out.println("┃                " + PURPLE + "1. GỬI LÃI XUẤT KHÔNG KỲ HẠN              " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "2. XEM GÓI ĐÃ MUA                         " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "0. TRỞ LẠI                                " + BLUE + "┃");
		System.out.println("┃                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static final void ShowMyInterestRate() {
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━ USER ━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                          ┃");
		System.out.println("┃                " + PURPLE + "1. RÚT TIỀN MỘT PHẦN                      " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "2. RÚT TIỀN TOÀN BỘ                       " + BLUE + "┃");
		System.out.println("┃                " + PURPLE + "0. Quay Lại                               " + BLUE + "┃");
		System.out.println("┃                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
}
