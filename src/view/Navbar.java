package view;

import java.sql.SQLOutput;

public class Navbar {
	public static final void Menu() {
		System.out.println("╔═══════════════════════════════════════ BANK ═══════════════════════════════════════╗");
		System.out.println("║                           ║                             ║                          ║");
		System.out.println("║        1. ĐĂNG NHẬP       ║          2. ĐĂNG KÝ         ║          0. THOÁT        ║");
		System.out.println("║                           ║                             ║                          ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public static final void MenuAdmin() {
		System.out.println("╔═══════════════════════════════════════ ADMIN ══════════════════════════════════════╗");
		System.out.println("║                                                                                    ║");
		System.out.println("║          1. QUẢN LÝ NHÂN VIÊN                   2. QUẢN LÝ NGƯỜI DÙNG              ║");
		System.out.println("║          3. QUẢN LÝ TIỀN NGÂN HÀNG              4. QUẢN LÝ LÃI XUẤT                ║");
		System.out.println("║          0. ĐĂNG XUẤT                                                              ║");
		System.out.println("║                                                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public static final void Employee() {
		System.out.println("╔═════════════════════════════════ MANAGER EMPLOYEE ═════════════════════════════════╗");
		System.out.println("║                                                                                    ║");
		System.out.println("║          1. THÊM NHÂN VIÊN                        2. THAY ĐỔI NHÂN VIÊN            ║");
		System.out.println("║          3. SA THẢI NHÂN VIÊN                     4. TÌM KIẾM NHÂN VIÊN            ║");
		System.out.println("║          5. HIỂN THỊ TẤT CẢ NHÂN VIÊN             0. TRỞ LẠI                       ║");
		System.out.println("║                                                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public static final void User() {
		System.out.println("╔═══════════════════════════════════ MANAGER USER ═══════════════════════════════════╗");
		System.out.println("║                                                                                    ║");
		System.out.println("║           1. HIỂN THỊ NGƯỜI DÙNG                   2. TÌM KIẾM NGƯỜI DÙNG          ║");
		System.out.println("║           3. THAY ĐỔI TRẠNG THÁI NGƯỜI DÙNG        0. TRỞ LẠI                      ║");
		System.out.println("║                                                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public static final void Money() {
		System.out.println("╔══════════════════════════════════ MANAGER MONEY ═══════════════════════════════════╗");
		System.out.println("║                                                                                    ║");
		System.out.println("║            1. THÊM TIỀN VỐN VÀO NGÂN HÀNG                                          ║");
		System.out.println("║            2. RÚT TIỀN VỐN RA KHỎI NGÂN HÀNG                                       ║");
		System.out.println("║            0. BACK                                                                 ║");
		System.out.println("║                                                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
		
	}
	
	public static final void Interest() {
		System.out.println("╔════════════════════════════════ MANAGER INTEREST ══════════════════════════════════╗");
		System.out.println("║                                                                                    ║");
		System.out.println("║            1. HIỂN THỊ LÃI XUẤT                   2. THÊM LÃI XUẤT MỚI             ║");
		System.out.println("║            3. THAY ĐỔI LÃI XUẤT                  4. XÓA LÃI XUẤT                   ║");
		System.out.println("║            0. TRỞ LẠI                                                              ║");
		System.out.println("║                                                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public static final void MenuEmployee() {
		System.out.println("╔═══════════════════════════════════ MENU EMPLOYEE ═══════════════════════════════════╗");
		System.out.println("║                                                                                     ║");
		System.out.println("║            1. THAY ĐỔI TIỀN NGƯỜI DÙNG       2. HIỂN THỊ NGƯỜI DÙNG                 ║");
		System.out.println("║            3. HIỂN THỊ LÃI XUẤT              4. THÊM GÓI TIẾT KIẾM CHO NGƯỜI DÙNG   ║");
		System.out.println("║            0. ĐĂNG XUẤT                                                             ║");
		System.out.println("║                                                                                     ║");
		System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public static final void MenuUser() {
		System.out.println("║══════════════════════════ USER ══════════════════════════╗");
		System.out.println("║                                                          ║");
		System.out.println("║                1. XEM THÔNG TIN CÁ NHÂN                  ║");
		System.out.println("║                2. CHUYỂN TIỀN                            ║");
		System.out.println("║                3. GỬI TIỀN TIẾT KIỆM                     ║");
		System.out.println("║                4. THAY ĐỔI THÔNG TIN CÁ NHÂN             ║");
		System.out.println("║                5. THAY ĐỔI MẬT KHẨU                      ║");
		System.out.println("║                0. ĐĂNG XUẤT                              ║");
		System.out.println("║                                                          ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
	
	public static final void UserInterestRate() {
		System.out.println("║══════════════════════════ USER ══════════════════════════╗");
		System.out.println("║                                                          ║");
		System.out.println("║                1. XEM GÓI LÃI XUẤT                       ║");
		System.out.println("║                2. XEM GÓI ĐÃ MUA                         ║");
		System.out.println("║                0. TRỞ LẠI                                ║");
		System.out.println("║                                                          ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
	
	public static final void ShowMyInterestRate() {
		System.out.println("║══════════════════════════ USER ══════════════════════════╗");
		System.out.println("║                                                          ║");
		System.out.println("║                1. RÚT TIỀN MỘT PHẦN                      ║");
		System.out.println("║                2. RÚT TIỀN TOÀN BỘ                       ║");
		System.out.println("║                0. Quay Lại                               ║");
		System.out.println("║                                                          ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
}
