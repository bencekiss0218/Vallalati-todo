import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';
import { Task } from '../domain/task';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  task: Task;
  constructor(private route: ActivatedRoute, private taskService: TaskService, private router: Router) {}

  async ngOnInit() {
    const taskId = parseInt(this.route.snapshot.params.id);
    this.task = await this.taskService.getTaskById(taskId);
  }

  async modifyTask(task: Task) {
    task.id = this.task.id;
    await this.taskService.modifyTask(task);
    this.router.navigate(['/', 'tasks']);
  }

}
