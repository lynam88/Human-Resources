//Nạp các Package chứa class cần dùng vào chương trình Java.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class HumanResources chứa luồng chính của chương trình
 */
public class HumanResources {

    static Scanner scanner = new Scanner(System.in);// Tạo đối tượng Scanner lấy đầu vào từ bàn phím.

    static ArrayList<Department> departmentList = new ArrayList<>();//Tạo ArrayList departmentList để quản lý danh sách các bộ phận.

    static ArrayList<String> positionList = new ArrayList<>();//Tạo ArrayList positionList để quản lý toàn bộ chức danh trong công ty

    static ArrayList<Staff> staffList = new ArrayList<>();//Tạo ArrayList staffList để quản lý toàn bộ nhân viên trong công ty bao gồm cả nhân viên và quản lý.

    /**
     * Khai báo hàm main để Java thực thi.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Thêm phần tử với các thuộc tính của bộ phận vào ArrayList để hiển thị
        departmentList.add(new Department("HC", "Hành Chính Nhân Sự", 2));
        departmentList.add(new Department("IT", "Công Nghệ Thông Tin", 2));
        departmentList.add(new Department("MKT", "Marketing", 0));

        //Thêm phần tử với các thuộc tính chức danh quản lý vào ArrayList để hiển thị
        positionList.add("Business Leader");
        positionList.add("Technical Leader");
        positionList.add("Project Leader");

        //Thêm phần tử nhân viên và quản lý vào ArrayList để hiển thị
        staffList.add(new Employee("E001", "Phong Tuyết Hoa", 28, 3.2f, "10/10/2010", 10, "Hành Chính Nhân Sự", 4));
        staffList.add(new Employee("E002", "Trần Thị B", 24, 2.2f, "09/10/2010", 7, "Hành Chính Nhân Sự", 3));
        staffList.add(new Manager("M001", "Nguyễn Văn An", 25, 2.5f, "11/11/2010", 5, "Công Nghệ Thông Tin", "Business Leader"));
        staffList.add(new Manager("M002", "Tạ Văn Lục", 32, 4.5f, "01/11/2010", 1, "Công Nghệ Thông Tin", "Technical Leader"));
        staffList.add(new Manager("M003", "Trần Lý Nam", 34, 4.0f, "28/02/2018", 0, "Công Nghệ Thông Tin", "Project Leader"));

        int choice;//Biến choice lưu lựa chọn của người dùng khi được hỏi lúc mới vào chương trình.

        //Dùng vòng lặp để nhận giá trị lựa chọn từ người dùng ứng với các tính năng trên menu.
        do {
            //Hiển thị menu chương trình cho người dùng chọn.
            menu();
            choice = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến

            //Mệnh đề switch case dùng để thực thi chương trình tương ứng với lựa chọn của người dùng (đã được lưu vào biến choice)
            switch (choice) {

                case 1://Hiển thị danh sách nhân viên hiện có trong công ty.
                    chucNang1();
                    break;

                case 2://Hiển thị các bộ phận trong công ty.
                    chucNang2();
                    break;

                case 3://Hiển thị các nhân viên theo từng bộ phận.
                    chucNang3();
                    break;

                case 4://Thêm nhân viên mới vào công ty.
                    chucNang4();
                    break;

                case 5://Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.
                    chucNang5();
                    break;

                case 6://Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần.
                    chucNang6();
                    break;

                case 7://Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.
                    chucNang7();
                    break;

                default://Nếu người dùng chọn số nằm ngoài các case trên menu, thì khối lệnh ở trong đây sẽ được thực thi.
                    break;//Dừng thực thi mệnh đề switch tại đây.

            }

        } while (choice != 0);//Điều kiện để tiếp tục chạy chương trình
    }

    /**
     * Hiển thị menu chương trình cho người dùng chọn.
     */
    public static void menu() {

        System.out.println("1.Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2.Hiển thị các bộ phận trong công ty.");
        System.out.println("3.Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4.Thêm nhân viên mới vào công ty.");
        System.out.println("5.Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6.Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7.Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("0.Thoát chương trình.");
        System.out.println("Lựa chọn của bạn:");
    }

    /**
     * Hiển thị danh sách nhân viên hiện có trong công ty.
     */
    public static void chucNang1() {

        System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10s\n", "Mã nhân viên", "|", "Tên nhân viên", "|", "Tuổi", "|", "HS Lương", "|", "Ngày vào làm", "|", "Ngày nghỉ phép", "|", "Bộ phận", "|", "Số giờ làm thêm/Chức vụ", "|", "Lương");//Hiển thị tiêu đề trong danh sách.
        System.out.printf("%s\n", "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");//Phân cách tiêu đề và nội dung.

        //Duyệt qua staffList để hiển thị thông tin tất cả nhân viên.
        for (Staff staff : staffList) {
            staff.displayInformation();//Gọi hàm displayInformation() trên mỗi phần tử staffList hiển thị thông tin từng nhân viên.
        }

    }

    /**
     * Hiển thị các bộ phận trong công ty.
     */
    public static void chucNang2() {

        System.out.printf("%-15s %s %-20s %s %-10s\n", "Mã bộ phận", "|", "Tên bộ phận", "|", "Số lượng nhân viên hiện tại");//Hiển thị tiêu đề trong danh sách.

        //Duyệt qua departmentList để hiển thị thông tin tất cả các bộ phận.
        for (Department department : departmentList) {
            System.out.print(department.toString());//Gọi phương thức toString() trên mỗi phần tử ArrayList để hiển thị thông tin từng bộ phận.
        }

    }

    /**
     * Hiển thị các nhân viên theo từng bộ phận.
     */
    public static void chucNang3() {

        //Dùng 2 vòng lặp for để hiển thị các nhân viên theo từng bộ phận.
        for (Department department : departmentList) {//Duyệt qua departmentList để hiển thị tên tất cả các bộ phận.
            System.out.println(department.getDepartmentName() + ":");//Hiển thị tên bộ phận
            System.out.println("---------------------------------");
            System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10s\n", "Mã nhân viên", "|", "Tên nhân viên", "|", "Tuổi", "|", "HS Lương", "|", "Ngày vào làm", "|", "Ngày nghỉ phép", "|", "Bộ phận", "|", "Số giờ làm thêm/Chức vụ", "|", "Lương");//Hiển thị tiêu đề trong danh sách.
            for (Staff staff : staffList) {//Duyệt qua staffList để hiển thị thông tin tất cả nhân viên.
                if (staff.getDepartmentName().equals(department.getDepartmentName()))//Tên bộ phận trong staffList trùng với tên bộ phận trong departmentList
                    staff.displayInformation();//Gọi hàm displayInformation() trên mỗi phần tử staffList hiển thị thông tin từng nhân viên.
            }

        }
    }

    /**
     * Thêm nhân viên mới vào công ty.
     */
    public static void chucNang4() {

        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");

        int staffChosen;//Biến lưu lựa chọn nhân viên thông thường hay cấp quản lý (1 hoặc 2)

        //Vòng lặp do while để yêu cầu người dùng chỉ chọn 1 hoặc 2.
        do {
            System.out.println("Bạn chọn(1 hoặc 2): ");
            staffChosen = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến
            scanner.nextLine();//Xoá bộ đệm bàn phím để xoá ký tự xuống dòng \n
        } while (staffChosen != 1 && staffChosen != 2);//Tiếp tục chạy vòng lặp khi người dùng chọn số khác 1 và 2

        System.out.println("Nhập mã nhân viên: ");
        String newId = scanner.nextLine();//Lưu giá trị người dùng nhập vào biến mã nhân viên

        System.out.println("Nhập tên nhân viên: ");
        String newName = scanner.nextLine();//Lưu giá trị người dùng nhập vào biến tên nhân viên

        System.out.println("Nhập tuổi nhân viên: ");
        int newAge = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến tuổi nhân viên

        System.out.println("Nhập hệ số lương của nhân viên: ");
        float newCoefficient = scanner.nextFloat();//Lưu giá trị người dùng nhập vào biến lương nhân viên
        scanner.nextLine();//Xoá bộ đệm bàn phím để xoá ký tự xuống dòng \n

        System.out.println("Nhập ngày vào làm của nhân viên: ");
        String newDate = scanner.nextLine();//Lưu giá trị người dùng nhập vào biến ngày vào làm của nhân viên

        System.out.println("Nhập số ngày nghỉ phép của nhân viên: ");
        int newDaysOff = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến ngày nghỉ phép của nhân viên

        //Vòng lặp for hiển thị danh sách các bộ phận như đề bài
        for (int i = 0; i < departmentList.size(); i++)
            System.out.println(i + 1 + ". " + departmentList.get(i).getDepartmentId() + " - " + departmentList.get(i).getDepartmentName());

        int departmentChosen;//Biến lưu lựa chọn của người dùng với bộ phận làm việc của nhân viên.
        String newDepartment = "";//Biến lưu bộ phận của nhân viên.
        int positionChosen = 0;//Biến lưu lựa chọn của người dùng với chức danh của nhân viên cấp quản lý
        String newPosition = "";//Biến lưu chức danh của nhân viên cấp quản lý

        //Vòng lặp do while để yêu cầu người dùng chọn bộ phận trong khoảng số lượng các bộ phận của công ty.
        do {

            System.out.println("Bạn chọn bộ phận: ");
            departmentChosen = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến

        } while (departmentChosen <= 0 || departmentChosen > departmentList.size());//Điều kiện yêu cầu người dùng nhập lại khi họ nhập ngoài khoảng cho phép.

        //Vòng lặp for duyệt qua departmentList để so sánh lựa chọn của người dùng với các bộ phận làm việc
        for (int i = 0; i < departmentList.size(); i++) {

            if (departmentChosen == i + 1) {//Lựa chọn trùng với bộ phận làm việc
                newDepartment = departmentList.get(i).getDepartmentName();//lưu giá trị cho biến bộ phận của nhân viên.
                int deparmentnewNumber = departmentList.get(i).getDepartmentNumber();

                if (staffChosen == 1) {//Chọn nhân viên thông thường
                    System.out.println("Nhập số giờ làm thêm: ");
                    int newOverTime = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến giờ làm thêm của nhân viên
                    Employee newEmployee = new Employee(newId, newName, newAge, newCoefficient, newDate, newDaysOff, newDepartment, newOverTime);//tạo đối tượng nhân viên thông thường mới.
                    staffList.add(newEmployee);//Thêm đối tượng nhân viên thông thường vào staffList

                }

                if (staffChosen == 2) {//Chọn nhân viên cấp quản lý

                    System.out.println("Chức danh: ");
                    //Vòng lặp hiển thị danh sách các chức danh như đề bài
                    for (int j = 0; j < positionList.size(); j++) {
                        System.out.println(j + 1 + ". " + positionList.get(j));
                    }

                    do {
                        System.out.println("Nhập chức danh: ");
                        positionChosen = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến
                        for (int j = 0; j < positionList.size(); j++) {
                            if (positionChosen == j + 1) {
                                newPosition = positionList.get(j);
                                break;
                            }
                        }
                    } while (positionChosen <= 0 || positionChosen > positionList.size());//Điều kiện để người dùng nhập lại vì nhập ngoài khoảng cho phép.

                    Manager newManager = new Manager(newId, newName, newAge, newCoefficient, newDate, newDaysOff, newDepartment, newPosition);//tạo đối tượng nhân viên cấp quản lý mới.
                    staffList.add(newManager);//Thêm đối tượng nhân viên cấp quản lý vào staffList.

                }

                deparmentnewNumber++;
                departmentList.get(i).setDepartmentNumber(deparmentnewNumber);

            }
        }
    }

    /**
     * Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.
     */
    public static void chucNang5() {

        System.out.println("1. Tìm nhân viên bằng tên: ");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên: ");
        int searchChosen;//Biến lưu giá trị lựa chọn tìm kiếm của người dùng.
        String searchName;//Biến lưu tên nhân viên mà người dùng nhập vào để tìm kiếm.
        String searchId;//Biến lưu mã nhân viên mà người dùng nhập vào để tìm kiếm.

        //Vòng lặp do while kiểm tra người dùng có nhập đúng 1 hoặc 2 không.
        do {

            System.out.println("Bạn chọn(1 hoặc 2): ");
            searchChosen = scanner.nextInt();//Lưu giá trị người dùng nhập vào biến
            scanner.nextLine();//Xoá bộ đệm bàn phím để xoá ký tự xuống dòng \n
            boolean searchCheck = false;//Biến kiểm tra xem có nhân viên đúng như người dùng tìm kiếm hay không.

            if (searchChosen == 1) {//Tìm kiếm nhân viên bằng tên
                System.out.println("Nhập tên nhân viên cần tìm: ");
                searchName = scanner.nextLine();//Lưu giá trị người dùng nhập vào biến

                System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10s\n", "Mã nhân viên", "|", "Tên nhân viên", "|", "Tuổi", "|", "HS Lương", "|", "Ngày vào làm", "|", "Ngày nghỉ phép", "|", "Bộ phận", "|", "Số giờ làm thêm/Chức vụ", "|", "Lương");//Hiển thị tiêu đề trong danh sách.
                for (Staff staff : staffList) {//Duyệt qua staffList để tìm kiếm thông tin tất cả nhân viên.

                    if (staff.getName().toLowerCase().contains(searchName.toLowerCase())) {//Nếu giá trị người dùng nhập vào có nằm trong tên nhân viên.
                        staff.displayInformation();//Gọi hàm displayInformation() trên phần tử staffList trùng với tìm kiếm để hiển thị thông tin.
                        searchCheck = true;//Có nhân viên thoả tìm kiếm.
                    }

                }
                if (!searchCheck)
                    System.out.println("Không tìm thấy nhân viên như bạn cần");//Không có nhân viên thoả tìm kiếm.
            }

            if (searchChosen == 2) {//Tìm kiếm nhân viên bằng mã.

                System.out.println("Nhập mã nhân viên cần tìm: ");
                searchId = scanner.nextLine();//Lưu giá trị người dùng nhập vào biến

                System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10s\n", "Mã nhân viên", "|", "Tên nhân viên", "|", "Tuổi", "|", "HS Lương", "|", "Ngày vào làm", "|", "Ngày nghỉ phép", "|", "Bộ phận", "|", "Số giờ làm thêm/Chức vụ", "|", "Lương");//Hiển thị tiêu đề trong danh sách.

                //Duyệt qua staffList để tìm nhân viên thoả giá trị tìm kiếm của người dùng.
                for (Staff staff : staffList) {
                    if (staff.getId().equals(searchId)) {//Mã nhân viên trùng với mã tìm kiếm

                        staff.displayInformation();//Gọi hàm displayInformation() trên phần tử staffList trùng với tìm kiếm để hiển thị thông tin.
                        searchCheck = true;//Có nhân viên thoả tìm kiếm.

                    }
                }
                if (!searchCheck)
                    System.out.println("Không tìm thấy nhân viên như bạn cần");//Không có nhân viên thoả tìm kiếm.
            }

        } while (searchChosen != 1 && searchChosen != 2);//Người dùng chọn khác 1 và 2 thì tiếp tục hỏi lại.
    }

    /**
     * Hiển thị bảng lương của nhân viên toàn công ty.
     */
    public static void chucNang6() {

        System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10s\n", "Mã nhân viên", "|", "Tên nhân viên", "|", "Tuổi", "|", "HS Lương", "|", "Ngày vào làm", "|", "Ngày nghỉ phép", "|", "Bộ phận", "|", "Số giờ làm thêm/Chức vụ", "|", "Lương");//Hiển thị tiêu đề trong danh sách.
        Collections.sort(staffList, ((o1, o2) -> Float.compare(((ICalculator) (o2)).calculateSalary(), ((ICalculator) (o1)).calculateSalary())));
        staffList.forEach(Staff::displayInformation);//So sánh 2 giá trị lương của o1 và o2 (o1 là phần tử trước và o2 là phần tử sau trong list), nếu như o2>o1 thì đổi chỗ.

    }

    /**
     * Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.
     */
    public static void chucNang7() {

        System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10s\n", "Mã nhân viên", "|", "Tên nhân viên", "|", "Tuổi", "|", "HS Lương", "|", "Ngày vào làm", "|", "Ngày nghỉ phép", "|", "Bộ phận", "|", "Số giờ làm thêm/Chức vụ", "|", "Lương");//Hiển thị tiêu đề trong danh sách.
        Collections.sort(staffList, ((o1, o2) -> Float.compare(((ICalculator) (o1)).calculateSalary(), ((ICalculator) (o2)).calculateSalary())));//So sánh các phần tử
        staffList.forEach(Staff::displayInformation);//So sánh 2 giá trị lương của o1 và o2 (o1 là phần tử trước và o2 là phần tử sau trong list), nếu như o1>o2 thì đổi chỗ.

    }
}
