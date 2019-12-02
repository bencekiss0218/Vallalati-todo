import { Injectable } from '@angular/core';
import { Task } from '../domain/task';
import { HttpClient } from '@angular/common/http';
import { TaskComment } from './../domain/task-comment';
import { TaskLabel } from './../domain/task-labels';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  tasks: Task[] = [];
  filteredTasks: Task[] = this.tasks;

  constructor(
    private http: HttpClient
  ) { }

  async getTasks() {
    const tasks = await (this.http.get('tasks')
      .toPromise() as Promise<any[]>);
    this.filteredTasks = this.tasks = tasks.map(this.createTaskModel);
  }

  async getTaskById(taskId: number): Promise<Task> {
    const task = await (this.http.get(`tasks/${taskId}`)
      .toPromise() as Promise<any>);
    return task;
  }

  async createTask(task: Task): Promise<any> {
    await this.http.post('tasks', task).toPromise();
  }

  async modifyTask(task: Task): Promise<any> { // ez szar
    await this.http.patch(`tasks/${task.id}`, task).toPromise();
  }

  async deleteTask(task: Task): Promise<any> {
    await this.http.delete(`tasks/${task.id}`).toPromise();
  }

  filterChange(filterValue: string) {
    if (typeof filterValue === 'string') {
      if (filterValue === '') {
        this.filteredTasks = this.tasks;
      } else {
        this.filteredTasks = this.tasks.filter(task => {
          return task.status === filterValue;
        });
      }
    }
  }

  private createTaskModel(task: any): Task {
    return {
      ...task,
    } as Task;
  }
}
