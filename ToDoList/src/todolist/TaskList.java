package todolist;

import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskList {
    private String listName;
    private ObservableList<Task> tasks;
    
    TaskList(String name) {
        listName = name;
        tasks = FXCollections.<Task>observableArrayList();
    }
    
    public String getListName() { return listName; }
    public ObservableList<Task> getTasks() { return tasks; }
    
    public void setListName(String n) { listName = n; }
    
    public void addToList(Task t) { this.tasks.add(t); } //Adds a task to a list
    
    public static void sortListByImportance(ObservableList<Task> list) { //Sorts a list by importance
        Comparator<Task> comparator = Comparator.comparingInt(Task::getImportance);
        FXCollections.sort(list, comparator);
    }
    
    public static void sortListByDate(ObservableList<Task> list) {
        Comparator<Task> comparator = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.getDueDate()== null || t2.getDueDate() == null) { return 0; }
                else { return t1.getDueDate().compareTo(t2.getDueDate()); }
            }
        };
        Collections.sort(list, comparator);
    }
    
    @Override
    public String toString() { return listName; }
    
}
