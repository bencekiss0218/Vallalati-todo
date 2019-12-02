import { Task } from './../domain/task';
import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  constructor(public taskService: TaskService) { }

  ngOnInit() {
    this.taskService.getTasks();
  }

  async delete(task: Task) {
    await this.taskService.deleteTask(task);
  }
}
