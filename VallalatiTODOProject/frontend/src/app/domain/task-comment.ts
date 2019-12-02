import { User } from './user';
import { Task } from './task';

export interface TaskComment {
    user: User;
    body: string;
    createdAt: Date;
    task: Task;
}
