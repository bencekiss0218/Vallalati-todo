import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Task } from '../domain/task';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {

  // @Input() mode: 'create';
  @Input() task: Task;
  @Output() submitTask: EventEmitter<Task> = new EventEmitter();

  constructor() { }

  ngOnInit() {}

  async addTask(form: FormGroup) {
    if (!form.valid) {
      return;
    }
    this.submitTask.emit(form.getRawValue() as Task);
  }
}
