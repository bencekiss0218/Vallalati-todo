import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';
import { Task } from '../domain/task';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {

  task: Task;
  constructor(private route: ActivatedRoute, private taskService: TaskService, private router: Router) {}

  async ngOnInit() {
    // tslint:disable-next-line:radix
    const taskId = parseInt(this.route.snapshot.params.id);
    this.task = await this.taskService.getTaskById(taskId);
  }

}
