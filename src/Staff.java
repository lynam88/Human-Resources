/**
 * Class Staff là class abstract chứa các thông tin cơ bản của nhân viên
 */
public abstract class Staff {

    //Khai báo thuộc tính
    private String id;//Biến lưu mã nhân viên
    private String name; //Biến lưu tên nhân viên
    private int age;//Biến lưu tuổi nhân viên
    private float coefficient;//Biến lưu hệ số lương
    private String date;//Biến lưu ngày vào làm
    private String departmentName;//Biến lưu tên bộ phận làm việc
    private int daysOff;//Biến lưu số ngày nghỉ phép

    /**
     * Hàm khởi tạo của class Staff
     *
     * @param id
     * @param name
     * @param age
     * @param coefficient
     * @param date
     * @param daysOff
     * @param departmentName
     */
    public Staff(String id, String name, int age, float coefficient, String date, int daysOff, String departmentName) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficient = coefficient;
        this.date = date;
        this.departmentName = departmentName;
        this.daysOff = daysOff;

    }

    /**
     * Phương thức getId trả về mã nhân viên
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Phương thức getName trả về tên nhân viên
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Phương thức getAge trả về tên nhân viên
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Phương thức getCoefficient trả về hệ số lương
     *
     * @return
     */
    public float getCoefficient() {
        return coefficient;
    }

    /**
     * Phương thức getDate trả về ngày vào làm
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Phương thức getDaysOff trả về ngày vào làm
     *
     * @return
     */
    public int getDaysOff() {
        return daysOff;
    }

    /**
     * Phương thức getDepartmentName trả về tên bộ phận làm việc
     *
     * @return
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Hàm displayInformation() là hàm abstract, hiển thị thông tin nhân viên.
     */
    public abstract void displayInformation();
}
