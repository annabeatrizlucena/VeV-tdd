package main;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

	private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

	public int getNumberOfTasks() {
		return this.tasks.size();
	}
	
	public String listTasks() {
		String listTasks = "";
		for (Task task : this.tasks) {
			listTasks = listTasks + task.toString() + ",\n";
		}
		return listTasks;
	}

	public String addTask(Task newTask) {
		this.tasks.add(newTask);
		return newTask.getId();
	}

	public void deleteTask(String taskId) {
		this.tasks.removeIf(task -> task.getId().equals(taskId));
	}

	public Task getTask(String taskId) {
        return tasks.stream().filter(task -> task.getId().equals(taskId)).findFirst().orElse(null);
    }

    public void setTaskPriority(String taskId, Priority priority) {
        Task taskToUpdate = getTask(taskId);
        if (taskToUpdate != null) {
            taskToUpdate.setPriority(priority);
        }
    }
}
