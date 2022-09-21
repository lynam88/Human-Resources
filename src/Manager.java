/**
 * class Manager chứa thông tin chung về nhân viên quản lý, kế thừa class Staff và triển khai interface ICalculator
 */
public class Manager extends Staff implements ICalculator {

    //Khai báo thuộc tính
    private String position;//Biến lưu chức danh
    private float reposibleWage;//Biến lưu lương trách nhiệm

    /**
     * Hàm khởi tạo của class Manager
     *
     * @param id
     * @param name
     * @param age
     * @param coefficient
     * @param date
     * @param daysOff
     * @param departmentName
     * @param position
     */
    public Manager(String id, String name, int age, float coefficient, String date, int daysOff, String departmentName, String position) {
        super(id, name, age, coefficient, date, daysOff, departmentName);
        this.position = position;
    }

    /**
     * Phương thức getPosition() trả về chức danh quản lý
     *
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * Hàm calculateSalary() ghi đè hàm calculateSalary() bên interface ICalculator để trả về lương nhân viên quản lý
     *
     * @return
     */
    @Override
    public float calculateSalary() {

        switch (position) {
            case "Business Leader" -> reposibleWage = 8000000;
            case "Project Leader" -> reposibleWage = 5000000;
            case "Technical Leader" -> reposibleWage = 6000000;
        }
        return super.getCoefficient() * 5000000 + reposibleWage;

    }

    /**
     * Hàm displayInformation() ghi đè hàm displayInformation() bên class Staff để hiển thị thông tin nhân viên quản lý.
     */
    @Override
    public void displayInformation() {
        System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10.2f\n", super.getId(), "|", super.getName(), "|", super.getAge(), "|", super.getCoefficient(), "|", super.getDate(), "|", super.getDaysOff(), "|", super.getDepartmentName(), "|", position, "|", calculateSalary());
    }

}
