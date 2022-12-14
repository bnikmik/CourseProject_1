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

    public static void printEmployeesListByDep(int department) {
        System.out.println("Список всех сотрудников из отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Сотрудник №" + employee.getId()
                        + ": " + employee.getFullName()
                        + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public static void printTotalSalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaries += employee.getSalary();
            }
        }
        System.out.println("Сумма всех заработных плат: " + totalSalaries);
    }

    public static void printTotalSalariesByDep(int department) {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalaries += employee.getSalary();
            }
        }
        System.out.println("Сумма всех заработных плат в отделе " + department + ": " + totalSalaries);
    }

    public static void printAverageSalary() {
        double totalSalaries = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaries += employee.getSalary();
                count++;
            }
        }
        double aveSum = totalSalaries / count;
        System.out.printf("Среднее значение зарплат: %.2f", aveSum);
    }

    public static void printAverageSalaryByDep(int department) {
        double totalSalaries = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalaries += employee.getSalary();
                count++;
            }
        }
        double aveSum = totalSalaries / count;
        System.out.printf("Среднее значение зарплат в отделе " + department + ": %.2f", aveSum);
    }

    public static void findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                temp = i;
            }
        }
        System.out.println("Минимальная зарплата: " + employees[temp]);
    }

    public static void findEmployeeWithMinSalaryByDep(int department) {
        double minSalary = Double.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary && employees[i].getDepartment() == department) {
                minSalary = employees[i].getSalary();
                temp = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой из отдела " + department + ": " + employees[temp].getFullName());
    }

    public static void findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                temp = i;
            }
        }
        System.out.println("Максимальная зарплата: " + employees[temp]);
    }

    public static void findEmployeeWithMaxSalaryByDep(int department) {
        double maxSalary = Double.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary && employees[i].getDepartment() == department) {
                maxSalary = employees[i].getSalary();
                temp = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой из отдела " + department + ": " + employees[temp].getFullName());
    }

    public static void printEmployeesFullName() {
        System.out.println("Список ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public static void indexEmployeesSalary(double increasePercent) {
        increasePercent = increasePercent / 100;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * increasePercent + employee.getSalary());
            }
        }
    }

    public static void indexEmployeesSalaryByDep(int department, double increasePercent) {
        increasePercent = increasePercent / 100;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * increasePercent + employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryLessValue(double salary) {
        System.out.println("Список сотрудников с зарплатой меньше " + salary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Сотрудник №" + employee.getId()
                        + ": " + employee.getFullName()
                        + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryMoreValue(double salary) {
        System.out.println("Список сотрудников с зарплатой больше (или равной)" + salary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("Сотрудник №" + employee.getId()
                        + ": " + employee.getFullName()
                        + ". Зарплата: " + employee.getSalary());
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
        printTotalSalaries();
        printAverageSalary();
        findEmployeeWithMinSalary();
        findEmployeeWithMaxSalary();
        printEmployeesFullName();

        indexEmployeesSalary(10);

        printEmployeesListByDep(1);
        printTotalSalariesByDep(1);
        printAverageSalaryByDep(1);
        findEmployeeWithMinSalaryByDep(1);
        findEmployeeWithMaxSalaryByDep(1);
        indexEmployeesSalaryByDep(1, 10);

        printEmployeesWithSalaryLessValue(21_000);
        printEmployeesWithSalaryMoreValue(13_000);
    }
}