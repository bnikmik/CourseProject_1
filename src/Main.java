public class Main {
    static Employee[] employees = new Employee[10];

    public static void printEmployeesList() {
        System.out.println("Список всех сотрудников со всеми данными:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double printTotalSalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaries += employee.getSalary();
            }
        }
        return totalSalaries;
    }

    public static double printAverageSalary() {
        double aveSum = printTotalSalaries() / Employee.getCount();
        return aveSum;
    }

    public static Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                temp = i;
            }
        }
        return employees[temp];
    }

    public static Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                temp = i;
            }
        }
        return employees[temp];
    }

    public static void printEmployeesFullName() {
        System.out.println("Список ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public static void main(String[] args) {
        employees[0] = new Employee("Голубев Касьян Михайлович", 1, 10_023);
        employees[1] = new Employee("Гурьев Федор Леонидович", 1, 15_023);
        employees[2] = new Employee("Аксёнов Аввакум Егорович", 1, 20_000);
        employees[3] = new Employee("Стрелков Юлий Андреевич", 3, 21_000);
        employees[4] = new Employee("Гришин Савелий Валерьевич", 2, 21_500);
        printEmployeesList();
        System.out.println("Сумма всех заработных плат: " + printTotalSalaries());
        System.out.println("Среднее значение зарплат: " + printAverageSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeWithMaxSalary());
        printEmployeesFullName();
    }
}