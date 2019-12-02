import { TaskPriority } from './task-priority';
import { TaskStatus } from './task-status';
import { TaskComment } from './task-comment';
import { TaskLabel } from './task-labels';
import { User } from './user';

export interface Task {
    id: number;
    name: string;
    description: string;
    status: TaskStatus;
    dueDate: Date;
    createdAt: Date;
    lastModification: Date;
    priority: TaskPriority;
    comments: TaskComment[];
    labels: TaskLabel[];
    user: string;
  }
