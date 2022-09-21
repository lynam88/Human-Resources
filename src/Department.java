/**
 * class Department chứa thông tin chung về bộ phận làm việc
 */
public class Department {

    //Khai báo thuộc tính
    private final String departmentId;// Biến lưu mã bộ phận
    private String departmentName;// Biến lưu tên bộ phận
    private int departmentNumber;// Biến lưu số lượng nhân viên hiện tại

    /**
     * Hàm khởi tạo của class Department
     *
     * @param departmentId
     * @param departmentName
     * @param departmentNumber
     */
    public Department(String departmentId, String departmentName, int departmentNumber) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentNumber = departmentNumber;

    }

    /**
     * Phương thức getDepartmentId() trả về mã bộ phận
     *
     * @return
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * Phương thức getDepartmentId() trả về tên bộ phận
     *
     * @return
     */
    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
        return departmentNumber;
    }

    /**
     * Phương thức toString() ghi đè phương thức toString của class Object
     *
     * @return
     */
    @Override
    public String toString() {

        return String.format("%-15s %s %-20s %s %-10s\n", departmentId, "|", departmentName, "|", departmentNumber);

    }
}
