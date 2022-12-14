public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Голубев Касьян Михайлович", 1, 10_023);
        employeeBook.addEmployee("Гурьев Федор Леонидович", 1, 15_023);
        employeeBook.addEmployee("Аксёнов Аввакум Егорович", 1, 20_000);
        employeeBook.removeEmployee(3);
        employeeBook.removeEmployee(2);
        employeeBook.addEmployee("Стрелков Юлий Андреевич", 1, 21_000);
        employeeBook.addEmployee("Гришин Савелий Валерьевич", 2, 21_000);

        employeeBook.printEmployeesList();
        employeeBook.printTotalSalaries();
        employeeBook.printAverageSalary();
        employeeBook.findEmployeeWithMinSalary();
        employeeBook.findEmployeeWithMaxSalary();
        employeeBook.printEmployeesFullName();

        employeeBook.indexEmployeesSalary(10);

        employeeBook.printEmployeesListByDep(1);
        employeeBook.printTotalSalariesByDep(1);
        employeeBook.printAverageSalaryByDep(1);
        employeeBook.findEmployeeWithMinSalaryByDep(1);
        employeeBook.findEmployeeWithMaxSalaryByDep(1);
        employeeBook.indexEmployeesSalaryByDep(1, 10);

        employeeBook.printEmployeesWithSalaryLessValue(21_000);
        employeeBook.printEmployeesWithSalaryMoreValue(13_000);

        employeeBook.changeEmployeeData("Гришин Савелий Валерьевич",3,10000);
        employeeBook.printEmployeesListWithDeps();
    }
}