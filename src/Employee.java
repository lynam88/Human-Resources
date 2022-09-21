/**
 * class Employee chứa thông tin chung về nhân viên thông thường, kế thừa class Staff và triển khai interface ICalculator
 */
public class Employee extends Staff implements ICalculator {

    //Khai báo thuộc tính
    private int overTime;//Biến lưu số giờ làm thêm.

    /**
     * Hàm khởi tạo của class Employee
     *
     * @param id
     * @param name
     * @param age
     * @param coefficient
     * @param date
     * @param daysOff
     * @param departmentName
     * @param overTime
     */
    public Employee(String id, String name, int age, float coefficient, String date, int daysOff, String departmentName, int overTime) {
        super(id, name, age, coefficient, date, daysOff, departmentName);
        this.overTime = overTime;
    }

    /**
     * Hàm calculateSalary() ghi đè hàm calculateSalary() bên interface ICalculator để trả về lương nhân viên thông thường
     *
     * @return
     */
    @Override
    public float calculateSalary() {
        return super.getCoefficient() * 3000000 + overTime * 200000;
    }

    /**
     * Hàm displayInformation() ghi đè hàm displayInformation() bên class Staff để hiển thị thông tin nhân viên thông thường.
     */
    @Override
    public void displayInformation() {

        System.out.printf("%-15s %s %-20s %s %-10s %s %-10s %s %-20s %s %-15s %s %-20s %s %-25s %s %-10.2f\n", super.getId(), "|", super.getName(), "|", super.getAge(), "|", super.getCoefficient(), "|", super.getDate(), "|", super.getDaysOff(), "|", super.getDepartmentName(), "|", overTime, "|", calculateSalary());
    }

}
