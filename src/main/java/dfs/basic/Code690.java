package dfs.basic;

import java.util.HashMap;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/10/8 7:44 下午
 * Description:
 */
public class Code690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map.get(id), map);
    }

    private int dfs(Employee employee, HashMap<Integer, Employee> map) {
        int importance = employee.importance;

        for (Integer id : employee.subordinates) {
            importance += dfs(map.get(id), map);
        }
        return importance;
    }
}
