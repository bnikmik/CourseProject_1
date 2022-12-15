import java.util.Arrays;

public class EmployeeBook {
    private static Employee[] employees = new Employee[0];//Попробовал создать с пустым массивом сотрудников

    public void addEmployee(String fullName, int department, double salary) {
        Employee employee = new Employee(fullName, department, salary);
        Employee[] temp = employees.clone();
        employees = new Employee[employees.length + 1];
        System.arraycopy(temp, 0, employees, 0, temp.length);
        employees[employees.length - 1] = employee;
        System.out.println("Новый сотрудник - " + employees[employees.length - 1].getFullName());
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                System.out.println("Уволен сотрудник" + employees[i].getFullName());
                System.arraycopy(employees, i + 1, employees, i, employees.length - i - 1);
                employees = Arrays.copyOf(employees, employees.length - 1);
                break;
            }
        }
    }

    public void printEmployeesList() {
        System.out.println("Список всех сотрудников со всеми данными:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void printEmployeesListByDep(int department) {
        System.out.println("Список всех сотрудников из отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Сотрудник №" + employee.getId()
                        + ": " + employee.getFullName()
                        + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesListWithDeps() {
        int size = 0;
        int temp = 0;
        int[] departments = new int[size];
        for (Employee employee : employees) {  //Собираю список отделов, в которых есть сотрудники
            if (employee != null && employee.getDepartment() != temp) {
                temp = employee.getDepartment();
                int[] tempArray = departments.clone();
                departments = new int[departments.length + 1];
                System.arraycopy(tempArray, 0, departments, 0, tempArray.length);
                departments[departments.length - 1] = temp;
                size++;
            }
        }
        Arrays.sort(departments);
        for (int department : departments) {  //Печатаю список отделов и их сотрудников
            System.out.println("Сотрудники из отдела " + department + ": ");
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getFullName());
                }
            }
        }
    }

    public void printTotalSalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalaries += employee.getSalary();
            }
        }
        System.out.println("Сумма всех заработных плат: " + totalSalaries);
    }

    public void printTotalSalariesByDep(int department) {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalaries += employee.getSalary();
            }
        }
        System.out.println("Сумма всех заработных плат в отделе " + department + ": " + totalSalaries);
    }

    public void printAverageSalary() {
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
        System.out.println();
    }

    public void printAverageSalaryByDep(int department) {
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
        System.out.println();
    }

    public void findEmployeeWithMinSalary() {
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

    public void findEmployeeWithMinSalaryByDep(int department) {
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

    public void findEmployeeWithMaxSalary() {
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

    public void findEmployeeWithMaxSalaryByDep(int department) {
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

    public void printEmployeesFullName() {
        System.out.println("Список ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexEmployeesSalary(double increasePercent) {
        increasePercent = increasePercent / 100;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * increasePercent + employee.getSalary());
            }
        }
    }

    public void indexEmployeesSalaryByDep(int department, double increasePercent) {
        increasePercent = increasePercent / 100;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * increasePercent + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryLessValue(double salary) {
        System.out.println("Список сотрудников с зарплатой меньше " + salary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Сотрудник №" + employee.getId()
                        + ": " + employee.getFullName()
                        + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryMoreValue(double salary) {
        System.out.println("Список сотрудников с зарплатой больше (или равной)" + salary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("Сотрудник №" + employee.getId()
                        + ": " + employee.getFullName()
                        + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public void changeEmployeeData(String fullName, int department, double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
                employee.setSalary(salary);
            }
        }
    }
}
